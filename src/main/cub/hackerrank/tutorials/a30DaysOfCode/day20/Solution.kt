package cub.hackerrank.tutorials.a30DaysOfCode.day20

import java.util.*

fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */

    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val a = IntArray(n)
    for (a_i in 0 until n) {
        a[a_i] = scanner.nextInt()
    }

    var totalNumberOfSwaps = 0
    for (i in 0 until n) {
        var numberOfSwaps = 0
        for (j in 0 until n - 1) {
            if (a[j] > a[j + 1]) {
                a[j] = a[j+1].also { a[j+1] = a[j] }
                numberOfSwaps++
            }
        }
        totalNumberOfSwaps += numberOfSwaps
        if (numberOfSwaps == 0) {
            break
        }
    }

    println("Array is sorted in $totalNumberOfSwaps swaps.")
    println("First Element: " + a[0])
    println("Last Element: " + a[n - 1])
}
