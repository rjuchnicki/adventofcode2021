package day06

import readInput

fun populationAfterNDays(spawningTimeCounts: Array<Long>, days: Int) : Long {
    repeat(days) {
        var prev: Long  = spawningTimeCounts[spawningTimeCounts.size - 1]
        for (i in spawningTimeCounts.size - 2 downTo 0) {
            val tmp: Long = spawningTimeCounts[i]
            spawningTimeCounts[i] = prev
            prev = tmp
        }
        spawningTimeCounts[6] += prev
        spawningTimeCounts[8] = prev
    }

    return spawningTimeCounts.sum()
}

fun main() {
    val spawningTimes: List<Int> =
        readInput("day06")[0].split(',').map { it.toInt() }
    val spawnTimeCounts: Array<Long> = Array(9) {0L}
    spawningTimes.forEach { spawnTimeCounts[it] += 1L }
    val spawnTimeCounts2: Array<Long> = spawnTimeCounts.copyOf()
    println("Part 1: ${ populationAfterNDays(spawnTimeCounts, 80) }")
    println("Part 2: ${ populationAfterNDays(spawnTimeCounts2, 256)}")
}
