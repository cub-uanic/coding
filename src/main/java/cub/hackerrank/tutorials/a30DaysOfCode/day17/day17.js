process.stdin.resume()
process.stdin.setEncoding('ascii')

// eslint-disable-next-line
var input_stdin = ''
// eslint-disable-next-line
var input_stdin_array = ''
// eslint-disable-next-line
var input_currentline = 0

process.stdin.on('data', function (data) {
  // eslint-disable-next-line
  input_stdin += data
})

process.stdin.on('end', function () {
  // eslint-disable-next-line
  input_stdin_array = input_stdin.split('\n')
  main()
})
function readLine() {
  // eslint-disable-next-line
  return input_stdin_array[input_currentline++]
}

// Write your code here
class Calculator {
  // eslint-disable-next-line
  power(n, p) {
    if (n < 0 || p < 0) {
      // eslint-disable-next-line
      throw 'n and p should be non-negative'
    }
    return n ** p
  }
}

function main() {
  const myCalculator = new Calculator()
  // eslint-disable-next-line
  let T = parseInt(readLine())
  // eslint-disable-next-line
  while (T-- > 0) {
    const num = readLine().split(' ')
    try {
      // eslint-disable-next-line
      var n = parseInt(num[0])
      // eslint-disable-next-line
      var p = parseInt(num[1])
      const ans = myCalculator.power(n, p)
      console.log(ans)
    } catch (e) {
      console.log(e)
    }
  }
}
