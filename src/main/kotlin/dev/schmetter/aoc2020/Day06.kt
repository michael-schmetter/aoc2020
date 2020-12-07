package dev.schmetter.aoc2020

class Day06(input: String) {
    private var groupAnswers: List<List<String>>

    init {
        groupAnswers = input.split(",").map { s ->
            s.split("\r\n")
        }
    }

    fun solvePart1(): Int {
        var size = 0
        for (group in groupAnswers) {
            var set = HashSet<String>()
            for (answers in group) {
                set.addAll(answers.toCharArray().map { it.toString() }.toTypedArray())
            }
            size += set.size
        }
        return size
    }


    fun solvePart2(): Int {
        var size = 0
        for (group in groupAnswers) {
            var set = HashSet<String>()
            group.forEachIndexed { index, answers ->
                var answersSplitted = answers.toCharArray().map { it.toString() }.toTypedArray()
                if (index == 0) {
                    set.addAll(answersSplitted)
                }
                set.retainAll(answersSplitted)
            }
            size += set.size
        }
        return size
    }

}