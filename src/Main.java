import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operations calc = new Operations();
        int[][] sumA = calc.randomMatrix(2, 4, "A");
        calc.printM(calc.matrixT(sumA), "A^t");
        sumA = calc.randomMatrix(5, 5, "A");
        int[][] sumB = calc.randomMatrix(5, 5, "B");
        calc.printM(calc.matrixSum(sumA, sumB), "A+B");
        int[][] A = calc.randomMatrix(20, 30, "A");
        int[][] B = calc.randomMatrix(30, 40, "B");
        int[][] C = calc.randomMatrix(40, 10, "C");
        calc.printM(calc.matrixMult(calc.matrixMult(A, B), C), "AxBxC");
        boolean[][] boolA = calc.randomBoolMat(2, 2, "x");
        boolean[][] boolB = calc.randomBoolMat(2, 2, "y");
        calc.printBoolM(calc.matrixBoolMult(boolA, boolB), "xꙨy");
        sc.close();
    }
}