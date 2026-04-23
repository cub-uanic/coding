const CANT_DO_THAT = Symbol("CANT_DO_THAT")

function lookAndSay(s) {
    if (s === CANT_DO_THAT) {
        return CANT_DO_THAT
    }

    let inputDigits = s.split("")
    let inputIdx = 0

    let outputDigits = []
    while (inputIdx < inputDigits.length) {
        const digit = inputDigits[inputIdx]
        let count = 1
        while (inputDigits[inputIdx + count] === digit) {
            count++
        }
        outputDigits.push(count)
        outputDigits.push(digit)
        inputIdx += count
    }

    return outputDigits.join("")
}

function reverseLookAndSay(s) {
    if (s === CANT_DO_THAT) {
        return CANT_DO_THAT
    }

    if (s.length % 2 === 1) {
        // count of input digits is odd, proper reversing is not possible
        return CANT_DO_THAT
    }

    let inputDigits = s.split("")
    let inputIdx = 0

    let outputDigits = []
    while (inputIdx < inputDigits.length) {
        let count = +inputDigits[inputIdx++]
        const digit = inputDigits[inputIdx++]
        while (count-- > 0) {
            outputDigits.push(digit)
        }
    }

    return outputDigits.join("")
}

let s = readline()

const seen = new Set()
while (true) {
    const reversed = reverseLookAndSay(s)
    const check = lookAndSay(reversed)
    if (
        seen.has(s) ||                  // loop detected
        reversed === CANT_DO_THAT ||    // can't reverse
        check === CANT_DO_THAT ||       // input for lookAndSay was null
        s !== check                     // non-reversible step
    ) {
        console.log(s)
        break
    } else {
        seen.add(s)
        s = reversed
    }
}
