import java.util.List;
import java.util.Random;

public class SquareMatrix extends DenseMatrix {
    // Constructor to ensure the matrix is square
    public SquareMatrix(double[][] elements, String name) {
        super(elements, name);
        if (elements.length != elements[0].length) {
            throw new IllegalArgumentException("Square matrix must have equal number of rows and columns.");
        }
    }

    public static SquareMatrix randomMatrix(String name, int dimension, double min, double max) {
        Random random = new Random();
        double[][] randomElements = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                randomElements[i][j] = min + (max - min) * random.nextDouble();// Generates random integers between "min" and "max"
            }
        }
        return new SquareMatrix(randomElements, name);
    }

    //not working right now, need cofactor and minor method first
    public SquareMatrix inverse() {
        if (determinant() == 0) {
            throw new ArithmeticException("Matrix is singular and cannot be inverted.");
        }
        IdentityMatrix I = IdentityMatrix.identityMatrix("I", this.row);
        double[][] res = new double[this.row][this.row];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.row; j++) {
                res[i][j] = adjugate().elements[i][j]/determinant();
            }
        }
        return new SquareMatrix(res, name);
    }

    @Override
    public double determinant() {
        int sgn = 1;
        double res = 0;
        List<int[]> permutations = BasicOperations.generatePermutations(this.row);
        for (int[] permutation : permutations) {
            double temp = 1;
            for (int j = 0; j < this.row; j++) {
                temp *= elements[j][permutation[j]];
            }
            res += sgn * temp;
            sgn *= -1;
        }
        return res;
    }

    public SquareMatrix minor(int i, int j) {
        int r = 0, c;
        double[][] res = new double[this.row - 1][this.row - 1];

        for (int a = 0; a < this.row; a++) {
            if (a == i)
                continue;
            c = 0;
            for (int b = 0; b < this.row; b++) {
                if (b == j)
                    continue;
                res[r][c] = this.elements[a][b];
                c++;
            }
            r++;
        }
        return new SquareMatrix(res, "Minor " + this.row + "," + this.col + " of " + this.name);
    }

    public SquareMatrix cofactor(){
        double[][] res = new double[this.row][this.row];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.row; j++) {
                double sgn = ((i + j) % 2 == 0) ? 1 : -1;
                res[i][j] = minor(i,j).determinant() * sgn;
            }
        }
        return new SquareMatrix(res, "C(" + this.name + ")");
    }

    public SquareMatrix adjugate(){
        return new SquareMatrix(cofactor().transpose().elements, "adj(" + this.name + ")") ;
    }
}

class IdentityMatrix extends SquareMatrix {
    public IdentityMatrix(double[][] elements, String name) {
        super(elements, name);
        if (elements.length != elements[0].length) {
            throw new IllegalArgumentException("Square matrix must have equal number of rows and columns.");
        }
    }

    public static IdentityMatrix identityMatrix(String name, int dimension) {
        double[][] id = new double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == j) {
                    id[i][j] = 1;
                } else {
                    id[i][j] = 0;
                }
            }
        }
        return new IdentityMatrix(id, name);
    }

    @Override
    public void print() {
        System.out.println(this.name + ":");
        double[][] data = getElements();
        for (double[] row : data) {
            for (double value : row) {
                System.out.printf("%.0f ", value);
            }
            System.out.println();
        }
    }
}