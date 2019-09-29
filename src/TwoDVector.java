public class TwoDVector {
    OneDVector vectorX,vectorY;
    //sum = hypotenuse
    double sum;
    //angle is based off of angle of angle of inclination
    // negative means angle of depression will be changed to correspond to angle of inclination
    double angle;

    public TwoDVector(){
        vectorX = new OneDVector();
        vectorY = new OneDVector();
        sum = 0;
        angle = 0;
    }

    public TwoDVector(double ang, double v){
        //means angle of depression
        sum = v;
        if (ang < 0){
            angle = 90 + ang;
        }
        else{
            angle = ang;
        }
        if (angle == 0){
            vectorX = new OneDVector(v,true);
            vectorY = new OneDVector(0,true);
        }else{
            vectorX = new OneDVector(Math.cos(angle)*sum,true);
            vectorY = new OneDVector(Math.sin(angle)*sum,true);
        }
    }

    //boolean is only to tell between constructors because they have same parameters
    public TwoDVector(double x, double y,boolean doestmatter){
        sum = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        angle = Math.atan(y/x);
        vectorX = new OneDVector(x,true);
        vectorY = new OneDVector(y,true);
    }
    //update is only to make sure math still works
    public boolean update(){
        return true;
    }

    public void changeSum(double s){
        sum = s;
    }

    public void changeX(double x){
        vectorX.changeVector(x);
    }

    public void changeY(double y){
        vectorY.changeVector(y);
    }

    public void changeAngle(double a){
        angle = a;
    }
    // defaults to angle of inclination
    public double getAngle(){
        return angle;
    }
    //angle of inclination
    public double getAngleI(){
        return getAngle();
    }
    //angle of depression
    public double getAngleD(){
        return 90.0-angle;
    }

    public double getVector(){
        return sum;
    }

    public double getVectorX(){
        return vectorX.getVector();
    }

    public double getVectorY(){
        return vectorY.getVector();
    }

    public String toString(){
        return "Vector : "+getVector()+"\nVectorX : "+getVectorX()+"\nVectorY : "+getVectorY()+"\nAngle of Inclination : "+getAngle()
                +"\nAngle of Depression : "+getAngleD();
    }

    public void printVector(){
        System.out.println(this);
    }



}
