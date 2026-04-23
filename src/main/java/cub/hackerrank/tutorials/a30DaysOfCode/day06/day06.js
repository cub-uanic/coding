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

    processData(inputString);
});

function readLine() {
    return inputString[currentLine++];
}

function processData(input) {
    //Enter your code here
    let n = parseInt(readLine())

    for (let i = 0; i < n; i++) {
        let s = readLine()
        let even = ''
        let odd = ''
        for (let j = 0; j < s.length; j++) {
            if (j % 2 === 0) {
                even += s[j];
            } else {
                odd += s[j];
            }
        }
        console.log(even + " " + odd);
    }
}


function main() {
    const n = parseInt(readLine(), 10);

    for (let i = 1; i <= 10; i++) {
        console.log(`${n} x ${i} = ${n * i}`);
    }
}
