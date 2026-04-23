let aliens = []

const N = parseInt(readline())
for (let i = 0; i < N; i++) {
    var inputs = readline().split(" ")
    const alien = {
        type: inputs[0],
        hp: parseInt(inputs[1]),
        armor: parseInt(inputs[2]),
        damage: parseInt(inputs[3]),
    }
    alien.pewpew = Math.max(alien.type === "FIGHTER" ? 20 - alien.armor : 10 - alien.armor, 1)
    alien.roundsToKill = Math.ceil(alien.hp / alien.pewpew)

    aliens.push(alien)
}

aliens.sort((a, b) => {
    const damageAfirst = a.roundsToKill * (a.damage + b.damage) + b.roundsToKill * b.damage
    const damageBfirst = b.roundsToKill * (a.damage + b.damage) + a.roundsToKill * a.damage
    return damageAfirst - damageBfirst
})

let totalRounds = 0
aliens.forEach(alien => {
    totalRounds += alien.roundsToKill
    alien.roundsToLive = totalRounds
})

let hpRemainder = 5000 - aliens.reduce((acc, alien) => acc + alien.damage * alien.roundsToLive, 0)
console.log(hpRemainder < 0 ? "FLEE" : hpRemainder)
