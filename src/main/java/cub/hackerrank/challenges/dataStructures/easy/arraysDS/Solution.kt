package cub.hackerrank.challenges.dataStructures.easy.arraysDS

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the reverseArray function below.
fun reverseArray(a: Array<Int>): Array<Int> {
    return a.reversedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arrCount = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val res = reverseArray(arr)

    println(res.joinToString(" "))
}
