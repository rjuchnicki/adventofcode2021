import java.io.File

fun part1(depths: List<Int>) : Int {
    var count: Int = 0
    for (i in 1 until depths.size) {
        if (depths.elementAt(i-1) < depths.elementAt(i)) {
            count += 1
        }
    }
    return count
}

fun part2(depths: List<Int>) : Int {
    var count: Int = 0
    for (i in 3 until depths.size) {
        val sharedSum: Int = depths.elementAt(i-1) + depths.elementAt(i-2)
        if (depths.elementAt(i-3) + sharedSum <
            depths.elementAt(i) + sharedSum) {
            count += 1
        }
    }
    return count
}

fun main() {
    val depths: List<Int> = 
        File("..\\..\\data\\day01.txt").readLines().map { it.toInt() }
    val part1: Int = part1(depths) 
    println("Part 1: $part1")
    val part2: Int = part2(depths)
    println("Part 2: $part2")
}
