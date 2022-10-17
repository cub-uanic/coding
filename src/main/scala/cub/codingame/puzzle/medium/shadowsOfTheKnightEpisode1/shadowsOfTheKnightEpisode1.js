/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

let inputs

inputs = readline().split(' ');
const W = parseInt(inputs[0]); // width of the building.
const H = parseInt(inputs[1]); // height of the building.
const N = parseInt(readline()); // maximum number of turns before game over.

inputs = readline().split(' ');
let x = parseInt(inputs[0]);
let y = parseInt(inputs[1]);

let minX = 0
let minY = 0
let maxX = W - 1
let maxY = H - 1

// game loop
while (true) {
    const bombDir = readline(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

    // Write an action using console.log()
    // To debug: console.error('Debug messages...');

    if (bombDir.indexOf("R") >= 0) {
        let newX = x + Math.ceil((maxX - x) / 2)
        minX = x
        x = newX
    }

    if (bombDir.indexOf("L") >= 0) {
        let newX = minX + Math.floor((x - minX) / 2)
        maxX = x
        x = newX
    }

    if (bombDir.indexOf("D") >= 0) {
        let newY = y + Math.ceil((maxY - y) / 2)
        minY = y
        y = newY
    }

    if (bombDir.indexOf("U") >= 0) {
        let newY = minY + Math.floor((y - minY) / 2)
        maxY = y
        y = newY
    }

    // the location of the next window Batman should jump to.
    console.log(`${x} ${y}`);
}
