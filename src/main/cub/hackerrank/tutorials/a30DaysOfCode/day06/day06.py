# Enter your code here. Read input from STDIN. Print output to STDOUT
n = int(input())
for _ in range(n):
    s = input()
    print(s[0::2] + ' ' + s[1::2])