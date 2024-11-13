import java.util.Random;
import java.util.Scanner;

public class Operations {
    public int[][] matrixMult(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                //res[i][j] = 0;
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    public int[][] randomMatrice(Scanner sc, char name) {
        System.out.println("Enter how many rows you want:");
        int x = sc.nextInt();
        System.out.println("Enter how many columns you want:");
        int y = sc.nextInt();
        int[][] matrice = new int[x][y];
        Random random = new Random();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrice[i][j] = random.nextInt(10); // Generates random integers between 0 and 99
            }
        }

        // Print the matrice
        System.out.println("Matrice " + name + ":");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        return matrice;
    }
}
