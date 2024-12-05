import java.util.Random;

public class DenseMatrix extends Matrix {
    private double[][] elements;

    public DenseMatrix(double[][] elements, String name) {
        super(elements.length, elements[0].length, name);
        this.elements = elements;
    }

    public double[][] getElements() {
        return elements;
    }

    public static DenseMatrix randomMatrix(String name, int row, int col, double min, double max) {
        Random random = new Random();
        double[][] randomElements = new double[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                randomElements[i][j] = min + (max - min) * random.nextDouble();// Generates random integers between "min" and "max"
            }
        }
        return new DenseMatrix(randomElements, name);
    }

    @Override
    public DenseMatrix add(MathOperations other) {
        if (!(other instanceof Matrix)) {
            throw new IllegalArgumentException("Expected a Matrix instance.");
        }
        DenseMatrix a = (DenseMatrix) other;
        checkDimensionsForAdd(a);
        double[][] res = new double[row][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                res[i][j] = this.elements[i][j] + a.elements[i][j];
            }
        }
        return new DenseMatrix(res, "(" + this.name + "+" + a.name + ")");
    }

    @Override
    public DenseMatrix multiply(MathOperations other) {
        if (!(other instanceof DenseMatrix)) {
            throw new IllegalArgumentException("Expected a Matrix instance.");
        }
        DenseMatrix a = (DenseMatrix) other;
        checkDimensionsForMultiply(a);
        double[][] res = new double[this.row][a.col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < a.col; j++) {
                res[i][j] = 0;
                for (int k = 0; k < this.col; k++) {
                    res[i][j] += this.elements[i][k] * a.elements[k][j];
                }
            }
        }
        return new DenseMatrix(res, "(" + super.name + "*" + a.name + ")");
    }

    //transpose of a regular matrix:
    public DenseMatrix matrixT() {
        double[][] res = new double[row][col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res[j][i] = elements[i][j];
            }
        }
        return new DenseMatrix(res, super.name + "^T");
    }
}