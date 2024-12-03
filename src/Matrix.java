import java.util.Random;

public class Matrix extends MathOperations {
    public int[][] elements;
    public int row, col;

    public Matrix(int row, int col, String name) {
        super(name, row * col);
        this.row = row;
        this.col = col;
        elements = new int[row][col];
        createMatrix();
    }

    public void createMatrix() {
        Random random = new Random();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                elements[i][j] = random.nextInt(10); // Generates random integers between 0 and 10
            }
        }

        // Print the matrix
        print();
    }

    @Override
    public Matrix add(MathOperations other) {
        Matrix a = (Matrix) other;
        Matrix res = new Matrix(row, col, "(" + this.getName() + " + " + a.getName() + ")");
        if (row != a.row || col != a.col) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for addition");
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                res.elements[i][j] = elements[i][j] + a.elements[i][j];
            }
        }
        res.print();
        return res;
    }

    @Override
    public Matrix multiply(MathOperations other) {
        Matrix a = (Matrix) other;
        if (this.col != a.row) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for multiplication");
        }
        Matrix res = new Matrix(this.row, a.col, "(" + this.getName() + " * " + a.getName() + ")");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < a.col; j++) {
                res.elements[i][j] = 0;
                for (int k = 0; k < this.col; k++) {
                    res.elements[i][j] += this.elements[i][k] * a.elements[k][j];
                }
            }
        }
        res.print();
        return res;
    }

    @Override
    public void print() {
        System.out.println(super.getName() + ":");
        for (int[] integers : elements) {
            for (int j = 0; j < elements[0].length; j++) {
                System.out.print(((integers[j])) + " ");
            }
            System.out.println();
        }
    }

    //transpose of a regular matrix:
    public Matrix matrixT() {
        Matrix res = new Matrix(this.col, this.row, this.getName() + "^T");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res.elements[j][i] = elements[i][j];
            }
        }
        return res;
    }

    private byte boolToByte(boolean bool) {
        return (byte) (bool ? 1 : 0);
    }
}