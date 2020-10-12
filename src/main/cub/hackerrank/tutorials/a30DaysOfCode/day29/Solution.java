package cub.hackerrank.tutorials.a30DaysOfCode.day29;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            int a = k - 1;
            int b = 0;
            for (; a > 0; a--) {
                int lowestZero = 0;
                int tmp = a;
                while (tmp > 0 && (tmp & 1) == 1) {
                    tmp >>= 1;
                    lowestZero++;
                }
                b = a + (1 << lowestZero);
                if (b <= n) {
                    break;
                }
            }
            System.out.println(a & b);
        }

        scanner.close();
    }
}
