/* jshint ignore:start */
/* eslint-disable */
process.stdin.resume()
process.stdin.setEncoding('ascii')

let input_stdin = ''
let input_stdin_array = ''
let input_currentline = 0

process.stdin.on('data', function (data) {
  input_stdin += data
})

process.stdin.on('end', function () {
  input_stdin_array = input_stdin.split('\n')
  main()
})

function readLine() {
  return input_stdin_array[input_currentline++]
}

/// //////////// ignore above this line ////////////////////

function main() {
  const n = parseInt(readLine())
  a = readLine().split(' ')
  a = a.map(Number)

  // Write Your Code Here

  let numberOfSwaps = 0
  for (let i = 0; i < n; i += 1) {
    for (let j = 0; j < n - 1; j += 1) {
      if (a[j] > a[j + 1]) {
        x = a[j]
        a[j] = a[j + 1]
        a[j + 1] = x
        numberOfSwaps += 1
      }
    }

    if (numberOfSwaps === 0) {
      break
    }
  }

  console.log(`Array is sorted in ${numberOfSwaps} swaps.`)
  console.log(`First Element: ${a[0]}`)
  console.log(`Last Element: ${a[n - 1]}`)
}
