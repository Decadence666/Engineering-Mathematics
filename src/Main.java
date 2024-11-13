import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Operations calc = new Operations();
        //let A[2,3] B[3,4] -> C[2,4]
        int[][] A = {{1, 2, 3}, {3, 4, 5}};
        int[][] B = {{1, 0, 2, 5}, {6, 7, 2, 8}, {2, 2, 1, 9}};
        System.out.println(Arrays.deepToString(calc.matrixMult(A, B)));
    }
}