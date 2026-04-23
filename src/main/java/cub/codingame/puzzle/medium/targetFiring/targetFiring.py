import sys
import math
from dataclasses import dataclass
from functools import cmp_to_key, reduce

@dataclass
class Alien:
    typ = ''
    hp = 0
    armor = 0
    damage = 0
    pewpew = 0
    roundsToKill = 0
    roundsToLive = 1

    def __init__(self, typ, hp, armor, damage):
        self.typ = typ
        self.hp = hp
        self.armor = armor
        self.damage = damage
        self.pewpew = (20 - self.armor if self.typ == "FIGHTER" else 10 - self.armor)
        if self.pewpew < 1:
            self.pewpew = 1
        self.roundsToKill = int(self.hp / self.pewpew) + (1 if self.hp % self.pewpew > 0 else 0)

def compare_aliens(a, b):
    damageAfirst = a.roundsToKill * (a.damage + b.damage) + b.roundsToKill * b.damage
    damageBfirst = b.roundsToKill * (a.damage + b.damage) + a.roundsToKill * a.damage
    return damageAfirst - damageBfirst

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.
n = int(input())
aliens = []
for i in range(n):
    typ, hp, armor, damage = input().split()
    aliens.append(Alien(typ, int(hp), int(armor), int(damage)))

aliens.sort(key=cmp_to_key(compare_aliens))

totalRounds = 0
for alien in aliens:
    totalRounds += alien.roundsToKill
    alien.roundsToLive = totalRounds

hpRemainder = 5000 - reduce(
    lambda acc, alien: acc + alien.damage * alien.roundsToLive,
    aliens,
    0
)

# Write an answer using print
# To debug: print("Debug messages...", file=sys.stderr, flush=True)

print("FLEE" if hpRemainder < 0 else hpRemainder)
