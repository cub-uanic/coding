// eslint-disable-next-line
let input_stdin = ''
// eslint-disable-next-line
let input_stdin_array = ''
// eslint-disable-next-line
let input_currentline = 0

process.stdin.resume()
process.stdin.setEncoding('ascii')

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

function Node(data) {
  this.data = data
  this.next = null
}

function Solution() {
  this.insert = function (head, data) {
    // complete this method
    if (head === null) {
      return new Node(data)
    }

    let tail = head
    while (tail.next !== null) tail = tail.next
    tail.next = new Node(data)
    return head
  }

  this.display = function (head) {
    let start = head
    while (start) {
      process.stdout.write(`${start.data} `)
      start = start.next
    }
  }
}

function main() {
  // eslint-disable-next-line
  const T = parseInt(readLine())
  let head = null
  const mylist = new Solution()
  // eslint-disable-next-line
  for (i = 0; i < T; i++) {
    // eslint-disable-next-line
    const data = parseInt(readLine())
    head = mylist.insert(head, data)
  }
  mylist.display(head)
}
