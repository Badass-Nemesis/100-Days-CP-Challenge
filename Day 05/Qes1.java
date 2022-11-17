// Question -> https://leetcode.com/problems/island-perimeter/

// import java.util.*;

public class Qes1 {

    public static int perimeter;

    public static void checkingWater(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) {
            perimeter++;
            return;
        }

        if (grid[row][column] > 1) {
            return;
        }

        grid[row][column] = 2;

        checkingWater(grid, row + 1, column);
        checkingWater(grid, row - 1, column);
        checkingWater(grid, row, column + 1);
        checkingWater(grid, row, column - 1);
    }

    public int islandPerimeter(int[][] grid) {

        perimeter = 0;
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    checkingWater(grid, i, j);
                    break;
                }
            }
        }

        return perimeter;
    }
}
