package cub.hackerrank.challenges.algorithms.easy.birthdayCakeCandles

/*
 * Complete the 'birthdayCakeCandles' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY candles as parameter.
 */

fun birthdayCakeCandles(candles: Array<Int>): Int {
    var tallest = -1
    var tallestIdx = -1
    for (idx in candles.indices) {
        if (tallestIdx == -1 || candles[idx] > candles[tallestIdx]) {
            tallest = 1
            tallestIdx = idx
        } else if (candles[idx] == candles[tallestIdx]) {
            tallest++
        }
    }
    return tallest
}

fun main(args: Array<String>) {
    val candlesCount = readLine()!!.trim().toInt()

    val candles = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = birthdayCakeCandles(candles)

    println(result)
}
