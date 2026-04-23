package cub.hackerrank.tutorials.a30DaysOfCode.day10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        int result = 0;
        int curr = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                curr += 1;
                if (curr > result) {
                    result = curr;
                }
            } else {
                curr = 0;
            }
            n >>>= 1;
        }
        System.out.println(result);
    }
}
