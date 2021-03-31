/**
 * Triangle.java represents a triangle in the Euclidean space.
 * 
 * @author  Eden Lavi
 * @version 314649799
 */ 
public class Triangle
{
    private Point _point1,_point2,_point3;
    public final static double EPSILON=0.001;
    /**
     * Construct a new Triangle using 3 default Points:(1,0),(-1,0),(0,1)
     */
    public Triangle()
    {
        setDefault();
    }

    /**
     * Construct a new Triangle (from 6 reals)
     * @param x1 the x coordinate of the first Point
     * @param y1 the y coordinate of the first Point
     * @param x2 the x coordinate of the second Point
     * @param y2 the y coordinate of the second Point
     * @param x3 the x coordinate of the third Point
     * @param y3 the y coordinate of the third Point
     */
    public Triangle(double x1,double y1,double x2,double y2,double x3,double y3)
    {
        Point p1=new Point(x1,y1);
        Point p2=new Point(x2,y2);
        Point p3=new Point(x3,y3);
        if(isValid(p1,p2,p3)) 
        {
            _point1=p1;
            _point2=p2;
            _point3=p3;
        }
        else 
            setDefault();
    }

    /**
     * Construct a new Triangle (from 3 points)
     * @param p1 the first Point
     * @param p2 the second Point
     * @param p3 the third Point
     */
    public Triangle(Point p1,Point p2,Point p3)
    {
        if(isValid(p1,p2,p3)){
            _point1=new Point(p1);
            _point2=new Point(p2);
            _point3=new Point(p3);
        }
        else 
            setDefault();
    }

    /**
     * Copy constructor Creates a new triangle identical to the given triangle
     * @param other the triangle to be copied
     */
    public Triangle(Triangle other)
    {
        _point1=new Point(other._point1); 
        _point2=new Point(other._point2); 
        _point3=new Point(other._point3); 
    }

    /**
     * This method returns the triangle's first point.
     * @return The first point of the triangle
     */
    public Point getPoint1(){
        return new Point(_point1);
    }

    /**
     * This method returns the triangle's second point.
     * @return The second point of the triangle
     */
    public Point getPoint2(){
        return new Point(_point2);
    }

    /**
     * This method returns the triangle's third point.
     * @return The third point of the triangle
     */
    public Point getPoint3(){
        return new Point(_point3);
    }

    /**
     * This method returns the triangle's perimeter.
     * @return The triangle's perimeter
     */
    public double getPerimeter(){
        double a,b,c;
        a=getSideA();
        b=getSideB();
        c=getSideC();
        return a+b+c;
    }

