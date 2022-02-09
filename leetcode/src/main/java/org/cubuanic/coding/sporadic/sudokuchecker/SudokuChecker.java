package org.cubuanic.coding.sporadic.sudokuchecker;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SudokuChecker {
    private static final String newLine = System.getProperty("line.separator");

    // RULES
    // От игрока требуется заполнить свободные клетки цифрами от 1 до 9 так,
    // чтобы в каждой строке, в каждом столбце и в каждом малом квадрате 3×3
    // каждая цифра встречалась бы только один раз.

    // correct
    private static final String inputData1 = String.join(newLine, "",
        "1 2 4 | 5 6 7 | 8 9 3",
        "3 7 8 | 2 9 4 | 5 1 6",
        "6 5 9 | 8 3 1 | 7 4 2",
        "------+-------+------",
        "9 8 7 | 1 2 3 | 4 6 5",
        "2 3 1 | 4 5 6 | 9 7 8",
        "5 4 6 | 7 8 9 | 3 2 1",
        "------+-------+------",
        "8 6 3 | 9 7 2 | 1 5 4",
        "4 9 5 | 6 1 8 | 2 3 7",
        "7 1 2 | 3 4 5 | 6 8 9"
    );

    // correct
    private static final String inputData2 = String.join(newLine, "",
        "1 2 3 | 4 5 6 | 7 8 9",
        "4 5 6 | 7 8 9 | 1 2 3",
        "7 8 9 | 1 2 3 | 4 5 6",
        "------+-------+------",
        "2 1 4 | 3 6 5 | 8 9 7",
        "3 6 5 | 8 9 7 | 2 1 4",
        "8 9 7 | 2 1 4 | 3 6 5",
        "------+-------+------",
        "5 3 1 | 6 4 2 | 9 7 8",
        "6 4 2 | 9 7 8 | 5 3 1",
        "9 7 8 | 5 3 1 | 6 4 2"
    );

    // wrong
    private static final String inputData3 = String.join(newLine, "",
        "1 2 6 | 4 5 6 | 7 8 9",
        "4 5 3 | 7 8 9 | 1 2 3",
        "7 8 9 | 1 2 3 | 4 5 6",
        "------+-------+------",
        "2 1 4 | 3 6 5 | 8 9 7",
        "3 6 5 | 8 9 7 | 2 1 4",
        "8 9 7 | 2 1 4 | 3 6 5",
        "------+-------+------",
        "5 3 1 | 6 4 2 | 9 7 8",
        "6 4 2 | 9 7 8 | 5 3 1",
        "9 7 8 | 5 3 1 | 6 4 2"
    );

    public static void main(String[] args) {
        List<Integer> field = readInputData(inputData1);

        if (checkSmallBoxes(field)
            && checkLines(field)
            // && checkDiags(field)     // uncomment for super-sudoku
        ) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }
    }

    private static List<Integer> readInputData(String inputData) {
        List<Integer> field = new ArrayList<>(9 * 9);

//        Scanner sc= new Scanner(System.in);
        Scanner sc = new Scanner(new ByteArrayInputStream(inputData.getBytes()));

        while (field.size() < 9 * 9) {
            char c = sc.next().charAt(0);
            if (Character.isDigit(c)) {
                field.add(Character.getNumericValue(c));
            }
        }

        return field;
    }

    private static boolean checkSmallBoxes(List<Integer> field) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                List<Integer> smallBox = getSmallBox(field, i, j);
                if (!baseCheck(smallBox)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkLines(List<Integer> field) {
        for (int i = 1; i <= 9; i++) {
            List<Integer> row = getRow(field, i);
            List<Integer> column = getColumn(field, i);
            if (!baseCheck(row) || !baseCheck(column)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiags(List<Integer> field) {
        List<Integer> diag1 = getDiag1(field);
        List<Integer> diag2 = getDiag2(field);

        return baseCheck(diag1) && baseCheck(diag2);
    }

    private static List<Integer> getSmallBox(List<Integer> field, int i, int j) {
        return List.of(
            getValue(field, (i - 1) * 3 + 1, (j - 1) * 3 + 1),
            getValue(field, (i - 1) * 3 + 1, (j - 1) * 3 + 2),
            getValue(field, (i - 1) * 3 + 1, (j - 1) * 3 + 3),
            getValue(field, (i - 1) * 3 + 2, (j - 1) * 3 + 1),
            getValue(field, (i - 1) * 3 + 2, (j - 1) * 3 + 2),
            getValue(field, (i - 1) * 3 + 2, (j - 1) * 3 + 3),
            getValue(field, (i - 1) * 3 + 3, (j - 1) * 3 + 1),
            getValue(field, (i - 1) * 3 + 3, (j - 1) * 3 + 2),
            getValue(field, (i - 1) * 3 + 3, (j - 1) * 3 + 3)
        );
    }

    private static List<Integer> getRow(List<Integer> field, int i) {
        List<Integer> row = new ArrayList<>(9);
        for (int j = 1; j <= 9; j++) {
            row.add(getValue(field, i, j));
        }
        return row;
    }

    private static List<Integer> getColumn(List<Integer> field, int i) {
        List<Integer> column = new ArrayList<>(9);
        for (int j = 1; j <= 9; j++) {
            column.add(getValue(field, j, i));
        }
        return column;
    }

    private static List<Integer> getDiag1(List<Integer> field) {
        List<Integer> diag = new ArrayList<>(9);
        for (int i = 1; i <= 9; i++) {
            diag.add(getValue(field, i, i));
        }
        return diag;
    }

    private static List<Integer> getDiag2(List<Integer> field) {
        List<Integer> diag = new ArrayList<>(9);
        for (int i = 1; i <= 9; i++) {
            diag.add(getValue(field, i, 10 - i));
        }
        return diag;
    }

    private static int getValue(List<Integer> field, int x, int y) {
        return field.get((x - 1) * 9 + y - 1);
    }

    private static boolean baseCheck(List<Integer> box) {
        return new HashSet<>(box).size() == 9;
    }
}
