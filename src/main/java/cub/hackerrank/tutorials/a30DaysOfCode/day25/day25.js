/* jshint ignore:start */
/* eslint-disable */

process.stdin.resume()
process.stdin.setEncoding('ascii')

var input_stdin = ''
var input_stdin_array = ''
var input_currentline = 0

process.stdin.on('data', function (data) {
  input_stdin += data
})

process.stdin.on('end', function () {
  input_stdin_array = input_stdin.split('\n')
  processData()
})

function readLine() {
  return input_stdin_array[input_currentline++]
}

function processData() {
  //Enter your code here
  let idx = parseInt(readLine())
  while (idx-- > 0) {
    let ele = parseInt(readLine())
    let isPrime = (ele !== 1 && ele % 2 !== 0) || ele === 2
    let j = 3
    while (isPrime && j < Math.sqrt(ele) + 1) {
      isPrime = ele % j !== 0
      j += 2
    }

    if (isPrime) {
      console.log('Prime')
    } else {
      console.log('Not prime')
    }
  }
}
