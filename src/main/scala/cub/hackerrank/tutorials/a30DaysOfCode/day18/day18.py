#!/usr/bin/env python3

import sys


# Write your code here
class Solution:
    def __init__(self):
        self.stack = [None for x in range(1024)]
        self.queue = [None for x in range(1024)]
        self.stackIdx = 0
        self.queueHead = 0
        self.queueTail = 0

    def pushCharacter(self, c):
        self.stack[self.stackIdx] = c
        self.stackIdx += 1

    def popCharacter(self):
        self.stackIdx -= 1
        return self.stack[self.stackIdx]

    def enqueueCharacter(self, c):
        self.queue[self.queueHead] = c
        self.queueHead += 1

    def dequeueCharacter(self):
        result = self.queue[self.queueTail]
        self.queueTail += 1
        return result


# read the string s
s = input()
# Create the Solution class object
obj = Solution()

l = len(s)
# push/enqueue all the characters of string s to stack
for i in range(l):
    obj.pushCharacter(s[i])
    obj.enqueueCharacter(s[i])

isPalindrome = True
'''
pop the top character from stack
dequeue the first character from queue
compare both the characters
'''
for i in range(l // 2):
    if obj.popCharacter() != obj.dequeueCharacter():
        isPalindrome = False
        break
# finally print whether string s is palindrome or not.
if isPalindrome:
    print("The word, " + s + ", is a palindrome.")
else:
    print("The word, " + s + ", is not a palindrome.")
