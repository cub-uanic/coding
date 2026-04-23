#!/usr/bin/env python3

class Difference:
    def __init__(self, a):
        self.__elements = a
        self.maximumDifference = None

    # Add your code here
    def computeDifference(self):
        x = sorted(self.__elements)
        self.maximumDifference = x[-1] - x[0]


# End of Difference class

_ = input()
a = [int(e) for e in input().split(' ')]

d = Difference(a)
d.computeDifference()

print(d.maximumDifference)
