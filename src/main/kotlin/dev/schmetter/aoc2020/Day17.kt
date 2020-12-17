package dev.schmetter.aoc2020

class Day17(input: String) {

    data class P(var x: Int, val y: Int, var z: Int, var w: Int)
    private var grid = HashMap<P, Boolean>()

    init {
        input.split(",").forEachIndexed { index, s ->
            s.chunked(1).forEachIndexed { jndex, s -> grid.put(P(index, jndex, 0, 0), s == "#") }
        }
    }

    fun solvePart1(): Int {
        for (i in 0..5) {
            var newGrid = grid.toMutableMap()
            var toEvaluate = mutableSetOf<P>()
            grid.keys.forEachIndexed { index, p ->
                for (x in -1..1) {
                    for (y in -1..1) {
                        for (z in -1..1) {
                            toEvaluate.add(P(p.x + x, p.y + y, p.z + z, 0))
                        }
                    }
                }
            }
            grid = evaluate(toEvaluate, newGrid) as HashMap<P, Boolean>
        }

        return grid.count { it.value }
    }

    private fun numOfActive(p: P): Int {
        var sum = 0
        for (x in -1..1) {
            for (y in -1..1) {
                for (z in -1..1) {
                    for (w in -1..1) {
                        if (x == 0 && y == 0 && z == 0 && w == 0)
                            continue
                        if (grid[P(p.x + x, p.y + y, p.z + z, p.w + w)] == true)
                            sum++
                    }
                }
            }
        }
        return sum
    }


    fun solvePart2(): Int {
        for (i in 0..5) {
            var newGrid = grid.toMutableMap()
            var toEvaluate = mutableSetOf<P>()
            grid.keys.forEachIndexed { index, p ->
                for (x in -1..1) {
                    for (y in -1..1) {
                        for (z in -1..1) {
                            for (w in -1..1) {
                                toEvaluate.add(P(p.x + x, p.y + y, p.z + z, p.w + w))
                            }
                        }
                    }
                }
            }
            grid = evaluate(toEvaluate, newGrid) as HashMap<P, Boolean>
        }
        return grid.count { it.value }
    }

    fun evaluate(toEvaluate: Set<P>, newGrid: MutableMap<P, Boolean>): Map<P, Boolean> {
        toEvaluate.forEach { p ->
            var numOfActiveNeighbours = numOfActive(p)
            if (grid[p] == true && numOfActiveNeighbours !in 2..3) {
                newGrid[p] = false
            } else if (grid[p] != true && numOfActiveNeighbours == 3) {
                newGrid[p] = true
            }
        }
        return newGrid
    }
}