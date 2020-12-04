package dev.schmetter.aoc2020

class Day04(input: String) {
    private var passports: List<Map<String, String>>

    init {
        passports = input.replace("\r\n", " ").split(",").map { s ->
            s.split("\\s".toRegex()).associate { elem ->
                val (left, right) = elem.split(":")
                left to right
            }
        }
    }

    fun solvePart1(): Int {
        var validPassports = 0
        val required = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
        for (passport in passports) {
            if (checkPassportSimple(passport, required))
                validPassports++
        }
        return validPassports
    }

    fun solvePart2(): Int {
        var validPassports = 0
        val required = mapOf(
            "byr" to { elem: String -> elem.toInt() in 1920..2002 },
            "iyr" to { elem: String -> elem.toInt() in 2010..2020 },
            "eyr" to { elem: String -> elem.toInt() in 2020..2030 },
            "hgt" to { elem: String -> validateHeight(elem) },
            "hcl" to { elem: String -> "#[0-9a-f]{6}".toRegex().matches(elem)},
            "ecl" to { elem: String -> "amb|blu|brn|gry|grn|hzl|oth".toRegex().matches(elem)},
            "pid" to { elem: String -> "\\d{9}".toRegex().matches(elem)}
        )
        for (passport in passports) {
            if (checkPassportAdvanced(passport, required))
                validPassports++
        }
        return validPassports
    }

    private fun validateHeight(elem: String): Boolean {
        val num = elem.substring(0, elem.length - 2)

        return when (elem.substring(elem.length - 2)) {
            "in" -> num.toInt() in 59..76
            "cm" -> num.toInt() in 150..193
            else -> false
        }
    }


    private fun checkPassportSimple(passport: Map<String, String>, required: Set<String>): Boolean {
        return required.all { entry -> passport.containsKey(entry) }
    }

    private fun checkPassportAdvanced(passport: Map<String, String>, required: Map<String, (String) -> Boolean>): Boolean {
        return required.all { entry ->
            passport.containsKey(entry.key) && passport[entry.key]?.let { entry.value.invoke(it) } == true
        }
    }
}