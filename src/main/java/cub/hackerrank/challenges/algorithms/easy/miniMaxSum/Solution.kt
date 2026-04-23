package cub.hackerrank.challenges.algorithms.easy.miniMaxSum

import java.util.*

// Complete the miniMaxSum function below.
fun miniMaxSum(arr: Array<Int>): Unit {
    val s = arr.map { it.toLong() }
    println("${s.sum() - s.max()!!} ${s.sum() - s.min()!!}")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    miniMaxSum(arr)
}
