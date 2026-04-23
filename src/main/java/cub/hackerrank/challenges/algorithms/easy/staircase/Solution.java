package cub.hackerrank.challenges.algorithms.easy.staircase;

import java.util.*;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }

        for (int i = 1; i <= n; i++) {
            sb.setCharAt(n - i, '#');
            System.out.println(sb.toString());
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
