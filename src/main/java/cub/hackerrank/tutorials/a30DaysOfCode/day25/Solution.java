package cub.hackerrank.tutorials.a30DaysOfCode.day25;

import java.util.*;

class Solution {
    public static void main(String args[]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int idx = T;
        while (idx-- > 0) {
            int ele = sc.nextInt();

            boolean isPrime = (ele !=1 && ele % 2 != 0) || ele == 2;
            int j = 3;
            while (isPrime && j < Math.sqrt(ele) + 1) {
                isPrime = ele % j != 0;
                j += 2;
            }

            if (isPrime) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }
}
