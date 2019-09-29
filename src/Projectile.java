import java.util.Scanner;
public class Projectile extends TwoDVector{
    Scanner input = new Scanner(System.in);
    Scaler mass;
    double posX;
    double posY;
    public Projectile(){
        super();
        mass = new Scaler();
        posX = 0;
        posY = 0;
    }

    public Projectile(double m){
        super();
        mass = new Scaler(m);
    }

    public Projectile(double m, double x, double y){
        super();
        posX = x;
        posY = y;
        mass = new Scaler(m);
    }

    public Projectile(double m, double ang, double v, boolean dontmatter){
        super(ang,v);
        mass = new Scaler(m);
        posY = 0;
        posX = 0;
    }
}
