import java.util.Random;

public class BoolMatrix extends Matrix {
    private final boolean[][] elements;

    public BoolMatrix(boolean[][] elements, String name) {
        super(elements.length, elements[0].length, name);
        this.elements = elements;
    }

    public boolean[][] getElements() {
        return elements;
    }

    public static BoolMatrix randomMatrix(String name, int row, int col) {
        Random random = new Random();
        boolean[][] randomElements = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                randomElements[i][j] = random.nextBoolean(); // Generates random booleans
            }
        }
        return new BoolMatrix(randomElements, name);
    }

    //OR
    @Override
    public BoolMatrix add(MathOperations other) {
        if(!(other instanceof BoolMatrix)){
            throw new IllegalArgumentException("Expected a boolean matrix instance.");
        }
        BoolMatrix a = (BoolMatrix) other;
        checkDimensionsForAdd(a);
        boolean[][] res = new boolean[row][col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res[i][j] = this.elements[i][j] || a.elements[i][j];
            }
        }
        return new BoolMatrix(res, "(" + this.name + " v " + a.name + ")");
    }

    @Override
    public BoolMatrix multiply(MathOperations other) {
        if(!(other instanceof BoolMatrix)){
            throw new IllegalArgumentException("Expected a boolean matrix instance.");
        }
        BoolMatrix a = (BoolMatrix) other;
        checkDimensionsForAdd(a);
        boolean[][] res = new boolean[row][col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res[i][j] = this.elements[i][j] && a.elements[i][j];
            }
        }
        return new BoolMatrix(res, "(" + this.name + " ∧ " + a.name + ")");
    }

    //Boolean Multiplication
    public BoolMatrix boolMultiply(MathOperations other) {
        if(!(other instanceof BoolMatrix)){
            throw new IllegalArgumentException("Expected a boolean matrix instance.");
        }
        BoolMatrix a = (BoolMatrix) other;
        checkDimensionsForMultiply(a);
        boolean[][] res = new boolean[this.row][a.col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < a.col; j++) {
                res[i][j] = false;
                for (int k = 0; k < this.col; k++) {
                    res[i][j] |= (this.elements[i][k] && a.elements[k][j]);
                }
            }
        }
        return new BoolMatrix(res, "(" + this.name + " Ꙩ " + a.name + ")");
    }

    public BoolMatrix NOT() {
        boolean[][] res = new boolean[this.row][this.col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = !this.elements[i][j];
            }
        }
        return new BoolMatrix(res, "¬" + this.name);
    }

    public BoolMatrix matrixT() {
        boolean[][] res = new boolean[this.col][this.row];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                res[j][i] = elements[i][j];
            }
        }
        return new BoolMatrix(res, name + "^T");
    }

    @Override
    public void print() {
        System.out.println(this.name + ":");
        for(boolean[] row : elements){
            for(boolean value : row){
                System.out.print(boolToByte(value) + " ");
            }
            System.out.println();
        }
    }

    private byte boolToByte(boolean bool) {
        return (byte) (bool ? 1 : 0);
    }
}
