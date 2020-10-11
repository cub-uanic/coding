#!/usr/bin/env python3

# Enter your code here. Read input from STDIN. Print output to STDOUT

da, ma, ya = list(map(int, input().split(' ')))
de, me, ye = list(map(int, input().split(' ')))

if ya < ye or (ya == ye and ma < me) or (ya == ye and ma == me and da <= de):
    print(0)
elif ya > ye:
    print('10000')
elif ma > me:
    print(500 * (ma - me))
elif da > de:
    print(15 * (da - de))
