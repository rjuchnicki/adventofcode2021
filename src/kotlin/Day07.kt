package day07

import readInput
import kotlin.math.abs

fun part1(positions: List<Int>) : Int {
    return (positions.minOrNull()!! .. positions.maxOrNull()!!)
        .minOf { position -> positions.sumOf { abs(it - position) } }
}

fun part2(positions: List<Int>) : Int {
    return (positions.minOrNull()!! .. positions.maxOrNull()!!)
        .minOf { position -> positions.sumOf { abs(it - position).let { it * (it + 1) / 2 } } }
}

fun main() {
    val positions: List<Int> =
        readInput("day07")[0].split(',').map { it.toInt() }
    println("Part 1: ${ part1(positions )}")
    println("Part 2: ${ part2(positions )}")
}
