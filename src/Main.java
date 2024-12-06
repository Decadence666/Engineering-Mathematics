import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] squareMatrix = {{2,8,3},{9,12,5},{7,6,4}};
        SquareMatrix sq1 = new SquareMatrix(squareMatrix, "S1");
        sq1.inverse().print();
        sc.close();
    }
}