/*************************************************************************
  *  YOU DO NOT NEED TO MODIFY THIS FILE
  *
  *  Compilation:  javac Node.java
  *  Dependencies: Point.java
  *
  *  A simple Node class to be used in a linked list by the Tour class.
  *  Each Node refers to the next Node in the list and a Point in the Tour.
  *
  *************************************************************************/

public class Node {
    public Node next;
    public Coordinate coordinate;
    
    public Node(Coordinate p) {
        next = null;
        coordinate = p;
    }
}