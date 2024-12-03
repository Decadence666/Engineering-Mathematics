import java.util.Random;

public class BoolMatrix extends MathOperations {
    public boolean[][] elements;
    public int row, col;

    public BoolMatrix(int row, int col, String name) {
        super(name, row * col);
        this.row = row;
        this.col = col;
        elements = new boolean[row][col];
    }

    public void createMatrix() {
        Random random = new Random();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                elements[i][j] = random.nextBoolean(); // Generates random booleans
            }
        }

        // Print the matrix
        print();
    }

    public BoolMatrix add(MathOperations other) {
        BoolMatrix a = (BoolMatrix) other;
        return OR(a);
    }

    //OR
    public BoolMatrix OR(BoolMatrix a) {
        if (this.row != a.row || this.col != a.col) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for OR");
        }
        BoolMatrix res = new BoolMatrix(this.row, this.col, "(" + this.getName() + " v " + a.getName() + ")");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res.elements[i][j] = this.elements[i][j] || a.elements[i][j];
            }
        }
        res.print();
        return res;
    }

    public BoolMatrix AND(BoolMatrix a) {
        if (this.row != a.row || this.col != a.col) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for AND");
        }
        BoolMatrix res = new BoolMatrix(this.row, this.col, "(" + this.getName() + " ∧ " + a.getName() + ")");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res.elements[i][j] = this.elements[i][j] && a.elements[i][j];
            }
        }
        res.print();
        return res;
    }

    //Boolean Multiplication
    @Override
    public BoolMatrix multiply(MathOperations other) {
        BoolMatrix a = (BoolMatrix) other;
        if (this.col != a.row) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for multiplication");
        }
        BoolMatrix res = new BoolMatrix(this.row, a.col, "(" + this.getName() + " symbol " + a.getName() + ")");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < a.col; j++) {
                res.elements[i][j] = false;
                for (int k = 0; k < this.col; k++) {
                    res.elements[i][j] |= (this.elements[i][k] && a.elements[k][j]);
                }
            }
        }
        res.print();
        return res;
    }

    public BoolMatrix matrixT() {
        BoolMatrix res = new BoolMatrix(this.col, this.row, this.getName() + "^T");
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res.elements[j][i] = elements[i][j];
            }
        }
        res.print();
        return res;
    }

    @Override
    public void print() {
        System.out.println(super.getName() + ":");
        for (boolean[] integers : elements) {
            for (int j = 0; j < elements[0].length; j++) {
                System.out.print(boolToByte(integers[j]) + " ");
            }
            System.out.println();
        }
    }

    private byte boolToByte(boolean bool) {
        return (byte) (bool ? 1 : 0);
    }
}
