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
    .trim()
    .split('\n')
    .map((str) => str.trim())

  main()
})

function readLine() {
  // eslint-disable-next-line
  return inputString[currentLine++]
}

/*
 * Complete the timeConversion function below.
 */
function timeConversion(s) {
  const time12 = s.toUpperCase()
  const [_, hh, rest, ampm] = time12.match(/^(..)(.*)(..)$/)
  let h = parseInt(hh, 10)
  if (ampm === 'PM') {
    if (h === 12) {
      h = 12
    } else {
      h += 12
    }
  } else if (h === 12) {
    h = 0
  }
  return h.toString().padStart(2, '0') + rest
}

function main() {
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH)
  const s = readLine()
  const result = timeConversion(s)
  ws.write(`${result}\n`)
  ws.end()
}
