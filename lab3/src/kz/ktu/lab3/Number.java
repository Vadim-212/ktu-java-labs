package kz.ktu.lab3;

public class Number extends Word {
    private double number;

    public Number() {
        this.setNumber(0.0);
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public String dataToString() {
        return java.lang.Double.toString(number);
    }
}
