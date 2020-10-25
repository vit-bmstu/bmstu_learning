import java.util.ArrayList;

class MyClass {
    public static ArrayList<Fraction> array = new ArrayList<Fraction>();


}

public class Fraction {

    int numerator;
    int denominator;



    /**
     * Constructor
     *
     * @param numr
     * @param denr
     */
    public Fraction(int numr, int denr) {
        numerator = numr;
        denominator = denr;
        reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    /**
     * Calculates gcd of two numbers
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public int calculateGCD(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        }
        return calculateGCD(denominator, numerator % denominator);
    }

    /**
     * Reduce the fraction to lowest form
     */
    void reduce() {
        int gcd = calculateGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * Adds two fractions
     *
     * @param fractionTwo
     * @return
     */
    public Fraction add(Fraction fractionTwo) {
        int numer = (numerator * fractionTwo.getDenominator()) +
                (fractionTwo.getNumerator() * denominator);
        int denr = denominator * fractionTwo.getDenominator();
        return new Fraction(numer, denr);
    }

    /**
     * Subtracts two fractions
     *
     * @param fractionTwo
     * @return
     */
    public Fraction subtract(Fraction fractionTwo) {
        int newNumerator = (numerator * fractionTwo.denominator) -
                (fractionTwo.numerator * denominator);
        int newDenominator = denominator * fractionTwo.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    /**
     * Multiples two functions
     *
     * @param fractionTwo
     * @return
     */
    public Fraction multiply(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.numerator;
        int newDenominator = denominator * fractionTwo.denominator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    /**
     * Divides two fractions
     *
     * @param fractionTwo
     * @return
     */
    public Fraction divide(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.getDenominator();
        int newDenominator = denominator * fractionTwo.numerator;
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }
    /**
     * Returns string representation of the fraction
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }


        public static void main(String[] args) {
        Fraction f1 = new Fraction(25, 35);
        System.out.println("Первая дробь " + f1.toString());
        Fraction f2 = new Fraction(2, 5);
        System.out.println("Вторая дробь " + f2.toString());
        Fraction f3 = f1.add(f2);
        System.out.println("Результат сложения  "
                + f1 + " и " + f2 + " is : " + f3);
        f3 = f1.subtract(f2);
        System.out.println("Результат вычитания "
                + f1 + " и " + f2 + " is : " + f3);
        f3 = f1.divide(f2);
        System.out.println("Результат деления "
                + f1 + " и " + f2 + " is : " + f3);
        f3 = f1.multiply(f2);
        System.out.println("Результат умножения "
                + f1 + " и " + f2 + " is : " + f3);
        int count = 1;

        Fraction k = new Fraction(1, 3);
        do {
            Fraction f4;
            f4 = new Fraction(1, (count+1));
            Fraction c = k.add(f4);
            MyClass.array.add(c);
            count++;
        } while (count < 7);
        System.out.println("Начальный массив из k - дробей " + MyClass.array);
        //System.out.println("Модифиц.  массив из k - дробей " + MyClass.array)
            }
        }
