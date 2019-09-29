public class OneDVector extends Scaler{
    // true = positive & false = negative
    boolean dir;
    public OneDVector(){
        super();
        dir = true;
    }

    public OneDVector(double m, boolean f){
        super(m);
        dir = f;
    }

    public double getVector(){
        if (dir){
            return magnitude;
        }
        else{
            return magnitude*-1;
        }
    }

    public void changeVector(double v){
        // to make sure direction changes too and not just magnitude
        if (v < 0 && dir){
            dir = false;
            magnitude = Math.abs(v);
        }else if(v > 0 && !dir){
            dir = true;
            magnitude = v;
        }
        else{
            magnitude = v;
        }
    }

    public String toString(){
        return magnitude+"\n"+dir;
    }
}
