package dev.schmetter.aoc2020

class Day08(input: String) {

    private var instructions = input.split(",")


    fun solvePart1(): Int {
        var gameboy = Gameboy(instructions)
        return gameboy.run().acc
    }


    fun solvePart2(): Int {
        var i = 0
        while (i < instructions.size) {
            var newInst = instructions.toMutableList()
            if (instructions[i].contains("jmp")) {
                newInst[i] = newInst[i].replace("jmp", "nop")
            } else if (instructions[i].contains("nop")) {
                newInst[i] = newInst[i].replace("nop", "jmp")
            }
            var gameboy = Gameboy(newInst)
            var ret = gameboy.run()
            if(ret.result==CompletionState.COMPLETE)
                return ret.acc
            i++
        }
        return -1
    }

}