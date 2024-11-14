import java.util.Random;
import java.util.Scanner;

public class Operations {
    public void printM(int[][] a, String name) {
        System.out.println("Matrix " + name + ":");
        for (int[] integers : a) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(integers[j] + " ");
            }
            System.out.println();
        }
    }

    public void printBoolM(boolean[][] a, String name) {
        System.out.println("Boolean Matrix " + name + ":");
        for (boolean[] booleans : a) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(booleans[j] + " ");
            }
            System.out.println();
        }
    }

    public boolean[][] matrixAND(boolean[][] a, boolean[][] b) {
        boolean[][] res = new boolean[a.length][a[0].length];
        if (a.length != b.length || a[0].length != b[0].length) {
            return null;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] && b[i][j];
            }
        }
        return res;
    }

    public boolean[][] matrixOR(boolean[][] a, boolean[][] b) {
        boolean[][] res = new boolean[a.length][a[0].length];
        if (a.length != b.length || a[0].length != b[0].length) {
            return null;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] || b[i][j];
            }
        }
        return res;
    }

    public boolean[][] matrixBoolMult(boolean[][] a, boolean[][] b) {
        boolean[][] res = new boolean[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                res[i][j] = false;
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] |= (a[i][k] && b[k][j]);
                }
            }
        }
        return res;
    }

    public int[][] matrixSum(int[][] a, int[][] b) {
        int[][] res = new int[a.length][a[0].length];
        if (a.length != b.length || a[0].length != b[0].length) {
            return null;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] + b[i][j];
            }
        }
        return res;
    }

    public int[][] matrixMult(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    //transpose of a regular matrix:
    public int[][] matrixT(int[][] a) {
        int[][] res = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[j][i] = a[i][j];
            }
        }
        return res;
    }

    public int userRow(Scanner sc) {
        System.out.println("Enter how many rows you want:");
        return sc.nextInt();
    }

    public int userCol(Scanner sc) {
        System.out.println("Enter how many rows you want:");
        return sc.nextInt();
    }

    public int[][] randomMatrix(int row, int col, String name) {
        int[][] matrix = new int[row][col];
        Random random = new Random();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = random.nextInt(10); // Generates random integers between 0 and 10
            }
        }

        // Print the matrice
        printM(matrix, name);
        return matrix;
    }

    public boolean[][] randomBoolMat(int row, int col, String name) {
        boolean[][] matrix = new boolean[row][col];
        Random random = new Random();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = random.nextBoolean(); // Generates random bool
            }
        }

        // Print the matrix
        printBoolM(matrix, name);
        return matrix;
    }
}