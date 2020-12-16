package dev.schmetter.aoc2020

class Day16(input: String) {

    data class Rule(var name: String, val lower: Pair<Int, Int>, var upper: Pair<Int, Int>, var pos: Int)

    private var rules = input.split("|")[0].split("\r\n").map { s ->
        Rule(
            s.split(": ")[0],
            s.substringAfter(": ").split(" or ")[0].let { s -> Pair(s.split("-")[0].toInt(), s.split("-")[1].toInt()) },
            s.substringAfter(": ").split(" or ")[1].let { s -> Pair(s.split("-")[0].toInt(), s.split("-")[1].toInt()) },
            -1
        )
    }
    private var tickets = input.split("|")[2].split("\r\n").drop(1).map { s -> s.split(",").map { s -> s.toInt() } }
    private var myTicket = input.split("|")[1].split("\r\n").last().split(",").map { s -> s.toInt() }


    fun solvePart1(): Int {
        var sum = 0
        for (ticket in tickets) {
            for (num in ticket) {
                var valid = false
                for (rule in rules) {
                    var lower = rule.lower
                    var upper = rule.upper
                    if (((num >= lower.first && num <= lower.second) || (num >= upper.first && num <= upper.second))) {
                        valid = true
                        break
                    }
                }
                if (!valid) {
                    sum += num
                }
            }
        }
        return sum
    }

    fun isValid(ticket: List<Int>): Boolean {
        for (num in ticket) {
            var valid = false
            for (rule in rules) {
                var lower = rule.lower
                var upper = rule.upper
                if (((num >= lower.first && num <= lower.second) || (num >= upper.first && num <= upper.second))) {
                    valid = true
                    break
                }
            }
            if (!valid) {
                return false
            }
        }
        return true
    }

    fun solvePart2(): Long {
        var validTickets = tickets.filter { list -> isValid(list) }
        var list = Array<ArrayList<Int>>(validTickets[0].size) { ArrayList() }
        for (ticket in validTickets) {
            for (i in ticket.indices) {
                list[i].add(ticket[i])
            }
        }
        var used = HashSet<Int>()
        for (rule in rules) {
            for (places in list) {
                if (!used.contains(list.indexOf(places))) {
                    var valid = true
                    for (num in places) {
                        var lower = rule.lower
                        var upper = rule.upper
                        if (((num < lower.first || num > lower.second) && (num < upper.first || num > upper.second))) {
                            valid = false
                            break
                        }
                    }
                    if (valid) {
                        rule.pos = list.indexOf(places)
                        used.add(list.indexOf(places))
                        break
                    }
                }
            }
        }
        var sum = 1L
        for (rule in rules) {
            if (rule.name.startsWith("departure")) {
                sum *= myTicket[rule.pos]
            }
        }
        return sum
    }
}