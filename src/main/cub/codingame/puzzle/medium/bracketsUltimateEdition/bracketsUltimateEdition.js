/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
function countOfChar(expression, chr) {
    // escape when needed, see !mdn escapeRegExp (has a bug)
    chr = chr.replace(/[.*+\-?^${}()|\[\]\\]/g, "\\$&")
    const regexp = new RegExp(chr, "g")
    return (expression.match(regexp) || []).length
}

function checkBracketsCount(e, open, close) {
    const cntOpen = countOfChar(e, open)
    const cntClose = countOfChar(e, close)
    return (cntOpen + cntClose) % 2 === 0
}

function hasSolution(e) {
    const stack = []
    let bracket
    e.split('')
        .forEach(chr => {
            switch (chr) {
                case '<':
                case '>':
                    bracket = 1
                    break
                case '[':
                case ']':
                    bracket = 2
                    break
                case '(':
                case ')':
                    bracket = 3
                    break
                case '{':
                case '}':
                    bracket = 4
                    break
                default:
                    bracket = 0
            }
            if (bracket !== 0) {
                if (stack.length !== 0 && stack[stack.length - 1] === bracket) {
                    stack.pop()
                } else {
                    stack.push(bracket)
                }
            }
        })
    return stack.length === 0
}

function countFlipsFor(e) {
    let flips = 0

    while (e.length > 0) {
        while (true) {
            const n = e
                .replace(/\[]/g, "")
                .replace(/{}/g, "")
                .replace(/\(\)/g, "")
                .replace(/<>/g, "")
            if (n.length === e.length) {
                break
            } else {
                e = n
            }
        }

        e = e.replace(/[\[\]]{2}|[{}]{2}|[()]{2}|[<>]{2}/,
            (match) => {
                const chr1 = match.charAt(0)
                if (chr1 === ']' || chr1 === '}' || chr1 === ')' || chr1 === '>') {
                    flips++
                }
                const chr2 = match.charAt(1)
                if (chr2 === '[' || chr2 === '{' || chr2 === '(' || chr2 === '<') {
                    flips++
                }
                return ""
            })


    }

    return flips
}

function getFlipsFor(e) {
    if (!checkBracketsCount(e, "[", ']') ||
        !checkBracketsCount(e, "<", '>') ||
        !checkBracketsCount(e, "{", '}') ||
        !checkBracketsCount(e, "(", ')') ||
        !hasSolution(e)
    ) {
        return -1
    }
    e = e.replace(/[^\[\]{}()<>]/g, "")
    return countFlipsFor(e)
}

const N = parseInt(readline());
for (let i = 0; i < N; i++) {
    const expression = readline();

    // Write an answer using console.log()
    // To debug: console.error('Debug messages...');
    let flips = getFlipsFor(expression)
    console.log(flips);
}
