package cub.hackerrank.challenges.algorithms.easy.plusMinus

import java.util.*

// Complete the plusMinus function below.
fun plusMinus(arr: Array<Int>): Unit {
    var n = 0
    var z = 0
    var p = 0
    for (i in arr.indices) {
        when {
            arr[i] < 0 -> n++
            arr[i] == 0 -> z++
            else -> p++
        }
    }
    print(String.format("%.6f\n", p.toDouble() / arr.size))
    print(String.format("%.6f\n", n.toDouble() / arr.size))
    print(String.format("%.6f\n", z.toDouble() / arr.size))
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    plusMinus(arr)
}
