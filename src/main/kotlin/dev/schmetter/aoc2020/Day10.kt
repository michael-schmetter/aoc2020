package dev.schmetter.aoc2020

import kotlin.collections.HashMap


class Day10(input: String) {

    private var xmas = input.split(",").map { it.toInt() }.toIntArray()

    fun solvePart1(): Int {
        var numOf1Jumps = 1
        var numOf3Jumps = 1
        xmas.sort()
        var i = 0
        while (i < xmas.size - 1) {
            var diff = xmas[i + 1] - xmas[i]
            when (diff) {
                1 -> numOf1Jumps++
                3 -> numOf3Jumps++
            }
            i++
        }
        return numOf1Jumps * numOf3Jumps
    }


    fun solvePart2(): Long {
        val solutions = HashMap<Int, Long>()
        val sorted = xmas.sortedDescending().plus(0)
        solutions[sorted[0]] = 1
        sorted.drop(1).forEach { i: Int ->
            var solution = 0L
            for (j in i + 1..i + 3) {
                solution += solutions[j] ?: 0
            }
            solutions[i] = solution
        }
        return solutions[0] ?: -1
    }
}