public class ArithmeticOperation {
    private double firstNo;
    private double secondNo;
    private char arithmeticSign;

    public ArithmeticOperation(double firsNumber, double secondNumber, char arithmeticSign) {
        this.firstNo = firsNumber;
        this.secondNo = secondNumber;
        this.arithmeticSign = arithmeticSign;
    }

    public double getFirstNo() {
        return firstNo;
    }

    public double getSecondNo() {
        return secondNo;
    }

    public char getArithmeticSign() {
        return arithmeticSign;
    }
}
