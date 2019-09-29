public class Line{
    private class LineEquation extends Equation{
        double[] domain = new double[2];
        double[] range = new double[2];
        double c;
        public LineEquation(){
            super("");
            changeCoeff(slope);
            changePow((short)1);
            setRestriction();
        }

        //this method will determine if a point is within the domain and range of any given domain and range
        public boolean withIn(Point p){
            if (p.getPosX()>domain[1] || p.getPosX()<domain[0]||p.getPosY()>range[1]||p.getPosY()<range[0]){
                return false;
            }
            return true;
        }

        private void setRestriction(){
            Point placeH1 = point1;
            Point placeH2 = point2;
            if (point2.getPosX() <= point1.getPosX()){
               point2 = placeH1;
               point1 = placeH2;
            }
            domain[0] = point1.getPosX();
            domain[1] = point2.getPosX();

            if (point2.getPosY() >= point1.getPosY()){
                range[0] = point1.getPosY();
                range[1] = point2.getPosY();
            }
            else{
                range[0] = point2.getPosY();
                range[1] = point1.getPosY();
            }
            c = point1.getPosY()-(slope*(point1.getPosX()));
        }

        public String toString(){
            return "Equation: Y = "+slope+"X + "+c+"\nDomain: ["+domain[0]+", "+domain[1]+"]\nRange: ["+range[0]+", "+range[1]+"]";
        }

        public double[] getDomain(){
            return domain;
        }

        public double[] getRange(){
            return range;
        }
    }
    private Point point1,point2;
    private double slope;
    private double len;
    public LineEquation equation;
    public Line(){
        point1 = new Point();
        point2 = new Point();
        slope = 0;
        equation = new LineEquation();
        len = 0;
    }

    public Line(Point one, Point two)throws NullPointerException{
        if (one.sort(two)){
            point1 = two;
            point2 = one;
        }else{
            point1 = one;
            point2 = two;
        }
        try{
            slope = (point2.getPosY()-point1.getPosY())/(point2.getPosX()-point1.getPosX());
            equation = new LineEquation();
            len = Math.sqrt((Math.pow(point1.getPosX()-point2.getPosX(),2)+Math.pow(point1.getPosY()-point2.getPosY(),2)));
        }catch(Exception NullPointerException){
            System.out.println("Line 74 Class.Line");
        }
    }

    public Line(Point one, double s){
        point1 = one;
        slope = s;
        //Point two = one.X+1, solve for y
        //y = mx+b, solve for b constant
        //y-mx = b
        double b = point1.getPosY()-(slope*point1.getPosX());
        //y2 = m(x+1)+b
        point2= new Point(point1.getPosX()+1,(s*(point1.getPosX()+1))+b);
        equation = new LineEquation();
        len = Math.sqrt((Math.pow(point1.getPosX()-point2.getPosX(),2)+Math.pow(point1.getPosY()-point2.getPosY(),2)));
    }

    public Line(double oneX, double oneY, double twoX, double twoY)throws NullPointerException{
        this(new Point(oneX,oneY),new Point(twoX,twoY));
    }

    public double getSlope(){
        return slope;
    }

    public Point getPoint1(){
        return point1;
    }

    public Point getPoint2(){
        return point2;
    }

    public double getLength(){
        return len;
    }

    public byte getState(Point p){
        byte returnVal = 0;
        if (slope == 0){
            if (point2.getPosY() > p.getPosY()){
                return -1;
            }
            else if (point2.getPosY() < p.getPosY()){
                return 1;
            }
            else{
                return 0;
            }
        }
        double relSlope = (point2.getPosY()-p.getPosY())/(point2.getPosX()-p.getPosX());
        //stands for relative slope

        //to be implemented in future;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

        //0 means it's on line
        //1 means it's above line and to right
        //-1 means it's below line and to right
        //2 means above line and to left
        //-2 means below line and to left
        //3 means it's above and within domain
        //-3 means it's below and within domain

        //to get state we just plug into equation

        double k = Math.abs(((p.getPosY()-point2.getPosY())-(slope*(p.getPosX()-point2.getPosX()))));
        //accounts for some error
        boolean onLineExtension = k <= .000000000000001 && k >= -.000000000000001;

        if (!(onLineExtension && equation.withIn(p))){
            returnVal = -1;
        }
        return returnVal;
    }

    public Point intersection(Line q){
        Point p  = null;
        //new idea find intersection of lines and find out if that point lies on both lines
        //point slope form = y - y1 = m(x-x1)
        //y Intercept form = y = mx+b
        //solve for intercept form by plugging in 0 for x in point slope

        //for this line

        double b = equation.c;
        double g = b;
        //for line q both solve for B of y = mx+B
        //ex: (2/3)x + 2 = -10x + 16 >>>>>  14 = (32/3)x >>>>> x approximately 1.3125
        b -= q.getSlope() * (-1 * q.getPoint1().getPosX()) + q.getPoint1().getPosY();
        double nSlope = q.getSlope() - slope;

        double x = b / nSlope;

        double y = slope * (x) + g;

        Point checker = new Point(x, y);

        if (this.getState(checker) == 0 && q.getState(checker) == 0){
            p =  checker;
        }

        return p;
    }

    public Point intersectionExtend(Line q){
        //new idea find intersection of lines and find out if that point lies on both lines
        //point slope form = y - y1 = m(x-x1)
        //y Intercept form = y = mx+b
        //solve for intercept form by plugging in 0 for x in point slope

        //for this line

        double b = equation.c;
        double g = b;
        //for line q both solve for B of y = mx+B
        //ex: (2/3)x + 2 = -10x + 16 >>>>>  14 = (32/3)x >>>>> x approximately 1.3125
        b -= q.getSlope() * (-1 * q.getPoint1().getPosX()) + q.getPoint1().getPosY();
        double nSlope = q.getSlope() - slope;

        double x = b / nSlope;

        double y = slope * (x) + g;

        return  new Point(x, y);
    }

    public boolean isOnLineSeg(Point p){
        if (isOnLine(p) && equation.withIn(p)){
            return true;
        }
        return false;
    }

    public boolean isOnLine(Point p){
        if (giveSlope(point1,p) == slope){
            return true;
        }
        return false;
    }
    //this method giveSlope returns the slope of to relative points
    public double giveSlope(Point j, Point k){
        return ((j.getPosY()-k.getPosY())/(j.getPosX()-k.getPosX()));
    }

    public Point center(){
        double changeX = (equation.getDomain()[1]-equation.getDomain()[0])/2.0;
        double changeY = (equation.getRange()[1]-equation.getRange()[0])/2.0;
        return new Point(equation.getDomain()[0]+changeX,equation.getRange()[0]+changeY);
    }

    public double reciprocal(){
        return (-1.0/slope);
    }
    //this method returns the angle created by another line. The angle it finds is the one above original line.
    public double getAngleRad(Line line){
        //Angle Theta = acos(((a^2)-(b^2)-(c^2))/(-2bc))
        Point intersection = intersectionExtend(line);
        Point pointC = new Point(intersection.getPosX()-1,intersection.getPosY()-line.getSlope());
        Point pointB = new Point(intersection.getPosX()+1,intersection.getPosY()+slope);
        double C = new Line(pointC,intersection).getLength();
        double B = new Line(intersection,pointB).getLength();
        double A = new Line(pointC,pointB).getLength();
        double Theta = Math.acos((Math.pow(A,2)-Math.pow(B,2)-Math.pow(C,2))/(-2*B*C));
        return Theta;
    }

    public double getAngle(Line line){
        return (getAngleRad(line)*180)/Math.PI;
    }

    //finds common point between two line segments return null if they don't share end points this doesn't find intersection points
    public Point findCommon(Line line){
        Point p = new Point();
        if (line.getPoint1().checkPoint(point1)){
            return point1;
        }else if(line.getPoint1().checkPoint(point2)){
            return point2;
        }
        else if(line.getPoint2().checkPoint(point1)){
            return point1;
        }
        else if (line.getPoint2().checkPoint(point2)){
            return point2;
        }
        return p;
    }

    private Point[] formatForLineSegAngle(Line line){
        Point[] arr = new Point[3];
        arr[1] = findCommon(line);
        if (arr[1] == null)
            return arr;
        if (point1 == arr[1]){
            arr[0] = new Point(1,1);
        }
        return arr;
    }

    public double getObtuseLineSeg(Line line){
        return -1;
    }

    public double getAcuteLineSeg(Line line){
        return -1;
    }

    public String toString(){
        return equation.toString()+"\nLength: "+len+"\nPoint One: "+point1.toString()+"Point Two: "+point2.toString();
    }
}
