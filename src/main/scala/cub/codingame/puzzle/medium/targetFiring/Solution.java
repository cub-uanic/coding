package cub.codingame.puzzle.medium.targetFiring;

import java.util.*;
import java.io.*;
import java.math.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static class Alien {
        public String type;
        public int hp;
        public int armor;
        public int damage;
        public int pewpew;
        public int roundsToKill;
        public int roundsToLive;

        public Alien(String _type, int _hp, int _armor, int _damage) {
            int _pewpew = Math.max(
                    _type.equals("FIGHTER")
                            ? 20 - _armor
                            : 10 - _armor,
                    1
            );

            this.type = _type;
            this.hp = _hp;
            this.armor = _armor;
            this.damage = _damage;
            this.pewpew = _pewpew;
            this.roundsToKill = _hp / this.pewpew + (_hp % _pewpew > 0 ? 1 : 0);
            this.roundsToLive = 0;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Alien> aliens = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            aliens.add(new Alien(
                    in.next(),
                    in.nextInt(),
                    in.nextInt(),
                    in.nextInt()
            ));
        }

        aliens.sort((a, b) -> {
            int damageAfirst = a.roundsToKill * (a.damage + b.damage) + b.roundsToKill * b.damage;
            int damageBfirst = b.roundsToKill * (a.damage + b.damage) + a.roundsToKill * a.damage;
            return damageAfirst - damageBfirst;
        });

        int totalRounds = 0;
        for (Alien alien : aliens) {
            totalRounds += alien.roundsToKill;
            alien.roundsToLive = totalRounds;
        }

        int hpRemainder = 5000 - aliens
                .stream()
                .reduce(0,
                        (acc, alien) -> {
                            return acc + alien.damage * alien.roundsToLive;
                        },
                        Integer::sum
                );

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(hpRemainder < 0 ? "FLEE" : hpRemainder);
    }
}

