package cub.hackerrank.tutorials.a30DaysOfCode.day28;

import java.util.Arrays;
import java.util.LinkedHashSet;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static class Row {
        final String firstName;
        final String emailID;

        public Row(String firstName, String emailID) {
            this.firstName = firstName;
            this.emailID = emailID;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getEmailID() {
            return emailID;
        }
    }

    static List<Row> db = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");
            db.add(new Row(firstNameEmailID[0], firstNameEmailID[1]));
        }

        scanner.close();

        db.stream()
            .filter(row -> row.getEmailID().matches("^.*@gmail.com$"))
            .map(Row::getFirstName)
            .sorted()
            .forEach(System.out::println);
    }
}

