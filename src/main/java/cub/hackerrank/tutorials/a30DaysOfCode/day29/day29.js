/* jshint ignore:start */
/* eslint-disable */

'use strict'

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
  return inputString[currentLine++]
}

function main() {
  const t = parseInt(readLine(), 10)

  for (let tItr = 0; tItr < t; tItr++) {
    const nk = readLine().split(' ')
    const n = parseInt(nk[0], 10)
    const k = parseInt(nk[1], 10)

    let a = k - 1
    let b = 0
    for (; a > 0; a--) {
      let lowestZero = 0
      let tmp = a
      while (tmp > 0 && (tmp & 1) === 1) {
        tmp >>= 1
        lowestZero++
      }
      b = a + (1 << lowestZero)
      if (b <= n) {
        break
      }
    }
    console.log(a & b)
  }
}
