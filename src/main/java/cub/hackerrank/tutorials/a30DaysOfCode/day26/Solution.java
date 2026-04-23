package cub.hackerrank.tutorials.a30DaysOfCode.day26;

import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

        int da = scanner.nextInt();
        int ma = scanner.nextInt();
        int ya = scanner.nextInt();
        int de = scanner.nextInt();
        int me = scanner.nextInt();
        int ye = scanner.nextInt();

        if (ya < ye || (ya == ye && ma < me) || (ya == ye && ma == me && da <= de)) {
            System.out.println(0);
        } else if (ya > ye) {
            System.out.println("10000");
        } else if (ma > me) {
            System.out.println(500 * (ma - me));
        } else if (da > de) {
            System.out.println(15 * (da - de));
        }
    }
}
