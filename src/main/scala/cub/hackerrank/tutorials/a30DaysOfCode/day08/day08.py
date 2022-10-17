#!/usr/bin/env python3

pb = {}
n = int(input())

for _ in range(n):
    s = input().split(' ', 1)
    pb[s[0]] = s[1]

while True:
    try:
        l = input()
    except EOFError:
        break
    print(''.join([l, '=', pb.get(l)]) if l in pb.keys() else 'Not found')
