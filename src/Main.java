import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix m1 = new Matrix(2,3,"m1");
        m1.createElements();
        Matrix m2 = new Matrix(3,4,"m2");
        m2.createElements();
        m1.multiply(m2);


        sc.close();
    }
}