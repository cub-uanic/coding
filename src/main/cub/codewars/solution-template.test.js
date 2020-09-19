'use strict';

const Solution = require('./solution')

const Test = {
    describe,
    it,
    assertDeepEquals(val1, val2) {
        return expect(val1).toStrictEqual(val2)
    }
}