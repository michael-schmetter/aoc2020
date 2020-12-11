package dev.schmetter.aoc2020


class Day11(input: String) {

    private var grid: Array<Array<String>>

    init {
        grid = input.split(",").map { s -> s.chunked(1).toTypedArray() }.toTypedArray()
    }

    private fun getCopy(array: Array<Array<String>>): Array<Array<String>> {
        val copy = Array(array.size) { Array(array[0].size) { "" } }
        for (i in array.indices) {
            for (j in array[i].indices) {
                copy[i][j] = array[i][j]
            }
        }
        return copy
    }

    private val occupied = "#"
    private val free = "L"
    private val nothing = "."

    fun solvePart1(): Int {
        var difference = true
        while (difference) {

            var newGrid = getCopy(grid)
            for (i in grid.indices) {
                for (j in grid[i].indices) {
                    when (grid[i][j]) {
                        free -> if (!adjSeatsAreMore(i, j, 0)) newGrid[i][j] = occupied
                        occupied -> if (adjSeatsAreMore(i, j, 3)) newGrid[i][j] = free
                    }
                }
            }
            if(grid contentDeepEquals newGrid)
                difference = false
            grid = newGrid
        }

        return grid.flatten().count { it==occupied }
    }

    private fun adjSeatsAreMore(i: Int, j: Int, num: Int): Boolean {
        var composed = ""
        if (i > 0 && j > 0)
            composed += grid[i - 1][j - 1]
        if (i > 0)
            composed += grid[i - 1][j]
        if (j > 0)
            composed += grid[i][j - 1]
        if (i < grid.size - 1)
            composed += grid[i + 1][j]
        if (j < grid[i].size - 1)
            composed += grid[i][j + 1]
        if (j < grid[i].size - 1 && i < grid.size - 1)
            composed += grid[i + 1][j + 1]
        if (j < grid[i].size - 1 && i > 0)
            composed += grid[i - 1][j + 1]
        if (i < grid.size - 1 && j > 0)
            composed += grid[i + 1][j - 1]
        return composed.count { it == '#' } > num
    }


    //UGLY
    private fun seenSeatsAreMore(i: Int, j: Int, num: Int): Boolean {
        var count = 0
        var ii = i
        var jj = j
        while (ii > 0 && jj > 0) {
            ii--
            jj--
            if (grid[ii][jj] != nothing) {
                if (grid[ii][jj] == occupied)
                    count++
                break
            }
        }
        ii = i
        jj = j
        while (ii > 0) {
            ii--
            if (grid[ii][jj] != nothing) {
                if (grid[ii][jj] == occupied)
                    count++
                break
            }
        }
        ii = i
        jj = j
        while (jj > 0) {
            jj--
            if (grid[ii][jj] != nothing) {
                if (grid[ii][jj] == occupied)
                    count++
                break
            }
        }
        ii = i
        jj = j
        while (ii < grid.size - 1) {
            ii++
            if (grid[ii][jj] != nothing) {
                if (grid[ii][jj] == occupied)
                    count++
                break
            }
        }
        ii = i
        jj = j
        while (jj < grid[i].size - 1) {
            jj++
            if (grid[ii][jj] != nothing) {
                if (grid[ii][jj] == occupied)
                    count++
                break
            }
        }
        ii = i
        jj = j
        while (jj < grid[i].size - 1 && ii < grid.size - 1) {
            ii++
            jj++
            if (grid[ii][jj] != nothing) {
                if (grid[ii][jj] == occupied)
                    count++
                break
            }
        }
        ii = i
        jj = j
        while (jj < grid[i].size - 1 && ii > 0) {
            ii--
            jj++
            if (grid[ii][jj] != nothing) {
                if (grid[ii][jj] == occupied)
                    count++
                break
            }
        }
        ii = i
        jj = j
        while (jj > 0 && ii < grid.size - 1) {
            ii++
            jj--
            if (grid[ii][jj] != nothing) {
                if (grid[ii][jj] == occupied)
                    count++
                break
            }
        }
        return count > num
    }

    fun solvePart2(): Int {
        var difference = true
        while (difference) {

            var newGrid = getCopy(grid)
            for (i in grid.indices) {
                for (j in grid[i].indices) {
                    when (grid[i][j]) {
                        free -> if (!seenSeatsAreMore(i, j, 0)) newGrid[i][j] = occupied
                        occupied -> if (seenSeatsAreMore(i, j, 4)) newGrid[i][j] = free
                    }
                }
            }
            if(grid contentDeepEquals newGrid)
                difference = false
            grid = newGrid
        }
        return grid.flatten().count { it==occupied }
    }
}