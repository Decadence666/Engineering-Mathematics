import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoolMatrix b1 = BoolMatrix.randomMatrix("B1", 3, 5);
        BoolMatrix b2 = BoolMatrix.randomMatrix("B2", 3, 5);
        BoolMatrix b3 = BoolMatrix.randomMatrix("B3", 5, 7);
        b1.print();
        b2.print();
        sc.close();
    }
}