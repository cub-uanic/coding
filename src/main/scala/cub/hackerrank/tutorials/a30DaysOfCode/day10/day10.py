#!/usr/bin/env python3

import os

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())
    result, curr = 0, 0
    while n > 0:
        if n & 1 == 1:
            curr += 1
            if curr > result: result = curr
        else:
            curr = 0
        n >>= 1

    fptr.write(str(result) + '\n')
    fptr.close()
