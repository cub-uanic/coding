package cub.hackerrank.tutorials.a30DaysOfCode.day29

import java.util.*


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val nk = scan.nextLine().split(" ")
        val n = nk[0].trim().toInt()
        val k = nk[1].trim().toInt()

        var a = k - 1
        var b = 0
        while (a > 0) {
            var lowestZero = 0
            var tmp = a
            while (tmp > 0 && tmp and 1 == 1) {
                tmp = tmp shr 1
                lowestZero++
            }
            b = a + (1 shl lowestZero)
            if (b <= n) {
                break
            }
            a--
        }
        println(a and b)
    }
}
