#!/usr/bin/env python3

if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        nk = input().split()
        n = int(nk[0])
        k = int(nk[1])

        a = k - 1
        b = 0
        while a > 0:
            lowestZero = 0
            tmp = a
            while tmp > 0 and (tmp & 1) == 1:
                tmp >>= 1
                lowestZero += 1
            b = a + (1 << lowestZero)
            if b <= n:
                break
            a -= 1
        print(a & b)
