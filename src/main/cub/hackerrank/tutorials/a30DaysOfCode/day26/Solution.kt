package cub.hackerrank.tutorials.a30DaysOfCode.day26

import java.util.*

fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */

    val scanner = Scanner(System.`in`)

    val da = scanner.nextInt()
    val ma = scanner.nextInt()
    val ya = scanner.nextInt()
    val de = scanner.nextInt()
    val me = scanner.nextInt()
    val ye = scanner.nextInt()

    if (ya < ye || ya == ye && ma < me || ya == ye && ma == me && da <= de) {
        println(0)
    } else if (ya > ye) {
        println("10000")
    } else if (ma > me) {
        println(500 * (ma - me))
    } else if (da > de) {
        println(15 * (da - de))
    }
}
