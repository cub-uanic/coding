#!/bin/python3

import os
import sys


#
# Complete the timeConversion function below.
#
def timeConversion(s):
    time12 = s.upper()
    (h, rest, ampm) = (int(time12[0:2]), time12[2:-2], time12[-2:])
    if ampm == "AM":
        return "%02d%s" % (0 if h == 12 else h, rest)
    else:
        return "%02d%s" % (12 if h == 12 else h + 12, rest)


#
# Write your code here.
#

if __name__ == '__main__':
    f = open(os.environ['OUTPUT_PATH'], 'w')
    s = input()
    result = timeConversion(s)
    f.write(result + '\n')
    f.close()
