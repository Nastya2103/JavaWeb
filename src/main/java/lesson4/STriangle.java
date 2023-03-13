package lesson4;

public class STriangle {

    public double triangleArea(double a, double b, double c) throws MyException {
        if (rightValues(a, b, c));
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private static boolean rightValues(double a, double b, double c) throws MyException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new MyException ("Некорректная величина. Необходимо исправить");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new MyException("Таких треугольников не существует!");
        }
        return false;
    }
}
