const fs = require('fs')

process.stdin.resume()
process.stdin.setEncoding('utf-8')

let inputString = ''
let currentLine = 0

process.stdin.on('data', (inputStdin) => {
  inputString += inputStdin
})

process.stdin.on('end', (_) => {
  inputString = inputString
    .replace(/\s*$/, '')
    .split('\n')
    .map((str) => str.replace(/\s*$/, ''))

  main()
})

function readLine() {
  // eslint-disable-next-line no-plusplus
  return inputString[currentLine++]
}

// Complete the hourglassSum function below.
function hourglassSum(arr) {
  let maxHourglassSum = -1000000
  for (let x = 1; x < 5; x += 1) {
    for (let y = 1; y < 5; y += 1) {
      const currHourglassSum =
        arr[x - 1][y - 1] +
        arr[x - 1][y] +
        arr[x - 1][y + 1] +
        arr[x][y] +
        arr[x + 1][y - 1] +
        arr[x + 1][y] +
        arr[x + 1][y + 1]
      if (currHourglassSum > maxHourglassSum) {
        maxHourglassSum = currHourglassSum
      }
    }
  }
  return maxHourglassSum
}

function main() {
  // eslint-disable-next-line security/detect-non-literal-fs-filename
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH)

  const arr = Array(6)
  for (let i = 0; i < 6; i += 1) {
    arr[i] = readLine()
      .split(' ')
      .map((arrTemp) => parseInt(arrTemp, 10))
  }
  const result = hourglassSum(arr)

  ws.write(`${result}\n`)
  ws.end()
}
