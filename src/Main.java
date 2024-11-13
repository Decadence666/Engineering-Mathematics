import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Operations calc = new Operations();
        int[][] A = calc.randomMatrice(sc, 'A');
        int[][] B = calc.randomMatrice(sc, 'B');
        int[][] C = calc.randomMatrice(sc, 'C');
        int[][] AxB = calc.matrixMult(A, B);
        System.out.println(Arrays.deepToString(calc.matrixMult(AxB, C)));
    }
}