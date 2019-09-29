import java.util.ArrayList;

public class Point {
    private double posX;
    private double posY;
    public Point(){
        posX = 0;
        posY = 0;
    }

    public Point(double x, double y){
        posX = x;
        posY = y;
    }


    public double getPosX(){
        return posX;
    }

    public double getPosY() {
        return posY;
    }
    //checks if points are the same;
    public boolean checkPoint(Point p){
        if (p.getPosX() == posX && p.getPosY() == posY){
            return true;
        }
        return false;
    }

    public int abovePoint(Point p){
        if (p.getPosY() < posY){
            return -1;//means it's above
        }
        else if(p.getPosY() > posY){
            return 1;//means it's below
        }
        else{
            return 0;//means it's at the same Y
        }
    }

    public int belowPoint(Point p){
        return abovePoint(p)*-1;
    }
    //to see if past POint p in x axis
    public int pastPoint(Point p){
        if (p.getPosX() < posX){
            return -1;//means it's to the left
        }
        else if(p.getPosX() > posX){
            return 1;//means it's to right
        }
        else{
            return 0;//means it's at the same X
        }
    }

    public int beforePoint(Point p){
        return pastPoint(p)*-1;
    }
    //this method is for Polygon and triangle class for ease of sorting determines if a point should be before or after another point
    public boolean sort(Point p){
        //true means it should go before
        //false means it should go afterwards
        boolean h = true;
        if (beforePoint(p) == -1){
            h = false;
        }
        else if(beforePoint(p) == 0){
            // this means they have the same X coordinate now must go into Y coordinate checking
            if (belowPoint(p) == -1) {
                //this means Point p is above the point
                h = false;
            }
        }
        return h;
    }

    public static Point[] order(Point[] arr){
        ArrayList<Point> unsorted = new ArrayList<Point>();
        for (int i = 0; i < arr.length; i++) {
            unsorted.add(arr[i]);
        }
        ArrayList<Point> sorted = new ArrayList<Point>();
        for (Point p: unsorted) {
            if (sorted.size() == 0){
                sorted.add(p);
            }
            else{
                int g = sorted.size();
                for (int i  = 0; i < g; i++) {
                    if (sorted.get(i).sort(p)){
                        sorted.add(i,p);
                        break;
                    }
                }
                if (sorted.size() == g){
                    sorted.add(p);
                }
            }
        }
        int h = sorted.size();
        Point[] arr2 = new Point[h];
        for (int i = 0; i < h; i++) {
            arr2[i] = sorted.get(i);
        }
        return arr2;
    }

    public String toString(){
        return "["+posX+", "+posY+"]\n";
    }
}
