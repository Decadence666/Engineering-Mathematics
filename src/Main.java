import java.util.Scanner;

public class Main {

    public Main(){
        new GUI().menu();
    }
    public static void main(String[] args) {
        new Main();
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
}