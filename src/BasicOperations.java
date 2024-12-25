import java.util.ArrayList;
import java.util.List;

public class BasicOperations {
    public static List<int[]> generatePermutations(int n) {
        List<int[]> permutations = new ArrayList<>();
        permute(permutations, new int[n], 0);
        return permutations;
    }

    private static void permute(List<int[]> permutations, int[] current, int index) {
        if (index == current.length) {
            permutations.add(current.clone());
            return;
        }

        for (int i = 0; i < current.length; i++) {
            boolean found = false;
            for (int j = 0; j < index; j++) {
                if (current[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                current[index] = i;
                permute(permutations, current, index + 1);
            }
        }
    }

    public static int power(int a, int n){
        int res = 1;
        while(n>0){
            res *= a;
            n--;
        }
        return res;
    }
    public static double power(double a, double n){
        double res = 1;
        while(n>0){
            res *= a;
            n--;
        }
        return res;
    }
}
