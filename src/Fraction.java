public class Fraction {
    double numerator;
    double denominator;
    public Fraction(){
        numerator = 1;
        denominator = 1;
    }

    public Fraction(double n, double d){
        numerator = n;
        denominator = d;
    }

    public double toDouble(){
        return numerator/denominator;
    }
}
