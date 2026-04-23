/* jslint bitwise: true */
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

function main() {
  let n = parseInt(readLine(), 10)
  let result = 0
  let curr = 0
  while (n > 0) {
    // eslint-disable-next-line no-bitwise
    if (n % 2 === 1) {
      curr += 1
      if (curr > result) {
        result = curr
      }
    } else {
      curr = 0
    }
    // eslint-disable-next-line no-bitwise
    n >>>= 1
  }
  console.log(result)
}
