package dev.schmetter.aoc2020


class Day02(input: String) {
    private val passwords = input.split(",")
    fun solvePart1(): Int {
        var validPasswords = 0
        for (pwLine in passwords) {
            val pw = Password(pwLine)
            val count = pw.password.filter { pw.pattern.contains(it) }.count()
            if (count in pw.lower until (pw.upper + 1)) {
                validPasswords++
            }
        }
        return validPasswords
    }

    fun solvePart2(): Int {
        var validPasswords = 0
        for (pwLine in passwords) {
            val pw = Password(pwLine)
            if (pw.pattern.contains(pw.password[pw.lower - 1]).xor(pw.pattern.contains(pw.password[pw.upper - 1]))) {
                validPasswords++
            }
        }
        return validPasswords
    }
}

class Password(pwLine: String) {
    var pattern: String
    var password: String
    var lower = 0
    var upper = 0

    init {
        val parts = pwLine.split(" ")
        lower = parts[0].split("-")[0].toInt()
        upper = parts[0].split("-")[1].toInt()
        pattern = parts[1].substringBeforeLast(":")
        password = parts[2]
    }
}
