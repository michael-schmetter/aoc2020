package dev.schmetter.aoc2020

import java.util.*

class Day09(input: String) {

    private var xmas = input.split(",").map { it.toLong() }.toLongArray()

    fun solvePart1(preambleLength: Int): Long {
        var i = preambleLength
        while (i < xmas.size) {
            try {
                getPair(xmas.copyOfRange(i - preambleLength, i), xmas[i])
            } catch (e: InvalidPropertiesFormatException) {
                return xmas[i]
            }
            i++
        }
        return 0
    }

    private fun getPair(arr: LongArray, sum: Long): Pair<Long, Long> {
        for (i in arr.indices) {
            for (j in i until arr.size) {
                if (arr[i] + arr[j] == sum) {
                    return Pair(arr[i], arr[j])
                }
            }
        }
        throw InvalidPropertiesFormatException("Not found")
    }

    private fun findSum(sumToFind: Long): Pair<Long?, Long?> {
        for (i in xmas.indices) {
            var sum = xmas[i]
            for (j in i+1 until xmas.size) {
                sum += xmas[j]
                if (sum == sumToFind) {
                    var foundArr = xmas.copyOfRange(i, j+1)
                    return Pair(foundArr.minOrNull(), foundArr.maxOrNull())
                }
            }
        }
        throw InvalidPropertiesFormatException("Not found")
    }


    fun solvePart2(faulty: Long): Long? {
        var pair = findSum(faulty)
        return pair.second?.let { pair.first?.plus(it) }
    }

}