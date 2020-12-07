package dev.schmetter.aoc2020

class Day07(input: String) {
    private var rulesContained: HashMap<String, ArrayList<String>> = HashMap()
    private var rulesContains: HashMap<String, ArrayList<Pair<String,Int>>> = HashMap()
    private var alreadyUsed: HashSet<String> = HashSet()

    init {
        parse(input.split("|"))
    }

    private fun parse(rawRules: List<String>) {
        var regexContained =
            "(.*)contain(?:\\s\\d\\s(.*?)[\\,\\.])?(?:\\s\\d\\s(.*?)[\\,\\.])?(?:\\s\\d\\s(.*?)[\\,\\.])?(?:\\s\\d\\s(.*?)[\\,\\.])?(?:\\s\\d\\s(.*?)[\\,\\.])?(?:\\s\\d\\s(.*?)[\\,\\.])?(?:\\s\\d\\s(.*?)[\\,\\.])?".toRegex()
        var regexContains = "(.*)contain(?:\\s(\\d)\\s(.*?)[\\,\\.])?(?:\\s(\\d)\\s(.*?)[\\,\\.])?(?:\\s(\\d)\\s(.*?)[\\,\\.])?(?:\\s(\\d)\\s(.*?)[\\,\\.])?(?:\\s(\\d)\\s(.*?)[\\,\\.])?(?:\\s(\\d)\\s(.*?)[\\,\\.])?(?:\\s(\\d)\\s(.*?)[\\,\\.])?".toRegex()
        for (rawRule in rawRules) {
            var result = regexContained.matchEntire(rawRule)
            if (result != null) {
                var key = ""
                result.groupValues.forEachIndexed { index, s ->
                    var color = s.replace("bags", "").replace("bag", "").trim()
                    when (index) {
                        1 -> key = color
                        0 -> {
                        } // do nothing
                        else -> {
                            if (rulesContained[color] == null) {
                                rulesContained[color] = ArrayList()
                            }
                            rulesContained[color]?.add(key)
                        }
                    }
                }
            }
            var resultContains = regexContains.matchEntire(rawRule)
            if (resultContains != null) {
                var index = 2
                var key = resultContains.groupValues[1].replace("bags", "").replace("bag", "").trim()
                while (resultContains.groupValues[index]!=""){
                    var num = resultContains.groupValues[index]
                    index++
                    var color = resultContains.groupValues[index].replace("bags", "").replace("bag", "").trim()
                    if (rulesContains[key] == null) {
                        rulesContains[key] = ArrayList()
                    }
                    rulesContains[key]?.add(Pair(color,num.toInt()))
                    index++
                }
            }
        }
    }

    fun solvePart1(): Int? {
        var bagColor = "shiny gold"
        return traverse(bagColor)
    }

    private fun traverse(bag: String): Int {
        var size = 0
        if (rulesContained.containsKey(bag)) {
            for (bag in rulesContained[bag]!!) {
                if(!alreadyUsed.contains(bag))
                    size++
                alreadyUsed.add(bag)
                size += traverse(bag)
            }
        }
        return size
    }

    private fun traverseContains(key: String): Int {
        var size = 1
        if (rulesContains.containsKey(key)) {
            for (bag in rulesContains[key]!!) {
                size += traverseContains(bag.first) * bag.second
            }
        }
        return size
    }

    fun solvePart2(): Int {
        var bagColor = "shiny gold"
        return traverseContains(bagColor)-1
    }

}