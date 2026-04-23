package cub.hackerrank.tutorials.a30DaysOfCode.day09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> pb = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            Integer phone = in.nextInt();
            pb.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.next();
            System.out.println(pb.containsKey(s)
                ? s + "=" + pb.get(s).toString()
                : "Not found"
            );
        }
        in.close();
    }
}