    /**
     *  This method returns the triangle's area (using Heron's formula).
     *  @return The triangle's area
     */
    public double getArea(){
        double a,b,c;
        a=getSideA();
        b=getSideB();
        c=getSideC();
        double p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    /**
     * This method sets the first point of the triangle.
     * @param p the new first point
     */
    public void setPoint1(Point p){
        if(isValid(p,_point2,_point3))
            _point1=new Point(p);
    }

    /**
     * This method sets the second point of the triangle.
     * @param p the new second point
     */
    public void setPoint2(Point p){
        if(isValid(_point1,p,_point3))
            _point2=new Point(p);
    }

    /**
     * This method sets the third point of the triangle.
     * @param p the new third point
     */
    public void setPoint3(Point p){
        if(isValid(_point1,_point2,p))
            _point3=new Point(p);
    }

    /**
     * This method returns true if the triangle is an isosceles triangle(with precision EPSILON).
     * @return true if the triangle is an isosceles triangle
     */
    public boolean isIsosceles(){
        double a,b,c;
        double A,B,C;
        a=getSideA();
        b=getSideB();
        c=getSideC();
        A=Math.abs(a-b);
        B=Math.abs(a-c);
        C=Math.abs(b-c);
        if(A<EPSILON || B<EPSILON || C<EPSILON)
            return true;
        return false;
    }

    /**
     * This method sets triangle`s points from 3 default Points:(1,0),(-1,0),(0,1).
     */
    private void setDefault(){
        _point1=new Point(1,0);
        _point2=new Point(-1,0);
        _point3=new Point(0,1);
    }
    
    /**
     * This method return triangle`s A side (point1 to point2).
     * @return triangle`s A side
     */
    private double getSideA(){
     return _point1.distance(_point2);
    }
    
    /**
     * This method return triangle`s B side (point1 to point3).
     * @return triangle`s B side
     */
    private double getSideB(){
     return _point1.distance(_point3);
    }
    
    /**
     * This method return triangle`s C side (point2 to point3).
     * @return triangle`s C side
     */
    private double getSideC(){
     return _point2.distance(_point3);
    }
    
    /**
     * This method checks if 3 points make a valid triangle.
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @return true if the triangle(p1,p2,p3) is valid
     * 
     */
    public boolean isValid(Point p1,Point p2,Point p3){  
        double a,b,c;
        a=p1.distance(p3);
        b=p1.distance(p2);
        c=p2.distance(p3);
        double A,B,C;
        A=Math.abs(a-b-c);
        B=Math.abs(b-a-c);
        C=Math.abs(c-a-b);
        if(A>EPSILON && B>EPSILON && C>EPSILON)
            return true;
        return false;
    }

    /**
     *  This method returns a String representation of this Triangle.
     *  @return a String representation of the triangle
     */
    public String toString(){
        return "{"+_point1+","+_point2+","+_point3+"}";
    }

    /**
     * This method returns the lowest vertex of the triangle.
     * @return The lowest vertex
     */
    public Point lowestPoint(){
        if(_point1.isUnder(_point2) && _point1.isUnder(_point3))
            return new Point(_point1);
        if(_point2.isUnder(_point1) && _point2.isUnder(_point3))
            return new Point(_point2);
        if(_point3.isUnder(_point1) && _point3.isUnder(_point2))
            return new Point(_point3);
        if(_point1.isUnder(_point2))
        {
            if(_point1.isLeft(_point3))
                return new Point(_point1);
            return new Point(_point3);
        }
        else
        {
            if(_point2.isUnder(_point3))
            {
                if(_point1.isLeft(_point2))
                    return new Point(_point1);
                return new Point(_point2);
            }
            else
            {
                if(_point2.isLeft(_point3))
                    return new Point(_point2);
                return new Point(_point3);
            }
        }     
    }

    /**
     * This method returns the highest vertex of the triangle.
     * @return The highest vertex
     */
    public Point highestPoint(){
        if(_point1.isAbove(_point2) && _point1.isAbove(_point3))
            return new Point(_point1);
        if(_point2.isAbove(_point1) && _point2.isAbove(_point3))
            return new Point(_point2);
        if(_point3.isAbove(_point1) && _point3.isAbove(_point2))
            return new Point(_point3);
        if(_point1.isAbove(_point2))
        {
            if(_point1.isLeft(_point3))
                return new Point(_point1);
            return new Point(_point3);
        }
        else
        {
            if(_point2.isAbove(_point3))
            {
                if(_point1.isLeft(_point2))
                    return new Point(_point1);
                return new Point(_point2);
            }
            else
            {
                if(_point2.isLeft(_point3))
                    return new Point(_point2);
                return new Point(_point3);
            }
        }
    }

    /**
     *  This method checks if this triangle is completely above a received triangle.
     *  @param other the triangle to check if this triangle is above
     *  @return true if this triangle is above the other triangle
     */
    public boolean isAbove(Triangle other){
        return lowestPoint().isAbove(other.highestPoint());
    }

    /**
     *  This method checks if this triangle is completely below a received triangle.
     *  @param other the triangle to check if this triangle is below
     *  @return true if this triangle is below the other triangle
     */
    public boolean isUnder(Triangle other){
        return other.isAbove(this);
    }

    /**
     * This method checks if the given triangle is equal to this triangle.
     * @param other the triangle we are checking equality with
     * @return true if the triangle other is equal to this triangle
     */
    public boolean equals(Triangle other){
        if(_point1.equals(other._point1))
            if(_point2.equals(other._point2))
                if(_point3.equals(other._point3)) 
                    return true;
        return false;
    }

    /**
     * This method checks if the given triangle is congruent to this triangle.
     * @param other the triangle we are checking congruency with
     * @return true if the triangle other is congruent to this triangle
     */
    public boolean isCongruent(Triangle other){
       double a,b,c,a2,b2,c2;
       a=getSideA();
       b=getSideB();
       c=getSideC();
       a2=other.getSideA();
       b2=other.getSideB();
       c2=other.getSideC();
       if(Math.abs(a-a2)<EPSILON)
            if((Math.abs(b-b2)<EPSILON && Math.abs(c-c2)<EPSILON) || (Math.abs(b-c2)<EPSILON && Math.abs(c-b2)<EPSILON))
                return true;
       if(Math.abs(a-b2)<EPSILON)
            if((Math.abs(b-a2)<EPSILON && Math.abs(c-c2)<EPSILON) || (Math.abs(b-c2)<EPSILON && Math.abs(c-a2)<EPSILON))
                return true;
       if(Math.abs(a-c2)<EPSILON)
            if((Math.abs(b-a2)<EPSILON && Math.abs(c-b2)<EPSILON) || (Math.abs(b-b2)<EPSILON && Math.abs(c-a2)<EPSILON))
                return true;
        return false;
    }

    /**
     * This method returns true if the triangle is entirely in one quadrant.
     * @return true if the triangle is entirely in one quadrant
     */
    public boolean isLocated(){
        int quad=_point1.quadrant();
        if(quad==0)
            return false;
        if(_point2.quadrant()==quad && _point3.quadrant()==quad)
            return true;
        return false;
    }

    /**
     * This method returns true if the triangle is a right-angled triangle.
     * @return true if the triangle is a right-angled triangle
     */
    public boolean isPythagorean(){
        double aPow,bPow,cPow;
        double a,b,c;
        a=getSideA();
        b=getSideB();
        c=getSideC();
        aPow=Math.pow(a,2);
        bPow=Math.pow(b,2);
        cPow=Math.pow(c,2);
        if(Math.abs(aPow-bPow-cPow)<EPSILON)
            return true;
        if(Math.abs(bPow-aPow-cPow)<EPSILON)
            return true;
        if(Math.abs(cPow-aPow-bPow)<EPSILON)
            return true;
        return false;
    }

    /**
     * This method returns true if the triangle is in a given circle.
     * @param x the x value of the point which is the center of the circle
     * @param y the y value of the point which is the center of the circle
     * @param r the radius of the circle
     * @return true if the triangle is in a given circle.
     */
    public boolean isContainedInCircle(double x,double y,double r){
        Point center=new Point(x,y);
        if(r-_point1.distance(center)>-EPSILON)
            if(r-_point2.distance(center)>-EPSILON) 
                if(r-_point3.distance(center)>-EPSILON) 
                    return true;
        return false;
    }
}
