package cub.hackerrank.challenges.algorithms.easy.plusMinus;

import java.util.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int n = 0, z = 0, p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                n++;
            } else if (arr[i] == 0) {
                z++;
            } else {
                p++;
            }
        }
        System.out.printf("%.6f\n", (double)p/arr.length);
        System.out.printf("%.6f\n", (double)n/arr.length);
        System.out.printf("%.6f\n", (double)z/arr.length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
