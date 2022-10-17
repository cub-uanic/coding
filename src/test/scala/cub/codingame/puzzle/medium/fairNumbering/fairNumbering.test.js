/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * */

const {
  digitsCount,
  fairNumbering,
} = require('../../../../../../../main/scala/cub/codingame/puzzle/medium/fairNumbering/fairNumbering')

describe('Testing digitsCount', () => {
  test('Incorrect arguments', () => {
    expect(digitsCount(10, 1)).toEqual(0)
  })
  test('Simple cases', () => {
    const inputData = [
      [1, 1, 1],
      [1, 2, 2],
      [1, 3, 3],
      [1, 9, 9],
      [1, 10, 11],
      [2, 2, 1],
      [2, 3, 2],
      [2, 9, 8],
      [2, 10, 10],
      [8, 10, 4],
      [9, 10, 3],
      [8, 11, 6],
      [8, 8, 1],
      [1, 12, 15],
      [1, 128, 276],
      [1, 200, 492],
      [12, 200, 479],
      [128, 200, 219],
      [200, 200, 3],
    ]

    for (let i = 0; i < inputData.length; i += 1) {
      const [st, ed, exp] = inputData[i]
      expect(digitsCount(st, ed)).toEqual(exp)
    }
  })
})

describe('Testing fairNumbering', () => {
  test('Simple cases', () => {
    const inputData = [
      [8, 10, 9],
      [9, 10, 9],
      [8, 11, 9],
      [1, 200, 118],
      [99, 100, 99],
      [97, 101, 99],
      [98, 100, 98],
      [32804, 93666, 63234],
      [4, 1000000, 509259],
      [5, 1000000, 509259],
      [6, 1000000, 509259],
      [9, 1000000, 509259],
      [10, 1000000, 509259],
      [11, 1000000, 509259],
    ]

    for (let i = 0; i < inputData.length; i += 1) {
      const [st, ed, exp] = inputData[i]
      expect(fairNumbering(st, ed)).toEqual(exp)
    }
  })
})
