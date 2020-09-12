/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

'use strict';

function digitsCount(st, ed) {
    let count = 0
    let stCapacity = st.toString().length
    let edCapacity = ed.toString().length
    let cnt10 = parseInt('1' + '0'.repeat(stCapacity - 1));
    let cnt90 = cnt10 * 9

    for (let capacity = stCapacity; capacity <= edCapacity; capacity++) {
        let numbersCount = capacity === edCapacity ? ed + 1 - cnt10 : cnt90
        if (capacity === stCapacity) {
            numbersCount = numbersCount - st + cnt10
        }
        count += numbersCount * capacity
        cnt10 *= 10
        cnt90 *= 10
    }

    return count
}

function fairNumbering(st, ed) {
    let x = Math.floor((st + ed - 1) / 2)
    let result = st
    while (digitsCount(st, x) <= digitsCount(x + 1, ed)) {
        result = x
        x++
    }
    return result;
}

const readline = require('readline')
const N = parseInt(readline());
for (let i = 0; i < N; i++) {
    var inputs = readline().split(' ');
    console.error(inputs)
    const st = parseInt(inputs[0]);
    const ed = parseInt(inputs[1]);
    console.log(fairNumbering(st, ed))
}

module.exports = {digitsCount, fairNumbering}