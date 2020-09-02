/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

const d60 = Math.PI * 60 / 180
const d120 = Math.PI * 120 / 180
const d150 = Math.PI * 150 / 180
const d180 = Math.PI
const sin60 = Math.sin(d60)
const cos60 = Math.cos(d60)
const sin_60 = Math.sin(-d60)
const cos_60 = Math.cos(-d60)
const sin120 = Math.sin(d120)
const cos120 = Math.cos(d120)
const sin_120 = Math.sin(-d120)
const cos_120 = Math.cos(-d120)
const sin150 = Math.sin(d150)
const cos150 = Math.cos(d150)
const sin_150 = Math.sin(-d150)
const cos_150 = Math.cos(-d150)
const sin180 = Math.sin(d180)
const cos180 = Math.cos(d180)


let inputs
let nextX = 0
let nextY = 0
let directionX = 0
let directionY = 0
let directionAngle = 0
let warmerDirectionScale = 2 / 3
let colderDirectionScale = Math.sqrt(3) / 2
let sameDirectionScale = 1 / 2

inputs = readline().split(' ');
console.error(inputs)
const W = parseInt(inputs[0]); // width of the building.
const H = parseInt(inputs[1]); // height of the building.
const N = parseInt(readline()); // maximum number of turns before game over.

inputs = readline().split(' ');
console.error(inputs)
let lastX = parseInt(inputs[0]);
let lastY = parseInt(inputs[1]);

// del?
let windows = Array(W).fill().map(() => Array(H).fill(1))
let acceptable = W * H

// del?
function markWindows(lastX, lastY, nextX, nextY, marker) {
    for (let x = 0; x < W; x++) {
        for (let y = 0; y < H; y++) {
            if (windows[x][y] === 0) {
                // point already excluded
                continue
            }
            // for comparison, no need to take square roots
            const distLast = (lastX - x) * (lastX - x) + (lastY - y) * (lastY - y)
            const distNext = (nextX - x) * (nextX - x) + (nextY - y) * (nextY - y)
            // console.error(`${x},${y} -> l:${distLast}, n:${distNext}, m:${marker}, s:${Math.sign(distLast - distNext)}`)
            if (Math.sign(distLast - distNext) !== marker) {
                windows[x][y] = 0
                acceptable--
            }
        }
    }
}

{
    let directionX = 0
    let directionY = 2
    let directionAngle = 1
    let rotDx = directionX * directionAngle * cos60 - directionY * directionAngle * sin60
    let rotDy = directionX * directionAngle * sin60 + directionY * directionAngle * cos60
    console.error(`rot: ${rotDx}, ${rotDy}`)
}

function fixDirection() {
    // if (Math.abs(directionX) < 1) {
    //     directionX = Math.sign(directionX)
    // }
    // if (Math.abs(directionY) < 1) {
    //     directionY = Math.sign(directionY)
    // }
    directionX = Math.floor(directionX)
    directionY = Math.floor(directionY)
}

// game loop
while (true) {
    const bombDir = readline(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

    // del?
    if (bombDir !== "UNKNOWN") {
        windows[nextX][nextY] = 0
        acceptable--

        markWindows(
            lastX, lastY,
            nextX, nextY,
            bombDir === "COLDER" ? -1
                : bombDir === "WARMER" ? 1
                : 0 // SAME
        )
    }

    // del?
    console.error(`last(${lastX},${lastY}), next(${nextX},${nextY}), dir: ${bombDir}`)
    console.error(`d(${directionX},${directionY},${directionAngle})`)
    console.error(windows.map(row => row.join("")).join("\n"))

    // Write an action using console.log()
    // To debug: console.error('Debug messages...');

    let rotDx, rotDy
    switch (bombDir) {
        case "UNKNOWN":
            directionX = Math.sign(W / 2 - lastX) * W
            directionY = Math.sign(H / 2 - lastY) * H
            directionAngle = 1
            break
        case "WARMER":
            rotDx = directionX * directionAngle * cos120 - directionY * directionAngle * sin120
            rotDy = directionX * directionAngle * sin120 + directionY * directionAngle * cos120
            directionX = rotDx * warmerDirectionScale
            directionY = rotDy * warmerDirectionScale
            break
        case "COLDER":
            rotDx = directionX * directionAngle * cos150 - directionY * directionAngle * sin150
            rotDy = directionX * directionAngle * sin150 + directionY * directionAngle * cos150
            directionX = rotDx * colderDirectionScale
            directionY = rotDy * colderDirectionScale
            // directionAngle = -directionAngle
            break
        case "SAME":
            rotDx = directionX * directionAngle * cos180 - directionY * directionAngle * sin180
            rotDy = directionX * directionAngle * sin180 + directionY * directionAngle * cos180
            directionX = rotDx * sameDirectionScale
            directionY = rotDy * sameDirectionScale
            // directionAngle = -directionAngle
            break
    }

    console.error(`d: ${directionX} ${directionY}`);
    fixDirection()
    console.error(`D: ${directionX} ${directionY}`);
    lastX = nextX
    lastY = nextY
    nextX = nextX + directionX
    nextY = nextY + directionY

    console.error(`n: ${nextX} ${nextY}`);

    nextX = Math.floor(nextX)
    nextY = Math.floor(nextY)

    if (nextX < 0) nextX = 0
    if (nextY < 0) nextY = 0
    if (nextX >= W) nextX = W - 1
    if (nextY >= H) nextY = H - 1

    // the location of the next window Batman should jump to.
    console.log(`${nextX} ${nextY}`);
}
