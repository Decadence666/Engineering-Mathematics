abstract class Matrix implements MathOperations {
    protected double[][] elements;
    protected int row, col;
    protected String name;
    public Matrix(int row, int col, String name) {
        this.row = row;
        this.col = col;
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(this.name + ":");
        double[][] data = this.elements;
        for(double[] row : data){
            for(double value : row){
                System.out.println(value + " ");
            }
            System.out.println();
        }
    }

    protected void checkDimensionsForAdd(Matrix other) {
        if (this.row != other.row || this.col != other.col) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition.");
        }
    }

    protected void checkDimensionsForMultiply(Matrix other) {
        if (this.col != other.row) {
            throw new IllegalArgumentException("Matrix dimensions must be compatible for multiplication.");
        }
    }
}