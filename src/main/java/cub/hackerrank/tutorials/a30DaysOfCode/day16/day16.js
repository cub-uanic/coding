process.stdin.resume()
process.stdin.setEncoding('ascii')

// eslint-disable-next-line
let input_stdin = ''
// eslint-disable-next-line
let input_stdin_array = ''
// eslint-disable-next-line
let input_currentline = 0

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

/// //////////// ignore above this line ////////////////////

/*
 * You can use the following pseudocode:
 *
 * `S` = read string from stdin.
 * try {
 *     `N` = numeric value of `S`.
 *
 *     If `N` is `NaN` or `undefined`, then some exception must be thrown,
 *     you can write the following withtout using conditional statement:
 *     <condition to return true when `N` is `NaN` or `undefined`> && an_undefined_function_call()
 *
 *     print `N`
 * } catch (err) {
 *     print `Bad String`.
 * }
 */

function main() {
  const S = readLine()

  try {
    S != Number(S) && an_undefined_function_call()
    console.log(S)
  } catch (err) {
    console.log('Bad String')
  }
}
