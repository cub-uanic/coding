#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the plusMinus function below.
def plusMinus(arr):
    n, z, p = 0, 0, 0
    for i in arr:
        if i < 0: n += 1
        if i == 0: z += 1
        if i > 0: p += 1
    print("{:.6f}".format(p / (len(arr))))
    print("{:.6f}".format(n / (len(arr))))
    print("{:.6f}".format(z / (len(arr))))

if __name__ == '__main__':
    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    plusMinus(arr)
