/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

let inputs

inputs = readline().split(' ');
console.error(inputs)
const W = parseInt(inputs[0]); // width of the building.
const H = parseInt(inputs[1]); // height of the building.
const N = parseInt(readline()); // maximum number of turns before game over.

inputs = readline().split(' ');
console.error(inputs)
let lastX = parseInt(inputs[0]);
let lastY = parseInt(inputs[1]);

let nextX = lastX
let nextY = lastY
let windows = Array(W).fill().map(() => Array(H).fill(1))
let acceptable = W*H

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

// game loop
while (true) {
    const bombDir = readline(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
    windows[nextX][nextY] = 0
    acceptable--

    console.error(`acc: ${acceptable}, last(${lastX},${lastY}), next(${nextX},${nextY}), dir: ${bombDir}`)
    console.error(windows.map(row => row.join("")).join("\n"))

    // Write an action using console.log()
    // To debug: console.error('Debug messages...');

    switch (bombDir) {
        case "UNKNOWN":
            nextX = (W - lastX) >> 1
            nextY = (H - lastY) >> 1
            break
        case "COLDER":
        case "WARMER":
        case "SAME":
            markWindows(
                lastX, lastY,
                nextX, nextY,
                bombDir === "COLDER" ? -1
                    : bombDir === "WARMER" ? 1
                    : 0 // SAME
            )

            let newX, newY
            switch (bombDir) {
                case "COLDER":
                    newX = (3 * lastX - nextX) >> 1
                    newY = (3 * lastY - nextY) >> 1
                    break
                case "WARMER":
                    newX = (3 * nextX - lastX) >> 1
                    newY = (3 * nextY - lastY) >> 1
                    break
                case "SAME":
                    newX = (lastX + nextX) >> 1
                    newY = (lastY + nextY) >> 1
                    break
            }
            console.error(`C: ${newX} ${newY}`);

            if (newX < 0) newX = 0
            if (newY < 0) newY = 0
            if (newX >= W) newX = W-1
            if (newY >= H) newY = H-1

            if (windows[newX][newY] === 0) {
                if (newX-1>=0 && newY-1   && windows[newX-1][newY-1] === 1) { newX--, newY--}
                else if (newX-1>=0 &&             windows[newX-1][newY]   === 1) { newX--}
                else if (newX-1>=0 && newY+1<H && windows[newX-1][newY+1] === 1) { newX--, newY++}
                else if (             newY-1   && windows[newX][newY-1]   === 1) { newY--}
                else if (             newY+1<H && windows[newX][newY+1]   === 1) { newY++}
                else if (newX+1<W &&  newY-1   && windows[newX+1][newY-1] === 1) { newX++, newY--}
                else if (newX+1<W &&              windows[newX+1][newY]   === 1) { newX++}
                else if (newX+1<W &&  newY+1<H && windows[newX+1][newY+1] === 1) { newX++, newY++}
            }
            console.error(`F: ${newX} ${newY}`);

            lastX = nextX
            lastY = nextY
            nextX = newX
            nextY = newY

            break
    }

    // the location of the next window Batman should jump to.
    console.log(`${nextX} ${nextY}`);
}
