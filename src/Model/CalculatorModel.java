package Model;

public class CalculatorModel {
    private double result;

    public CalculatorModel() {
        result = 0;
    }

    public double getResult() {
        return result;
    }

    public void add(double number) {
        result += number;
    }

    public void subtract(double number) {
        result -= number;
    }

    public void multiply(double number) {
        result *= number;
    }

    public void divide(double number) {
        if (number != 0) {
            result /= number;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public void clear() {
        result = 0;
    }
}
