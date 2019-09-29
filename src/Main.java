public class Main {

    public static void main(String[] args) {
        /*
	    Line line1 = new Line(new Point(-4,10),new Point(90,0));

	    Line line2 = new Line(new Point(7,6),new Point(6,0));
        Point[] arr = new Point[4];
        arr[0] = new Point(0,0);
        arr[1] = new Point(0,2);
        arr[2] = new Point(2,0);
        arr[3] = new Point(2,2);
        Polygon shape = new Polygon(arr);
        System.out.println(shape);

        System.out.println(line2.reciprocal());

        Point one = new Point(1,1);
        Point two = new Point(2,7);
        Point three = new Point(3,5);
        Point four = new Point(5,4);
        Point five = new Point(8,8);
        Point six = new Point(10,5);
        Triangle a = new Triangle(one,two,three);
        Triangle b = new Triangle(one,three,four);
        Triangle c = new Triangle(one,four,six);
        Triangle d = new Triangle(four,five,six);
        double ar = a.getArea()+b.getArea()+c.getArea()+d.getArea();
        System.out.println("Concave Polygon Area: " + ar);
        Point[] arr = {one,two,three,four,five,six};
        Polygon shape = new Polygon(arr);
        System.out.println(shape.getArea());


        Triangle tri = new Triangle(one,two,three);
        System.out.println(tri.getArea());

        Line line1 = new Line(new Point(1,1),new Point(5,-1));
        Line line2 = new Line(new Point(2,4), new Point(1,1));
        System.out.println(line1.getAngle(line2));
        System.out.println(line2.getAngle(line1));

        one = new Point(1,1);
        two = new Point(3,5);
        three = new Point(2,7);
        four = new Point(8,8);
        Triangle t1 = new Triangle(one,two,three);
        Triangle t2 = new Triangle(one,two,four);
        System.out.println(t1.getArea());
        System.out.println(t2.getArea());
        */
        /*
        Point p1 = new Point(-3,6);
        Point p2 = new Point(3,-6);
        Point p3 = new Point(-6,-3);
        Point p4 = new Point(4,2);
        Line l1 = new Line(p1,p2);
        Line l2 = new Line(p4,p3);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l1.getAngle(l2));
        */

        Point k = new Point(0,0);
        Point j = new Point(1,1);
        Line linek = new Line(0,0,1,1);
        System.out.println(linek);
        System.out.println(j.sort(k));

        }
    }

