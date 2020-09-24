package cub.hackerrank.challenges.algorithms.easy.timeConversion

import java.util.*
import java.util.regex.Pattern

/*
 * Complete the timeConversion function below.
 */
fun timeConversion(s: String): String {
    /*
     * Write your code here.
     */
    val matcher = Pattern
        .compile("^(..)(.*)(..)$")
        .matcher(s.toUpperCase())
    matcher.find()
    var h = matcher.group(1).toInt()
    val rest = matcher.group(2)
    val ampm = matcher.group(3)

    if (ampm == "AM") {
        if (h == 12) {
            h = 0
        }
    } else {
        if (h < 12) {
            h += 12
        }
    }
    return String.format("%02d%s", h, rest)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = timeConversion(s)

    println(result)
}

