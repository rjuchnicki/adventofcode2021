import java.io.File

fun part1(commands: List<List<String>>) : Int {
    var horizontal = 0; var depth = 0
    for (command: List<String> in commands) {
        val distance = command.elementAt(1).toInt()
        when (command.elementAt(0)) {
            "forward" -> horizontal += distance
            "up" -> depth -= distance
            "down" -> depth += distance
        }
    }
    return horizontal * depth
}

fun part2(commands: List<List<String>>) : Int {
    var aim = 0; var horizontal = 0; var depth = 0
    for (command: List<String> in commands) {
        val delta = command.elementAt(1).toInt()
        when (command.elementAt(0)) {
            "forward" -> {
                horizontal += delta
                depth += aim * delta
            }
            "up" -> aim -= delta
            "down" -> aim += delta
        }
    }
    return horizontal * depth
}

fun main() {
    val commands = File("../../data/day02.txt").readLines().map {
        it.split(" ")
    }
    println("Part 1: ${ part1(commands) }")
    println("Part 2: ${ part2(commands) }")
}
