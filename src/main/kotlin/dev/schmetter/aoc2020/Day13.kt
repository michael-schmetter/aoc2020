package dev.schmetter.aoc2020

class Day13(input: String) {
    data class IndexedBus(val i: Int, val line: Long)

    private var time: Int = input.split("|")[0].toInt()
    private var busses: List<Int>
    private val iBusses: List<IndexedBus>


    init {
        var list = input.split("|")[1].split(",").toMutableList()
        list.removeAll { x -> x == "x" }
        busses = list.map { it.toInt() }
        iBusses = list.mapIndexedNotNull { i, line -> IndexedBus(i, line.toLong()) }
    }

    fun solvePart1(): Int {
        var foundBus = -1
        var neededTime = time
        while (foundBus==-1){
            for(bus in busses){
                if(neededTime%bus==0){
                    foundBus=bus
                    break
                }
            }
            neededTime++
        }
        return foundBus*(neededTime-1-time)
    }

    fun solvePart2(): Long {
        var stepSize = iBusses.first().line
        var t = 0L
        iBusses.drop(1).forEach { (offset, bus) ->
            while ((t + offset) % bus != 0L) {
                t += stepSize
            }
            stepSize *= bus
        }
        return t
    }
}