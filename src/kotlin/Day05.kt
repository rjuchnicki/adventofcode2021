import java.lang.Integer.min
import java.lang.Integer.max

fun createGrid(endpointList: List<List<Int>>): Array<Array<Int>> {
    var maxX = -1; var maxY = -1
    for (endpoint in endpointList) {
        maxX = max(maxX, max(endpoint[0], endpoint[2]))
        maxY = max(maxY, max(endpoint[1], endpoint[3]))
    }
    return Array(maxX) {Array(maxY) {0} }
}

fun part1(endpointList: List<List<Int>>): Int {
    val gridCoverage = createGrid(endpointList)
    for (endpoint in endpointList) {
        val x1 = endpoint[0] - 1; val x2 = endpoint[2] - 1
        val y1 = endpoint[1] - 1; val y2 = endpoint[3] - 1
        if (x1 == x2) {
            for (y in min(y1, y2)..max(y1, y2)) gridCoverage[x1][y] += 1
        } else if (y1 == y2) {
            for (x in min(x1, x2)..max(x1, x2)) gridCoverage[x][y1] += 1
        }
    }
    return gridCoverage.sumOf { it.count { it >= 2 } }
}

fun part2(endpointList: List<List<Int>>): Int {
    val gridCoverage = createGrid(endpointList)
    for (endpoint in endpointList) {
        val x1 = endpoint[0] - 1; val x2 = endpoint[2] - 1
        val y1 = endpoint[1] - 1; val y2 = endpoint[3] - 1
        if (x1 == x2) {
            for (y in min(y1, y2)..max(y1, y2)) gridCoverage[x1][y] += 1
        } else if (y1 == y2) {
            for (x in min(x1, x2)..max(x1, x2)) gridCoverage[x][y1] += 1
        } else if (x1 < x2 && y1 < y2) {
            for ((x, y) in (x1..x2).zip(y1..y2)) gridCoverage[x][y] += 1
        } else if (x1 < x2 && y1 > y2) {
            for ((x, y) in (x1..x2).zip(y1 downTo y2)) gridCoverage[x][y] += 1
        } else if (x1 > x2 && y1 < y2) {
            for ((x, y) in (x1 downTo x2).zip(y1..y2)) gridCoverage[x][y] += 1
        } else {
            for ((x, y) in (x1 downTo x2).zip(y1 downTo y2)) gridCoverage[x][y] += 1
        }
    }
    return gridCoverage.sumOf { it.count { it >= 2 } }
}

fun main() {
    val endpoints: List<List<Int>> = readInput("day05")
        .map { it.replace(" -> ", ",").split(',').map { it.toInt() } }
    println("Part 1: ${ part1(endpoints) }")
    println("Part 2: ${ part2(endpoints) }")
}
