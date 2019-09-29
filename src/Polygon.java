import java.util.ArrayList;
import java.util.Scanner;
public class Polygon{
    Point[] points;
    double area;
    public Polygon(Point[] p){
        points = Point.order(p);
        area = calcArea();
        if (points.length < 3){
            System.out.println("Not enough points to make Polygon\nNeed at least 3 points");
        }
    }

    public Polygon(){
        points = null;
        area = -1;
    }
    public Point[] getPoints(){
        return points;
    }

    public double getArea(){
        return area;
    }

    public double calcArea(){
        ArrayList<Point> right = new ArrayList<Point>();
        ArrayList<Point> left = new ArrayList<Point>();
        for (int i = 1; i < points.length; i++) {
            if (points[i].getPosY()>=points[0].getPosY()){
                right.add(points[i]);
            }
            else{
                left.add(0,points[i]);
            }
        }
        Triangle[] polyArea = new Triangle[points.length-2];
        for (int i = 0; i < polyArea.length; i++) {
            if (right.size()>1){
                polyArea[i] = new Triangle(points[0],right.remove(0),right.get(0));
            }
            else if(right.size() == 1){
                polyArea[i] = new Triangle(points[0],right.remove(0),left.get(0));
            }
            else{
                polyArea[i] = new Triangle(points[0],left.remove(0),left.get(0));
            }
        }
        double A = 0;
        for (int i = 0; i < polyArea.length; i++) {
            A += polyArea[i].getArea();
        }
        return A;
    }

    public void changePoint(){
        Scanner input = new Scanner(System.in);
        System.out.println("Pick which point to change based on index");
        for (int i = 0; i < points.length; i++) {
            System.out.print(i+": "+points[i]+" ");
        }
        System.out.println();
        System.out.println("Index: ");
        int index = input.nextInt();
        input.nextLine();
        System.out.println("Choose new Point");
        System.out.println("Enter X: ");
        double x = input.nextDouble();
        input.nextLine();
        System.out.println("Enter Y: ");
        double y = input.nextDouble();
        input.nextLine();
        points[index] = new Point(x,y);

    }

    public String toString(){
        String str = "";
        for (int i = 0; i < points.length; i++) {
            str += "Point "+i+": "+points[i];
        }
        return str;
    }

    public Point getPoint(){
        Scanner input = new Scanner(System.in);
        System.out.println("Pick which Point you want");
        for (int i = 0; i < points.length; i++) {
            System.out.print("Point "+i+": "+points[i]);
        }
        System.out.println("Index: ");
        int index = input.nextInt();
        input.nextLine();
        return points[index];
    }
}
