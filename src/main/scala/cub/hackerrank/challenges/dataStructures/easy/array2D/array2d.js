'use strict';

const fs = require('fs');

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

// Complete the hourglassSum function below.
function hourglassSum(arr) {
    let maxHourglassSum = -1000000
    for (let x = 1; x < 5; x++) {
        for (let y = 1; y < 5; y++) {
            const currHourglassSum =
                arr[x - 1][y - 1] + arr[x - 1][y] + arr[x - 1][y + 1] +
                arr[x][y] +
                arr[x + 1][y - 1] + arr[x + 1][y] + arr[x + 1][y + 1]
            if (currHourglassSum > maxHourglassSum) {
                maxHourglassSum = currHourglassSum
            }
        }
    }
    return maxHourglassSum
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    let arr = Array(6);

    for (let i = 0; i < 6; i++) {
        arr[i] = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));
    }

    let result = hourglassSum(arr);

    ws.write(result + "\n");

    ws.end();
}
