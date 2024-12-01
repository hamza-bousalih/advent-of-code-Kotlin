import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Long {
        val (left, right) = input.map {
            it.substringBefore(" ").toLong() to it.substringAfterLast(" ").toLong()
        }.unzip()

        val res = right.sorted().zip(left.sorted()).map { (l, r) -> abs(l - r) }.sum()

        return res
    }

    fun part2(input: List<String>): Long {
        val (left, right) = input.map {
            it.substringBefore(" ").toLong() to it.substringAfterLast(" ").toLong()
        }.unzip()

        val freq = right.groupingBy { it }.eachCount()

        val res = left.fold(0L) { acc, it ->
            acc + it * freq.getOrDefault(it, 0)
        }

        return res
    }

    val input = readInput("inputs/Day01")
    part1(input).println()
    part2(input).println()
}
