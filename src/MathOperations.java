public abstract class MathOperations {
    private final String name;
    private final int dimension;
    public MathOperations(String name, int dimension) {
        this.name = name;
        this.dimension = dimension;
    }
    public String getName() {
        return name;
    }
    public int getDimension() {
        return dimension;
    }
    public abstract void print();
    public abstract MathOperations add(MathOperations a);
    public abstract MathOperations multiply(MathOperations a);
    public abstract MathOperations AND(MathOperations a);
    /*abstract int subtract(int a, int b);
    abstract int divide(int a, int b);
    abstract int mod(int a, int b);
    abstract int pow(int a, int b);
    abstract int square(int a, int b);
    abstract int sqrt(int a, int b);
    abstract int sin(int a, int b);
    abstract int cos(int a, int b);
    abstract int tan(int a, int b);*/
}