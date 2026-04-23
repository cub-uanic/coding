#!/usr/bin/env python3

# Enter your code here. Read input from STDIN. Print output to STDOUT

import math

T = int(input())
for i in range(T):
    data = int(input())
    isPrime = (data != 1 and data % 2 != 0) or data == 2
    j = 3
    while isPrime and j < math.sqrt(data) + 1:
        isPrime = data % j != 0
        j += 2
    print("Prime" if isPrime else "Not prime")
