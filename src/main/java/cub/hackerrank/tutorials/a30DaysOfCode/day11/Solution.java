package cub.hackerrank.tutorials.a30DaysOfCode.day11;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHourglassSum = Integer.MIN_VALUE;
        for (int x = 1; x < 5; x++) {
            for (int y = 1; y < 5; y++) {
                int currHourglassSum =
                        arr[x - 1][y - 1] + arr[x - 1][y] + arr[x - 1][y + 1] +
                        arr[x][y] +
                        arr[x + 1][y - 1] + arr[x + 1][y] + arr[x + 1][y + 1];
                if (currHourglassSum > maxHourglassSum) {
                    maxHourglassSum = currHourglassSum;
                }
            }
        }
        return maxHourglassSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
