public class SquareMatrix extends DenseMatrix {
    // Constructor to ensure the matrix is square
    public SquareMatrix(double[][] elements, String name) {
        super(elements, name);
        if (elements.length != elements[0].length) {
            throw new IllegalArgumentException("Square matrix must have equal number of rows and columns.");
        }
    }
}
