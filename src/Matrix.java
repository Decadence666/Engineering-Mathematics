import java.util.Random;

public class Matrix extends MathOperations {
    public int[][] elements;
    public int row, col;

    public Matrix(int row, int col, String name) {
        super(name, row * col);
        this.row = row;
        this.col = col;
        elements = new int[row][col];
    }

    public void createDense() {
        Random random = new Random();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                elements[i][j] = random.nextInt(10); // Generates random integers between 0 and 10
            }
        }

        // Print the matrix
        print();
    }

    public void createBoolean() {
        Random random = new Random();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                elements[i][j] = boolToByte(random.nextBoolean()); // Generates random booleans
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

    @Override
    public Matrix AND(MathOperations other) {
        Matrix a = (Matrix) other;
        Matrix res = new Matrix(this.row, this.col, "(" + this.getName() + " v " + a.getName() + ")");
        if (this.row != a.row || this.col != a.col) {
            throw new IllegalArgumentException("Matrix dimensions are incompatible for AND");
        }
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res.elements[i][j] = (this.elements[i][j] + a.elements[i][j])/2;
            }
        }
        res.print();
        return res;
    }
/*
    public boolean[][] matrixOR(boolean[][] a, boolean[][] b) {
        boolean[][] res = new boolean[a.length][a[0].length];
        if (a.length != b.length || a[0].length != b[0].length) {
            return null;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] || b[i][j];
            }
        }
        return res;
    }

    public boolean[][] matrixBoolMult(boolean[][] a, boolean[][] b) {
        boolean[][] res = new boolean[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                res[i][j] = false;
                for (int k = 0; k < a[0].length; k++) {
                    res[i][j] |= (a[i][k] && b[k][j]);
                }
            }
        }
        return res;
    }*/

    /*
        //transpose of a regular matrix:
        public int[][] matrixT(int[][] a) {
            int[][] res = new int[a[0].length][a.length];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    res[j][i] = a[i][j];
                }
            }
            return res;
        }

        public int userRow(Scanner sc) {
            System.out.println("Enter how many rows you want:");
            return sc.nextInt();
        }

        public int userCol(Scanner sc) {
            System.out.println("Enter how many rows you want:");
            return sc.nextInt();
        }

        public boolean[][] randomBoolMat(int row, int col, String name) {
            boolean[][] matrix = new boolean[row][col];
            Random random = new Random();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = random.nextBoolean(); // Generates random bool
                }
            }

            // Print the matrix
            printBoolM(matrix, name);
            return matrix;
        }*/
    private byte boolToByte(boolean bool) {
        return (byte) (bool ? 1 : 0);
    }
}