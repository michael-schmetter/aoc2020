package dev.schmetter.aoc2020

class Day19(input: String) {

    private var lines = input.split("~").last().split("\r\n")


    private val rules1 = input.split("~").first().split("\r\n")
        .map { it.split(":").let { (id, rule) -> id.toInt() to rule.trim() } }
        .toMap()
    private val rules2 = rules1 + listOf(8 to "42 | 42 8", 11 to "42 31 | 42 11 31").toMap()

    private fun match(ruleMap: Map<Int, String>, l: CharSequence, r: List<Int>): Boolean {
        if (l.isEmpty()) {
            return r.isEmpty()
        } else if (r.isEmpty()) {
            return false
        }
        return ruleMap.getValue(r[0]).let { rule ->
            if (rule[1] in 'a'..'z') {
                if (l.startsWith(rule[1])) {
                    match(ruleMap, l.drop(1), r.drop(1))
                } else false
            } else rule.split(" | ").any {
                match(ruleMap, l, it.split(" ").map(String::toInt) + r.drop(1))
            }
        }
    }


    fun solvePart1(): Int {
        return lines.count { match(rules1, it, listOf(0)) }
    }


    fun solvePart2(): Int {
        return lines.count { match(rules2, it, listOf(0)) }
    }
}