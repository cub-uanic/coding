'use strict';

process.stdin.resume()
process.stdin.setEncoding('utf-8')

let ____inputString = ''
let ____currentLine = 0
let ____running_locally = 1

process.stdin.on('data', inputStdin => {
    ____inputString += inputStdin
});

process.stdin.on('end', _ => {
    ____inputString = ____inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''))

    main(1)
});

function readline() {
    return ____inputString[____currentLine++]
}


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
main()

function main() {
    // trick for debug locally
    if (typeof ____running_locally !== "undefined" && arguments.length === 0) {
        return
    }

    // your program below
    // no globals should be used
    let inputs
    inputs = readline().split(' ')
    const w = parseInt(inputs[0])
    const h = parseInt(inputs[1])
    // .... and so on
}
