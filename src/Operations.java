public class Operations {
    public int[][] matrixMult(int[][] a, int[][] b) {
        int[][] res = new int[2][4];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                //res[i][j] = 0;
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }
}
