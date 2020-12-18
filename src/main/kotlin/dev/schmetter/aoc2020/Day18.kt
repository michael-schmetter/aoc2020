package dev.schmetter.aoc2020

import java.util.*

class Day18(input: String) {

    private var op = Stack<Char>()
    private var output = Stack<Long>()
    private var lines = input.split(",").map { e -> e.chunked(1).filter { s -> s != " " }.map { s1 -> s1.single() } }


    fun solvePart1(): Long {
        var sum = 0L
        for (line in lines) {
            for (i in line) {
                var calc = true
                when (i) {
                    '1', '2', '3', '4', '5', '6', '7', '8', '9' -> output.push(Character.getNumericValue(i).toLong())
                    '(', '*', '+' -> {
                        op.push(i)
                        calc = false
                    }
                    ')' -> op.pop()
                }
                if (output.size > 1 && op.peek() != '(' && op.peek() != ')' && calc) {
                    when (op.pop()) {
                        '+' -> output.push(output.pop() + output.pop())
                        '*' -> output.push(output.pop() * output.pop())
                    }
                }
            }
            sum += output.pop()
        }
        return sum
    }

    fun solvePart2(): Long {
        var sum = 0L
        for (line in lines) {
            for (i in line) {
                when (i) {
                    '1', '2', '3', '4', '5', '6', '7', '8', '9' -> output.push(Character.getNumericValue(i).toLong())
                    '(', '+' -> op.push(i)
                    '*' -> {
                        while (op.isNotEmpty() && op.peek() == '+') {
                            op.pop()
                            output.push(output.pop() + output.pop())
                        }
                        op.push(i)
                    }
                    ')' -> {
                        while (op.peek() != '(') {
                            when (op.pop()) {
                                '+' -> output.push(output.pop() + output.pop())
                                '*' -> output.push(output.pop() * output.pop())
                            }
                        }
                        op.pop()
                    }
                }
            }
            while (op.isNotEmpty()) {
                when (op.pop()) {
                    '+' -> output.push(output.pop() + output.pop())
                    '*' -> output.push(output.pop() * output.pop())
                }
            }
            sum += output.pop()
        }
        return sum
    }
}