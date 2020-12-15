package dev.schmetter.aoc2020

class Day15(input: String) {
    private var num = input.split(",").map { s -> s.toLong() }
    private var usedNum = HashMap<Long, Pair<Long,Long>>()

    init {
        for (i in num.indices) {
            usedNum[num[i]]=Pair(-1,i.toLong())
        }
    }

    fun solvePart1(): Long {
        var last = num.last()
        var wasFirst=true
        for(i in num.size until 30000000){
            var l = i.toLong()
            if(wasFirst){
                if(usedNum.containsKey(0)){
                    last=0
                    wasFirst=false
                    usedNum[0]=Pair( usedNum[0L]!!.second,l)
                }else{
                    last=0
                    usedNum[0]=Pair(-1,l)
                }
            }else{
                var pair = usedNum[last]!!
                last = pair.second-pair.first
                if(!usedNum.containsKey(last)){
                    wasFirst=true
                    usedNum[last]=Pair(-1,l)
                }else{
                    usedNum[last]=Pair(usedNum[last]!!.second,l)
                }
            }
        }
        return last
    }

    fun solvePart2(): Long {
        return solvePart1()
    }
}