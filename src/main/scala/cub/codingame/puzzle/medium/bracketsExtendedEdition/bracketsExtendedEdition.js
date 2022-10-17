/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

const N = parseInt(readline());
for (let i = 0; i < N; i++) {
    const expression = readline();
    const stack = []
    let bracket
    expression
        .split('')
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
                if (stack.length !== 0 && stack[stack.length-1] === bracket) {
                    stack.pop()
                } else {
                    stack.push(bracket)
                }
            }
        })

    // Write an answer using console.log()
    // To debug: console.error('Debug messages...');
    console.log(stack.length > 0 ? 'false' : 'true');
}
