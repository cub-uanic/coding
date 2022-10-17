package cub.hackerrank.tutorials.a30DaysOfCode.day10

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    var n = scan.nextLine().trim().toInt()

    var result = 0
    var curr = 0
    while (n > 0) {
        if (n % 2 == 1) {
            curr += 1
            if (curr > result) {
                result = curr
            }
        } else {
            curr = 0
        }
        n = n ushr 1
    }
    println(result)
}
