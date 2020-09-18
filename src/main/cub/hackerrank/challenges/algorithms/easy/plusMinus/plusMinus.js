'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the plusMinus function below.
function plusMinus(arr) {
    let n = 0, z = 0, p = 0
    for (const i of arr) {
        if (i < 0)   { n++ }
        if (i === 0) { z++ }
        if (i > 0)   { p++ }
    }
    console.log((p/arr.length).toFixed(6))
    console.log((n/arr.length).toFixed(6))
    console.log((z/arr.length).toFixed(6))
}

function main() {
    const n = parseInt(readLine(), 10);

    const arr = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));

    plusMinus(arr);
}
