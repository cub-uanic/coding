function processData(input) {
  const arr = input.split('\n').reverse()
  const n = parseInt(arr.pop(), 10)
  const pb = new Map()
  for (let i = 0; i < n; i += 1) {
    const s = arr.pop().split(' ')
    pb.set(s[0], s[1])
  }
  while (arr.length > 0) {
    const s = arr.pop()
    // eslint-disable-next-line no-console
    console.log(pb.has(s) ? `${s}=${pb.get(s)}` : 'Not found')
  }
}

process.stdin.resume()
process.stdin.setEncoding('ascii')
let _input = ''
process.stdin.on('data', (input) => {
  _input += input
})

process.stdin.on('end', () => {
  processData(_input)
})
