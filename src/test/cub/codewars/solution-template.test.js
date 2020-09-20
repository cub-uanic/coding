const Solution = require('../../../main/cub/codewars/solution-template')

const Test = {
  describe,
  it,
  test,
  expect,
  assertDeepEquals(val1, val2) {
    return expect(val1).toStrictEqual(val2)
  },
}

// eslint-disable-next-line no-console
Test.test('Trivial boilerplate', () => {
  Test.expect(Solution).not.toStrictEqual(Test)
})

// console.log(Solution, Test) // jshint ignore:line
