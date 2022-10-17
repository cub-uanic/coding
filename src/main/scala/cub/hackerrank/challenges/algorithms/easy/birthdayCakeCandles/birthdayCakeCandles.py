#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'birthdayCakeCandles' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY candles as parameter.
#

def birthdayCakeCandles(candles):
    tallest = -1
    tallest_idx = -1
    for idx in range(len(candles)):
        if tallest_idx == -1 or candles[idx] > candles[tallest_idx]:
            tallest = 1
            tallest_idx = idx
        elif candles[idx] == candles[tallest_idx]:
            tallest += 1
    return tallest

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    candles_count = int(input().strip())

    candles = list(map(int, input().rstrip().split()))

    result = birthdayCakeCandles(candles)

    fptr.write(str(result) + '\n')

    fptr.close()
