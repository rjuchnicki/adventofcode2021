import java.io.File

fun readInput(fileName: String) = File("data/$fileName.txt").readLines()
