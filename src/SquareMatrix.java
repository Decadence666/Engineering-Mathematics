import java.util.Random;

public class SquareMatrix extends DenseMatrix {
    // Constructor to ensure the matrix is square
    public SquareMatrix(double[][] elements, String name) {
        super(elements, name);
        if (elements.length != elements[0].length) {
            throw new IllegalArgumentException("Square matrix must have equal number of rows and columns.");
        }
    }

    public static SquareMatrix randomMatrix(String name, int dimension, double min, double max){
        Random random = new Random();
        double[][] randomElements = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                randomElements[i][j] = min + (max - min) * random.nextDouble();// Generates random integers between "min" and "max"
            }
        }
        return new SquareMatrix(randomElements, name);
    }
}
