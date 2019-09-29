import java.util.ArrayList;
public class Triangle{
    //order of points is determined by bottom left to top right
    Point one;
    Point two;
    Point three;
    boolean isLine = false;
    public Triangle(Point o, Point tw, Point thr){
        Point[] arr = order(o,tw,thr);
        one = arr[0];
        two = arr[1];
        three = arr[2];
        check();
    }

    private void problem(int errorCode){
        System.out.println("Error\\ Cannot input more two or more of the same point");
    }

    public Point[] order(Point one, Point two, Point three){
        ArrayList<Point> unsorted = new ArrayList<Point>();
        unsorted.add(one);
        unsorted.add(two);
        unsorted.add(three);
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
        Point[] arr = new Point[h];
        for (int i = 0; i < h; i++) {
            arr[i] = sorted.get(i);
        }
        return arr;
    }
    //Method check, checks whether or not the points can be a triangle makes sure the the three points arn't on line
    public void check(){
        Line line = new Line(one,three);
        if ((one.getPosX()==two.getPosX()&&one.getPosX()==three.getPosX())||(one.getPosY()==two.getPosY()&&one.getPosY()==three.getPosY())){
            System.out.println("You seem to have put in a line not a triangle sorry");
            isLine = true;
        }
        else{
            if (line.isOnLineSeg(two)){
                System.out.println("You seem to have put in a line not a triangle sorry");
                isLine = true;
            }
            else{
                System.out.println("looks good");
            }
        }
    }

    public double getArea(){
        if (isLine){
            System.out.println("You have a line not a triangle");
            return 0;
        }
        else{
            // need to make method that finds height of triangle.
            Line line = new Line(one,three);
            //Work on Line Constructor with (Point,Slope)
            double g = line.reciprocal();
            Line reci = new Line(two,g);
            double sl = reci.getSlope();
            Point intercection = line.intersectionExtend(reci);
            Line height = new Line(two,intercection);
            return (height.getLength()*line.getLength())/2.0;
        }
    }

    public String toString(){
        return ""+one+two+three;
    }

}
