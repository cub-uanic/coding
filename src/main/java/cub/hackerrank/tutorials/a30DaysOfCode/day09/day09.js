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
  // eslint-disable-next-line no-return-assign
  return inputString[(currentLine += 1)]
}

// Complete the factorial function below.
function factorial(n) {
  return n > 1 ? factorial(n - 1) * n : 1
}

function main() {
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH)
  const n = parseInt(readLine(), 10)
  const result = factorial(n)
  ws.write(`${result}\n`)
  ws.end()
}
