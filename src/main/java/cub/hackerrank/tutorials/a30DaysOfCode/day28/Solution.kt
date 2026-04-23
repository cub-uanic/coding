package cub.hackerrank.tutorials.a30DaysOfCode.day28

import java.util.*


fun main(args: Array<String>) {
    class Row(val firstName: String, val emailID: String)

    val db: MutableList<Row> = ArrayList()

    val scan = Scanner(System.`in`)
    val N = scan.nextLine().trim().toInt()
    for (NItr in 1..N) {
        val firstNameEmailID = scan.nextLine().split(" ")
        val firstName = firstNameEmailID[0]
        val emailID = firstNameEmailID[1]
        db.add(Row(firstName, emailID))
    }

    db.filter { row -> row.emailID.matches("^.*@gmail.com$".toRegex()) }
        .map { obj -> obj.firstName }
        .sorted()
        .forEach { name -> println(name) }
}
