// Question -> https://codeforces.com/problemset/problem/1699/B

import java.util.*;

public class Qes2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int test_cases = scn.nextInt();

        for (int i = 0; i < test_cases; i++) {
            int rows = scn.nextInt();
            int column = scn.nextInt();

            String original = "1 0 ";
            String mirror = "0 1 ";

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < column / 2; k++) {
                    // ye if block ka matlab hua ki first row aur fourth row, dono same rahega
                    // aur second row and third row same rahega. because of mirroring
                    if (j % 4 == 0) {
                        if (k % 2 == 0) {
                            System.out.print(original);
                        } else {
                            System.out.print(mirror);
                        }
                    } else {
                        if (k % 2 == 0) {
                            System.out.print(mirror);
                        } else {
                            System.out.print(original);
                        }
                    }
                }
                System.out.println();
            }

        }

        scn.close();
    }
}
