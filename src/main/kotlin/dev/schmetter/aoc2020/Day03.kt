package dev.schmetter.aoc2020

class Day03(input: String) {
    private var grid: Array<Array<Boolean>>

    init {
        grid = input.split(",").map { s -> s.chunked(1).map { s -> s=="#" }.toTypedArray() }.toTypedArray()
    }

    fun solvePart1(): Int {
        return checkSlope(3,1)
    }

    fun solvePart2(): Int {
        var step1 = checkSlope(1,1)
        var step2 = checkSlope(3,1)
        var step3 = checkSlope(5,1)
        var step4 = checkSlope(7,1)
        var step5 = checkSlope(1,2)
        return step1*step2*step3*step4*step5
    }


    private fun checkSlope(right: Int, down: Int): Int{
        var trees=0
        var y=down
        var x=0
        while (y<grid.size){
            x=(x+right)%grid[y].size
            if(grid[y][x]){
                trees++
            }
            y += down
        }
        return trees
    }
}