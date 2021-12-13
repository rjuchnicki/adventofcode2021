import java.io.File

fun part1(lines: List<String>) : Int {
    val lineLength = lines.first().length
    val counts = IntArray(lineLength) { 0 }
    for (line in lines) {
        for (i in 0 until lineLength) {
            if (line.get(i) == '1') counts[i]++
        }
    }
    val gammaStr = counts
        .map { if (it >= lines.size / 2) '1' else '0' }
        .joinToString("")
    val gamma = gammaStr.toInt(2)
    val epsilon = gammaStr
        .toCharArray()
        .map { if (it == '1') '0' else '1' }
        .joinToString("")
        .toInt(2)
    return gamma * epsilon
}

fun main() {
    val lines = File("../../data/day03.txt").readLines()
    println("Part1: ${ part1(lines) }")
}
