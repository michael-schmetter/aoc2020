package dev.schmetter.aoc2020

enum class CompletionState{COMPLETE,INFINITE_LOOP}

data class Instruction(var op: String, val arg: Int, var ran: Boolean)
data class Completion(var acc: Int, val result: CompletionState)

class Gameboy(instructions: List<String>) {

    private var acc = 0
    private var inst = instructions.map { Instruction(it.split(" ")[0], it.split(" ")[1].toInt(),false) }
    private var i = 0

    fun run(): Completion {
        while (i<inst.size) {
            if(inst[i].ran){
                return Completion(acc,CompletionState.INFINITE_LOOP)
            }
            inst[i].ran=true
            when (inst[i].op) {
                "acc" -> {
                    acc += inst[i].arg
                    i++
                }
                "jmp" -> i += inst[i].arg
                else -> i++
            }
        }
        return Completion(acc,CompletionState.COMPLETE)
    }

}
