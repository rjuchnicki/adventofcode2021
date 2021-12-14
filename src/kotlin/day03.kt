import java.io.File

fun onesPerPosition(lines: List<String>) : IntArray {
    val lineLength = lines.first().length
    val counts = IntArray(lineLength) { 0 }
    for (line in lines) {
        for (i in 0 until lineLength) {
            if (line.get(i) == '1') counts[i]++
        }
    }
    return counts
}

fun part1(lines: List<String>) : Int {
    val counts = onesPerPosition(lines)
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

fun part2(lines: List<String>) : Int {
    val lineLength = lines.first().length
    var counts = onesPerPosition(lines)

    // TODO: clean up by initializing oxygenValues and carbonValues to counts
    // so that you can put everything except i initialization inside the loop.
    var oxygenBits = counts.map { if (it >= lines.size / 2) '1' else '0' }
    var oxygenValues = lines.filter { it.get(0) == oxygenBits[0] }
    var i = 1
    while (oxygenValues.size > 1 && i < lineLength) {
        counts = onesPerPosition(oxygenValues)
        oxygenBits = counts
            .map { if (it >= oxygenValues.size / 2) '1' else '0' }
        oxygenValues = oxygenValues.filter { it.get(i) == oxygenBits[i] }
        i++
    }

    counts = onesPerPosition(lines)
    var carbonBits = counts.map { if (it < lines.size / 2) '1' else '0' }
    var carbonValues = lines.filter { it.get(0) == carbonBits[0] }
    i = 1
    while (carbonValues.size > 1 && i < lineLength) {
        counts = onesPerPosition(carbonValues)
        carbonBits = counts
            .map { if (it >= carbonValues.size / 2) '1' else '0' }
        carbonValues = carbonValues.filter { it.get(i) == carbonBits[i] }
        i++
    }

    val oxygenRating = oxygenValues.elementAt(0).toInt(2)
    val carbonDioxideRating = carbonValues.elementAt(0).toInt(2)
    return oxygenRating * carbonDioxideRating
}

fun main() {
    val lines = File("../../data/day03.txt").readLines()
    println("Part 1: ${ part1(lines) }")
    println("Part 2: ${ part2(lines) }")
}
