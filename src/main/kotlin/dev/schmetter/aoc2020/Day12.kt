package dev.schmetter.aoc2020

import kotlin.math.absoluteValue


class Day12(input: String) {
    data class Inst(var op: Char, val arg: Int)

    private var instructions = input.split(",").map { Inst(it[0], it.substring(1).toInt()) }

    private var x = 0
    private var y = 0
    private var f = 0 // E=0 , S=1, W=2, N=3
    private var wx = -1
    private var wy = 10




    fun solvePart1(): Int {
        for (inst in instructions) {
            when (inst.op) {
                'N' -> moveN(inst.arg)
                'S' -> moveS(inst.arg)
                'E' -> moveE(inst.arg)
                'W' -> moveW(inst.arg)
                'L' -> rotate(inst.arg * -1)
                'R' -> rotate(inst.arg)
                'F' -> go(inst.arg)
            }
        }
        return x.absoluteValue + y.absoluteValue
    }

    private fun moveW(inst: Int) {
        y += inst
    }

    private fun moveE(inst: Int) {
        y -= inst
    }

    private fun moveS(inst: Int) {
        x += inst
    }

    private fun moveN(inst: Int) {
        x -= inst
    }

    private fun moveWPW(inst: Int) {
        wy -= inst
    }

    private fun moveWPE(inst: Int) {
        wy += inst
    }

    private fun moveWPS(inst: Int) {
        wx += inst
    }

    private fun moveWPN(inst: Int) {
        wx -= inst
    }

    private fun go(arg: Int) {
        when (f) {
            0 -> moveE(arg)
            1 -> moveS(arg)
            2 -> moveW(arg)
            3 -> moveN(arg)
        }
    }

    private fun goToWP(arg: Int) {
        x += wx*arg
        y += wy*arg
    }

    private fun rotate(deg: Int) {
        f = (((deg % 360 / 90 % 4) + f) % 4)
        if(f<0){
            f += 4
        }
    }


    private fun rotateWP(deg: Int) {
        if(deg>0){
            for (i in 1..(deg % 360 / 90 % 4)){
                var tmp = wx
                wx = wy
                wy=-tmp
            }
        }else{
            for (i in 1..(deg % 360 / 90 % 4).absoluteValue){
                var tmp = wy
                wy = wx
                wx=-tmp
            }
        }
    }

    fun solvePart2(): Int {
        for (inst in instructions) {
            when (inst.op) {
                'N' -> moveWPN(inst.arg)
                'S' -> moveWPS(inst.arg)
                'E' -> moveWPE(inst.arg)
                'W' -> moveWPW(inst.arg)
                'L' -> rotateWP(inst.arg * -1)
                'R' -> rotateWP(inst.arg)
                'F' -> goToWP(inst.arg)
            }
        }
        return x.absoluteValue + y.absoluteValue
    }
}