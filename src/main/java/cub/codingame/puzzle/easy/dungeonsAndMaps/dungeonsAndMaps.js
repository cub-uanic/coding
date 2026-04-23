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

    let inputs

    inputs = readline().split(' ')
    const w = parseInt(inputs[0])
    const h = parseInt(inputs[1])

    inputs = readline().split(' ')
    const startRow = parseInt(inputs[0])
    const startCol = parseInt(inputs[1])

    const n = parseInt(readline());

    let gameMaps = new Array(n)

    for (let i = 0; i < n; i++) {
        let currentMap = new Array(h)
        for (let j = 0; j < h; j++) {
            const mapRow = readline()
            currentMap[j] = mapRow
        }
        gameMaps[i] = currentMap
    }

    String.prototype.replaceAt = function (index, replacement) {
        return this.substr(0, index) + replacement + this.substr(index + replacement.length);
    }

    const shortestMap = findShortestPathLen(w, h, startRow, startCol, gameMaps)
    // Write an answer using console.log()
    // To debug: console.error('Debug messages...');
    console.log(shortestMap)
}

function findShortestPathLen(w, h, startRow, startCol, gameMaps) {
    let shortestPathLen = NaN, shortestMap = NaN
    gameMaps.forEach((currentMap, idx) => {
        const pathLen = findPathLen(w, h, startRow, startCol, currentMap)
        if (!isNaN(pathLen) && (isNaN(shortestPathLen) || pathLen < shortestPathLen)) {
            shortestPathLen = pathLen
            shortestMap = idx
        }
    })
    return isNaN(shortestMap) ? "TRAP" : shortestMap
}

function findPathLen(w, h, startRow, startCol, currentMap) {
    let pathLen = NaN, x = startRow, y = startCol
    let field
    do {
        field = currentMap[x].charAt(y);
        if (!'v^<>'.includes(field)) {
            break
        }
        currentMap[x] = currentMap[x].replaceAt(y, '.')
        if (isNaN(pathLen)) {
            pathLen = 1
        } else {
            pathLen++
        }
        switch (field) {
            case '<':
                y--;
                break;
            case '>':
                y++;
                break;
            case '^':
                x--;
                break;
            case 'v':
                x++;
                break;
        }
        if (x < 0 || x >= w || y < 0 || y >= h) {
            break
        }
    } while (1)
    if (field === 'T') {
        return (pathLen || 0) + 1;
    } else {
        return NaN
    }
}
