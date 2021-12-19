package day07

import readInput
import kotlin.math.abs

fun part1(positions: List<Int>) : Int {
    var bestFuelCost = Int.MAX_VALUE
    for (i in positions.minOrNull()!! .. positions.maxOrNull()!!) {
        val positionCost = positions.sumOf { abs(it - i) }
        if (positionCost <= bestFuelCost) {
            bestFuelCost = positionCost
        }
    }
    return bestFuelCost
}

fun part2(positions: List<Int>) : Int {
    var bestFuelCost = Int.MAX_VALUE
    for (i in positions.minOrNull()!! .. positions.maxOrNull()!!) {
        val positionCost = positions.sumOf { abs(it - i).let { it * (it + 1) / 2 } }
        if (positionCost <= bestFuelCost) {
            bestFuelCost = positionCost
        }
    }
    return bestFuelCost
}

fun main() {
    val positions: List<Int> =
        readInput("day07")[0].split(',').map { it.toInt() }
    println(positions)
    println("Part 1: ${ part1(positions )}")
    println("Part 2: ${ part2(positions )}")
}
