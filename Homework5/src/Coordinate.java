/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 * Taken from section 3.2, An Introduction to Programming (in Java) by Robert
 * Sedgewick and Kevin Wayne
 *
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *
 *  Immutable data type for 2D points.
 *
 *************************************************************************/

/**
 * A coordinate class class
 */
public class Coordinate { 
    public final double x;   // Cartesian
    public final double y;   // coordinates
   
    /**
     * create and initialize a point with given (x, y)
     * @param x x-coordinate of point
     * @param y y-coordinate of point
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns Euclidean distance to point p
     * @param  p target point
     * @return Euclidean distance from this point to point p
     * @throws NullPointerException if p is null
     */
    public double distanceTo(Coordinate p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    /**
     * draws this point using standard draw
     */
    public void draw() {
        PennDraw.point(x, y);
    }

    /**
     * draws the line from this point to point p
     * @param p end-point of line
     * @throws NullPointerException if p is null
     */
    public void drawTo(Coordinate p) {
        PennDraw.line(x, y, p.x, p.y);
    }

    /**
     * returns string representation of this point
     * @return string representation of this point
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // test client
    public static void main(String[] args) {
        //some point class examples:
    	Coordinate x = new Coordinate(0, 0);
    	Coordinate y = new Coordinate(.3, .4);
    	System.out.println(x); //prints (0, 0);
    	System.out.println(y); //prints (.3, .4);
    	System.out.println(x.distanceTo(y)); //prints 0.5
    	x.drawTo(y); //opens a window showing a line draw (you'll never need to use this)
    }
}
