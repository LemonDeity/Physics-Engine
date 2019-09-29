public class Equation {
    private double coeff;
    private short power;
    private double c;

    //equation to be formatted like y = equation
    //equation = coeff*(x^power)+c
    //take out non essential characters do this with char[] and remove based off of unicode
    //example: y = 2 x + 6 >>>> y=2x+6
    //example:
    private String equation;

    public Equation(String eq){
        c = 0;
        coeff = 0;
        power = 0;
        changeEquation(eq);
    }

    public Equation(String var, double constant){
        c = constant;
        coeff = 1;
        power = 1;
        equation = var+" = " + c;
    }

    public Equation(double coeff, String var, double power, double constant){
        coeff = coeff;
        equation = var;
        power = power;
        c = constant;
    }
    //changes equation and other variables accordingly
    public void changeEquation(String newEq){
        equation = newEq;
        check();
    }
    //this method makes sure STRING equation makes sense in context of variables stored in Object
    private void check(){
        //turns for example y = 2x + 6 >>>> y=2x+6
        char[] arr = equation.toCharArray();

        int indexEquals  = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '='){
                indexEquals = i;
                break;
            }
        }


    }

    public void changeCoeff(double newCoeff){
        coeff = newCoeff;
        check();
    }

    public void changePow(int pow){
        power = (short)pow;
    }

    public void changeConst(double con){
        c = con;
    }

    //implement in future
    public String[] listVariables(){
        return null;
    }
    //this is only for from static instant velocity from ground doesn't solve for time from higher up or from below
    public double getFreeFallTime(double g){
        //g stands for gravity
        return ((-2*c)/g);
    }

    public double getFreeFallTime(){
        return getFreeFallTime(-9.8);
    }

    public double getPeriodSpring(double mass, double spring_Constant) {
        //T = 2pi*sqrt(mass/spring_Constant)

        return 2*Math.PI*Math.sqrt((mass/spring_Constant));
    }

    public double getPeriodPendulumn(double length, double accel){
        //T = 2pi*sqrt(length/accel)

        return getPeriodSpring(length,accel);
    }

    public double getMassSpringPeriod(double period, double spring_Constant){
        //mass = k((T/2pi)^2)

        return spring_Constant*Math.pow(period/(2*Math.PI),2);
    }

    public double getLengthPendulumnPeriod(double period, double accel){
        return getMassSpringPeriod(period, accel);
    }

    public double getSpring_Constant(double period, double mass){
        //spring_Constant = mass/((period/2pi)^2)
        return mass/(Math.pow((period/(2*Math.PI)),2));
    }

    public double getAccelPendulumn(double period, double length){
        return getSpring_Constant(period,length);
    }

    public double getInverse(double num){
        return (1.0/num);
    }
}
