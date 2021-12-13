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

fun part1Func(depths: List<Int>) : Int {
    return depths.windowed(2).count { it.first() < it.last() }
}

fun part2Func(depths: List<Int>) : Int {
    return depths.windowed(4).count { it.first() < it.last() }
}

fun main() {
    val depths: List<Int> = 
        File("..\\..\\data\\day01.txt").readLines().map { it.toInt() }
    println("Part 1: ${ part1(depths) }")
    println("Part 2: ${ part2(depths) }")
    println("Part 1 functional implementation: ${ part1Func(depths) }")
    println("Part 2 functional implementation: ${ part2Func(depths) }")
}
