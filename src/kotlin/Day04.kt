data class BingoBoard(val rows: List<MutableList<Long>>)

fun hasBingo(board: BingoBoard) : Boolean {
    for (row: MutableList<Long> in board.rows) {
        if (row.all { it == 0L }) return true
    }

    for (j in 0 until board.rows[0].size) {
        var allFound = true
        for (i in 0 until board.rows.size) {
            if (board.rows[i][j] != 0L) {
                allFound = false
                break
            }
        }
        if (allFound) return true
    }

    return false
}

fun part1(numbers: List<Long>, boards: List<BingoBoard>) : Long {
    for (number: Long in numbers) {
        for (board: BingoBoard in boards) {
            for (row: MutableList<Long> in board.rows) {
                val col = row.indexOf(number)
                if (col != -1) {
                    row[col] = 0L
                }
            }
            if (hasBingo(board)) {
                return number * board.rows.sumOf { it.sum() }
            }
        }
    }
    return -1
}

fun part2(numbers: List<Long>, boards: List<BingoBoard>) : Long {
    val solved: Array<Boolean> = Array(boards.size) { false }
    var numSolved: Int = 0
    for (number: Long in numbers) {
        var index: Int = -1
        for (i in 0 until boards.size) {
            for (row: MutableList<Long> in boards[i].rows) {
                val col = row.indexOf(number)
                if (col != -1) {
                    row[col] = 0L
                }
            }
            if (hasBingo(boards[i]) && !solved[i]) {
                solved[i] = true
                numSolved += 1
                index = i
            }
        }

        if (numSolved == boards.size) {
            return number * boards[index].rows.sumOf { it.sum() }
        }
    }
    return -1
}

fun main() {
    val lines = readInput("day04")
    val numbers = lines.first().split(',').map { it.toLong() }
    val boardLists = lines.drop(1).filter { it.isNotEmpty() }.chunked(5).map {
        it.map { it.split(' ').filter { it.isNotEmpty() }.map { it.toLong() } as MutableList }
    }
    val boards = boardLists.map { BingoBoard(it) }
    println("Part 1: ${ part1(numbers, boards) }")
    println("Part 2: ${ part2(numbers, boards) }")
}
