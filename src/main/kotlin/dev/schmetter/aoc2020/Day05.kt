package dev.schmetter.aoc2020

import kotlin.math.ceil
import kotlin.math.floor

class Day05(input: String) {
    private var boardingpasses = input.split(",")

    fun solvePart1(): Int {
        var maxSeatId = 0
        for (pass in boardingpasses) {
            val row = getRow(pass)
            val seat = getSeat(pass)
            val seatId = row * 8 + seat
            if (seatId > maxSeatId)
                maxSeatId = seatId
        }
        return maxSeatId
    }

    private fun getSeat(pass: String): Int {
        val seatInstructions = pass.subSequence(7, pass.length)
        return traverse(seatInstructions, 0.toDouble(), 7.toDouble()).toInt()
    }

    private fun traverse(seatInstructions: CharSequence, lower: Double, upper: Double): Double {
        if (seatInstructions.length == 1) {
            when (seatInstructions[0]) {
                'L', 'F' -> return lower
                'R', 'B' -> return upper
            }
        }
        when (seatInstructions[0]) {
            'L', 'F' -> return traverse(
                seatInstructions.subSequence(1, seatInstructions.length), lower,
                floor((lower + upper) / 2)
            )
            'R', 'B' -> return traverse(
                seatInstructions.subSequence(1, seatInstructions.length),
                ceil((lower + upper) / 2),
                upper
            )
            else -> return 0.toDouble()
        }
    }

    private fun getRow(pass: String): Int {
        val rowInstructions = pass.subSequence(0, 7)
        return traverse(rowInstructions, 0.toDouble(), 127.toDouble()).toInt()
    }

    fun solvePart2(): Int {
        var seats = Array(128) { BooleanArray(8) { false } }

        for (pass in boardingpasses) {
            val row = getRow(pass)
            val seat = getSeat(pass)
            seats[row][seat] = true
        }
        var i = 0
        var j = 0
        while (i < seats.size) {
            j=0
            while (j < seats[i].size) {
                if (!seats[i][j])
                    println("Not placed: $i | $j")
                j++
            }
            i++
        }
        return 0
    }

}