package cub.hackerrank.challenges.dataStructures.easy.array2D

import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    var maxHourglassSum = Int.MIN_VALUE
    for (x in 1..4) {
        for (y in 1..4) {
            val currHourglassSum =
                    arr[x - 1][y - 1] + arr[x - 1][y] + arr[x - 1][y + 1] +
                    arr[x][y] +
                    arr[x + 1][y - 1] + arr[x + 1][y] + arr[x + 1][y + 1]
            if (currHourglassSum > maxHourglassSum) {
                maxHourglassSum = currHourglassSum
            }
        }
    }
    return maxHourglassSum
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
