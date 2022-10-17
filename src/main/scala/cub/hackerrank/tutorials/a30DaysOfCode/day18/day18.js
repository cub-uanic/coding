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
/* eslint-enable */

// Write your code here
function Solution() {
  this.stack = []
  this.queue = []
  this.stackIdx = 0
  this.queueHead = 0
  this.queueTail = 0
  this.pushCharacter = function (c) {
    // eslint-disable-next-line
    this.stack[this.stackIdx++] = c
  }
  this.popCharacter = function () {
    // eslint-disable-next-line
    return this.stack[--this.stackIdx]
  }
  this.enqueueCharacter = function (c) {
    // eslint-disable-next-line
    this.queue[this.queueHead++] = c
  }
  this.dequeueCharacter = function () {
    // eslint-disable-next-line
    return this.queue[this.queueTail++]
  }
}

/* eslint-disable */
function main() {
  // read the string s
  const s = readLine()
  const len = s.length
  // create the Solution class object p
  const obj = new Solution()
  // push/enqueue all the characters of string s to stack
  for (var i = 0; i < len; i++) {
    obj.pushCharacter(s.charAt(i))
    obj.enqueueCharacter(s.charAt(i))
  }

  let isPalindrome = true
  /*
  pop the top character from stack
  dequeue the first character from queue
  compare both the characters */

  for (var i = 0; i < len / 2; i++) {
    if (obj.popCharacter() != obj.dequeueCharacter()) {
      isPalindrome = false
      break
    }
  }
  // finally print whether string s is palindrome or not

  if (isPalindrome) console.log(`The word, ${s}, is a palindrome.`)
  else console.log(`The word, ${s}, is not a palindrome.`)
}
/* eslint-enable */
