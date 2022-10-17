#!/usr/bin/env python3

import math
import os
import random
import re
import sys


class Row:
    def __init__(self, firstName, emailID):
        self.firstName = firstName
        self.emailID = emailID


if __name__ == '__main__':
    db = list()
    N = int(input())
    for N_itr in range(N):
        firstNameEmailID = input().split()
        firstName = firstNameEmailID[0]
        emailID = firstNameEmailID[1]
        db.append(Row(firstName, emailID))

    gmail_regexp = re.compile('^.*@gmail.com$')
    for firstName in sorted(map(lambda row: row.firstName, filter(lambda row: gmail_regexp.match(row.emailID), db))):
        print(firstName)
