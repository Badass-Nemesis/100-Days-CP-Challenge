// Question - https://leetcode.com/problems/excel-sheet-column-title/description/

import java.util.*;

public class Qes2 {
    public static String columnWalaName;

    public static void dumbRecursion(int columnNumber) {
        if (columnNumber < 1) {
            return;
        }
        int remainder = columnNumber % 26;
        if (remainder == 0) {
            columnWalaName = "Z" + columnWalaName;
        } else {
            System.out.println(remainder);
            columnWalaName = (char) ('A' + remainder - 1) + columnWalaName;
        }

        dumbRecursion(columnNumber / 26);
    }

    public static String convertToTitle(int columnNumber) {
        columnWalaName = "";
        dumbRecursion(columnNumber);
        return columnWalaName;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int columnNumber = scn.nextInt();
        System.out.println(convertToTitle(columnNumber));
        scn.close();
    }
}
