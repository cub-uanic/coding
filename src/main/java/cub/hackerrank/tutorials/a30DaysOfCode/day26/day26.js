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
  // Enter your code here

  const [da, ma, ya] = readLine()
    .split(/ /)
    .map((i) => parseInt(i))
  const [de, me, ye] = readLine()
    .split(/ /)
    .map((i) => parseInt(i))

  if (
    ya < ye ||
    (ya === ye && ma < me) ||
    (ya === ye && ma === me && da <= de)
  ) {
    console.log(0)
  } else if (ya > ye) {
    console.log('10000')
  } else if (ma > me) {
    console.log(500 * (ma - me))
  } else if (da > de) {
    console.log(15 * (da - de))
  }
}
