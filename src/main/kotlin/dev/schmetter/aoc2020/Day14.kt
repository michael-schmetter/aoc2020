package dev.schmetter.aoc2020

class Day14(input: String) {
    private var lines = input.split(",")
    private val maskPrefix = "mask = "

    fun solvePart1(): Long {
        var currMask = ""
        var mem = LongArray(99999)
        for(line in lines){
            if(line.startsWith(maskPrefix)){
                currMask=line.substringAfter(maskPrefix)
            }else{
                var i = line.subSequence(line.indexOf("[")+1,line.indexOf("]")).toString().toInt()
                var value = Integer.toBinaryString(line.substringAfter(" = ").toInt()).padStart(currMask.length,'0')
                mem[i] = value.mapIndexed { index, c ->
                    if(currMask[index]!='X'){
                        currMask[index]
                    }else{
                        c
                    }
                }.joinToString("").toLong(2)
            }
        }
        return mem.sum()
    }

    fun solvePart2(): Long {
        var currMask = ""
        var mem = mutableMapOf<Long, Int>()
        for(line in lines){
            if(line.startsWith(maskPrefix)){
                currMask=line.substringAfter(maskPrefix)
            }else{
                var i = Integer.toBinaryString(line.subSequence(line.indexOf("[")+1,line.indexOf("]")).toString().toInt()).padStart(currMask.length,'0').toCharArray()
                var value = line.substringAfter(" = ").toInt()
                var addresses = mutableSetOf<CharArray>()
                addresses.add(i)
                for(j in currMask.indices){
                    if(currMask[j]=='0')
                        continue
                    if(currMask[j]=='1'){
                        for (addr in addresses) addr[j]='1'
                    }else{
                        var newaddresses = mutableSetOf<CharArray>()
                        for (addr in addresses) {
                            addr[j]='0'
                            var naddr = addr.copyOf()
                            naddr[j]='1'
                            newaddresses.add(naddr)
                        }
                        addresses.addAll(newaddresses)
                    }
                }
                for (addr in addresses) {
                    mem[addr.joinToString("").toLong(2)]=value
                }
            }
        }
        var sum = 0L
        mem.forEach {
            sum+=it.value
        }
        return sum
    }
}