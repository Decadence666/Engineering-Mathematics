import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoolMatrix b1 = new BoolMatrix(3,5,"b1");b1.createMatrix();
        BoolMatrix b2 = new BoolMatrix(3,5,"b2");b2.createMatrix();
        BoolMatrix b3 = new BoolMatrix(5,7,"b3");b3.createMatrix();
        b1.matrixT();
        b1.AND(b2);
        b1.OR(b2);
        b1.multiply(b3);
        sc.close();
    }
}