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
main()

function main() {
  // trick for debug locally
  if (typeof ____runningLocally !== 'undefined' && arguments.length === 0) {
    return
  }

  // your program below
  // no globals should be used
  let inputs
  // eslint-disable-next-line prefer-const
  inputs = readline().split(' ')
  // eslint-disable-next-line no-unused-vars
  const w = parseInt(inputs[0], 10)
  // eslint-disable-next-line no-unused-vars
  const h = parseInt(inputs[1], 10)
  // .... and so on
}
