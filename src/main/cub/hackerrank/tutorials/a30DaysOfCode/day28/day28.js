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
  main()
})

function readLine() {
  return input_stdin_array[input_currentline++]
}

class Row {
  constructor(firstName, emailID) {
    this.firstName = firstName
    this.emailID = emailID
  }
}

function main() {
  const db = []
  const N = parseInt(readLine(), 10)
  for (let NItr = 0; NItr < N; NItr++) {
    const firstNameEmailID = readLine().split(' ')
    const firstName = firstNameEmailID[0]
    const emailID = firstNameEmailID[1]
    db.push(new Row(firstName, emailID))
  }

  db.filter((row) => row.emailID.match('^.*@gmail.com$'))
    .map((row) => row.firstName)
    .sort()
    .forEach((firstName) => console.log(firstName))
}
