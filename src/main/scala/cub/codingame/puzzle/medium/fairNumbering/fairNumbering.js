process.stdin.resume()
process.stdin.setEncoding('utf-8')

let ____inputString = ''
let ____currentLine = 0
const ____runningLocally = 1

process.stdin.on('data', (inputStdin) => {
  ____inputString += inputStdin
})

process.stdin.on('end', (_) => {
  ____inputString = ____inputString
    .replace(/\s*$/, '')
    .split('\n')
    .map((str) => str.replace(/\s*$/, ''))

  main(1)
})

function readline() {
  // eslint-disable-next-line no-plusplus
  return ____inputString[____currentLine++]
}

/*
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 */

function digitsCount(st, ed) {
  let count = 0
  const stCapacity = st.toString().length
  const edCapacity = ed.toString().length
  let cnt10 = parseInt(`1${'0'.repeat(stCapacity - 1)}`, 10)
  let cnt90 = cnt10 * 9

  for (let capacity = stCapacity; capacity <= edCapacity; capacity += 1) {
    let numbersCount = capacity === edCapacity ? ed + 1 - cnt10 : cnt90
    if (capacity === stCapacity) {
      numbersCount = numbersCount - st + cnt10
    }
    count += numbersCount * capacity
    cnt10 *= 10
    cnt90 *= 10
  }

  return count
}

function fairNumbering(st, ed) {
  let x = Math.floor((st + ed - 1) / 2)
  let result = st
  while (digitsCount(st, x) <= digitsCount(x + 1, ed)) {
    result = x
    x += 1
  }
  return result
}

main()

function main() {
  // trick for debug locally
  if (typeof ____runningLocally !== 'undefined' && arguments.length === 0) {
    return
  }

  const N = parseInt(readline(), 10)
  for (let i = 0; i < N; i += 1) {
    const inputs = readline().split(' ')
    const st = parseInt(inputs[0], 10)
    const ed = parseInt(inputs[1], 10)
    // eslint-disable-next-line no-console
    console.log(fairNumbering(st, ed))
  }
}

module.exports = { digitsCount, fairNumbering }
