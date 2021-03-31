/**
 * Point.java represents a 2-Dimensional point in the Euclidean space.
 *
 * @author Eden Lavi
 * @version 314649799
 */
public class Point
{
    private double _x,_y;
    /**
     *  Constructs a new Point
     */
    public Point(double x,double y)
    {
        _x=x;
        _y=y;
    }

    /**
     *  Copy constructor Creates a new Point identical to the given point
     */
    public Point(Point p)
    {
        _x=p._x;
        _y=p._y;
    }

    /**
     *  This method returns the x coordinate.
     *  
     *  @return Current x coordinate
     */
    public double getX(){
        return _x;
    }

    /**
     *  This method returns the y coordinate.
     *  
     *  @return Current y coordinate
     */
    public double getY(){
        return _y;
    }

    /**
     * This method sets the x coordinate of the point.
     *   
     * @param num the new x coordinate
     */
    public void setX(double num){
        _x=num;
    }

    /**
     * This method sets the y coordinate of the point.
     *   
     * @param num the new y coordinate
     */
    public void setY(double num){
        _y=num;
    }

    /**
     * This method returns a string representation of this Point.
     * 
     * @return a String representation of a Point object
     */
    public String toString(){
        return "("+_x+","+_y+")";
    }

    /**
     * This method returns true if the given point is equal to this point.
     * 
     * @param other  the point we are checking equality with
     * @return true if the point other equals this point
     */
    public boolean equals(Point other){
        if(_x==other._x && _y==other._y)
            return true;
        return false;
    }

    /**
     * This method checks if this point is above a received point.
     * 
     * @param other the point to check if this point is above
     * @return true if this point is above the other point
     */
    public boolean isAbove(Point other){
        if(_y>other._y)
            return true;
        return false;   
    }

    /**
     * This method checks if this point is below a received point.
     * 
     * @param other the point to check if this point is below
     * @return true if this point is below the other point
     */
    public boolean isUnder(Point other){
        return other.isAbove(this);
    }

    /**
     * This method checks if this point is left of a received point.
     * 
     * @param other the point to check if this point is left of
     * @return true if this point is left of the other point
     */
    public boolean isLeft(Point other){
        if(other._x>_x)
            return true;
        return false;
    }

    /**
     * This method checks if this point is right of a received point.
     * 
     * @param other the point to check if this point is right of
     * @return true if this point is right of the other point
     */
    public boolean isRight(Point other){
        return other.isLeft(this);
    }

    /**
     * This method checks the distance between this point and a received point.
     * 
     * @param other the point to check the distance from
     * @return The distance between this point and a received point
     */
    public double distance(Point p){
        return Math.sqrt(Math.pow((p.getY()-_y),2.0)+Math.pow((p.getX()-_x),2.0));
    }

    /**
     * This method returns number of quadrant or 0 if the point is on an axis.
     * 
     * @return An int representing the quadrant number
     */
    public int quadrant(){
        if(_y==0 || _x==0)
            return 0;
        if(_x>0)
            if(_y>0)
                return 1;
            else
                return 4;
        if(_y>0)
            return 2;
        return 3;
    }

}
