package dev.schmetter.aoc2020

class Day01(input: String) {
    private val expenses = input.split(",").map { it.toInt() }.toIntArray()
    fun solvePart1(): Int {
        for (i in expenses.indices) {
            for (j in i..expenses.size-1) {
                if(expenses[i]+expenses[j]==2020){
                    return expenses[i]*expenses[j]
                }
            }
        }
        return 0
    }

    fun solvePart2(): Int {
        for (i in expenses.indices) {
            for (j in i..expenses.size-1) {
                for (k in j..expenses.size-1) {
                    if(expenses[i]+expenses[j]+expenses[k]==2020){
                        return expenses[i]*expenses[j]*expenses[k]
                    }
                }
            }
        }
        return 0
    }
}
