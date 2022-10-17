package cub.codingame.puzzle.medium.targetFiring

import java.util.*

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
data class Alien(
        val type: String,
        val hp: Int,
        val armor: Int,
        val damage: Int,
        var pewpew: Int = Math.max(if (type == "FIGHTER") 20 - armor else 10 - armor, 1),
        var roundsToKill: Int = hp / pewpew + if (hp % pewpew > 0) 1 else 0,
        var roundsToLive: Int = 1
)

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val N = input.nextInt()
    val aliens: MutableList<Alien> = ArrayList(N)

    for (i in 0 until N) {
        aliens.add(Alien(
                input.next(),
                input.nextInt(),
                input.nextInt(),
                input.nextInt()
        ))
    }

    aliens.sortWith(Comparator { a, b ->
        val damageAfirst = a.roundsToKill * (a.damage + b.damage) + b.roundsToKill * b.damage
        val damageBfirst = b.roundsToKill * (a.damage + b.damage) + a.roundsToKill * a.damage
        return@Comparator damageAfirst - damageBfirst
    })

    var totalRounds = 0
    aliens.forEach {
        totalRounds += it.roundsToKill
        it.roundsToLive = totalRounds
    }

    val hpRemainder = 5000 - aliens.reduce { a, b ->
        Alien(
                a.type,
                a.hp,
                a.armor,
                a.damage * a.roundsToLive + b.damage * b.roundsToLive
        )
    }.damage

    // Write an answer using System.out.println()
    // To debug: System.err.println("Debug messages...");
    println(if (hpRemainder < 0) "FLEE" else hpRemainder)
}
