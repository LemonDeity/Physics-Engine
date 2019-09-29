public class Scaler {
    double magnitude;
    public Scaler(){
        magnitude = 0;
    }

    public Scaler(double mag){
        magnitude = Math.abs(mag);
    }
    public double getMagnitude() {
        return magnitude;
    }
}
