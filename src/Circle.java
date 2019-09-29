public class Circle {
    private double radius;
    private Point center;
    //(x-center.getPosX())^2+(y-center.getPosY()) = radius^2
    public Circle(){
        radius = 0;
        center = null;
    }

    public Circle(double r, Point p){
        radius = r;
        center = p;
    }

    public void changeRadius(double r){
        radius = r;
    }

    public void changeCenter(Point p){
        center = p;
    }

    public double getDiameter(){
        return radius*2;
    }

    public double getRadius(){return radius;}

    public Point getCenter(){return center;}

}
