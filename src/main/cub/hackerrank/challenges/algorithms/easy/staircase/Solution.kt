package cub.hackerrank.challenges.algorithms.easy.staircase

import java.util.*

// Complete the staircase function below.
fun staircase(n: Int): Unit {
    repeat(n) {
        println(" ".repeat(n - it - 1) + "#".repeat(it + 1));
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    staircase(n)
}
