package cub.hackerrank.tutorials.a30DaysOfCode.day09

import java.util.*

fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val pb: MutableMap<String, Int> = HashMap()
    for (i in 0 until n) {
        val name = scanner.next()
        val phone = scanner.nextInt()
        pb[name] = phone
    }
    while (scanner.hasNext()) {
        val s = scanner.next()
        println(
            if (pb.containsKey(s)) s + "=" + pb[s].toString() else "Not found"
        )
    }
    scanner.close()
}
