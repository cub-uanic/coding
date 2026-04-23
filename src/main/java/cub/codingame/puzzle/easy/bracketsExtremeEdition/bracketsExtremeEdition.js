/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

const expression = readline();
console.error(expression)

const stack = []

try {
    expression
        .split('')
        .forEach(chr => {
            switch (chr) {
                case '<':
                case '[':
                case '(':
                case '{':
                    stack.push(chr)
                    break
                case '>':
                case ']':
                case ')':
                case '}':
                    const bracket = stack.pop()
                    if (!(
                        (bracket === '<' && chr === '>') ||
                        (bracket === '[' && chr === ']') ||
                        (bracket === '(' && chr === ')') ||
                        (bracket === '{' && chr === '}')
                    )) {
                        throw Error('unpaired')
                    }
                    break
                default:
                    // just ignore
                    break
            }
        })
} catch (e) {
    // emulate error - non-null stack on finish
    stack.length > 0 || stack.push(1)
}

// Write an answer using console.log()
// To debug: console.error('Debug messages...');
console.log(stack.length > 0 ? 'false' : 'true');
