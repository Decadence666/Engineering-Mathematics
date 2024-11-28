import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix b1 = new Matrix(3, 3, "b1");
        b1.createBoolean();
        Matrix b2 = new Matrix(3, 3, "b2");
        b2.createBoolean();
        b1.AND(b2);
        sc.close();
    }
}