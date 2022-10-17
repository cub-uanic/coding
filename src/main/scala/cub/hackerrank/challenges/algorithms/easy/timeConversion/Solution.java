package cub.hackerrank.challenges.algorithms.easy.timeConversion;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        final Matcher matcher = Pattern
            .compile("^(..)(.*)(..)$")
            .matcher(s.toUpperCase());
        matcher.find();
        int h = Integer.parseInt(matcher.group(1));
        String rest = matcher.group(2);
        String ampm = matcher.group(3);

        if (ampm.equals("AM")) {
            if (h == 12) {
                h = 0;
            }
        } else {
            if (h < 12) {
                h += 12;
            }
        }
        return String.format("%02d%s", h, rest);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scan.nextLine();
        String result = timeConversion(s);
        bw.write(result);
        bw.newLine();
        bw.close();
    }
}
