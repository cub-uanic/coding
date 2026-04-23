#!/usr/bin/env python3

import sys

n = int(input().strip())
a = list(map(int, input().strip().split(' ')))

# Write Your Code Here
totalNumberOfSwaps = 0
for i in range(n):
    numberOfSwaps = 0
    for j in range(n-1):
        if a[j] > a[j + 1]:
            a[j], a[j + 1] = a[j + 1], a[j]
            numberOfSwaps += 1
    totalNumberOfSwaps += numberOfSwaps

    if numberOfSwaps == 0:
        break

print(f'Array is sorted in {totalNumberOfSwaps} swaps.')
print(f'First Element: {a[0]}')
print(f'Last Element: {a[n - 1]}')
