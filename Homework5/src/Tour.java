/**
 * Homework 5
 * 
 * @author CS2110, Alisha Agrawal (aa3se) 
 * 
 * Sources: Lecture notes
 */

public class Tour {
    private Node head, tail;
    private int size;

    /**
     * Constructor: Initializes head, tail, and size DO NOT EDIT THIS METHOD
     */
    public Tour() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * This method is used by VisualizeTour and has been completed for you. Do not edit this method!
     * 
     * @param p
     */
    public void draw(Coordinate p) {
        for (Node t = head; t != tail; t = t.next) {
            if (t.coordinate == p || t.next.coordinate == p) {
                PennDraw.setPenColor(PennDraw.RED);
            } else {
                PennDraw.setPenColor(PennDraw.BLACK);
            }
            t.coordinate.drawTo(t.next.coordinate);
        }

    }

    /**
     * Gets number of coordinates in the Tour. Returns an int.
     * 
     * @return The number of coordinates in the Tour
     */
    public int size() {
        return size;
    }

    /**
     * Finds the total distance traveled by the tour from head to tail. Returns a double.
     * 
     * @return The total distance
     */
    public double distance() {
        double distance = 0.0;
        for (Node t = head; t != tail; t = t.next) {
            distance += t.coordinate.distanceTo(t.next.coordinate);
        }
        return distance;
    }

    /**
     * This method is a helper method int insert the first point into the tour. This method creates two nodes that are both
     * the starting and ending point.
     * 
     * @param p The coordinate for the new Node
     */
    private void insertIntoEmptyTour(Coordinate p) {
        head = new Node(p);
        tail = new Node(p);
        head.next = tail;
        size++;
    }

    /**
     * Inserts coordinate p immediately after the head node.
     * 
     * @param p The Coordinate for the Node to be inserted
     */
    public void insertInOrder(Coordinate p) {
        if (head == null) {
            insertIntoEmptyTour(p);
        } else {
            Node newNode = new Node(p); // create new Node with Coordinate p
            newNode.next = head.next;
            head.next = newNode;
            size++;
        }

    }

    /**
     * Inserts coordinate p immediately after the node with the closest coordinate.
     * 
     * @param p The Coordinate for the Node to be inserted
     */
    public void insertNearest(Coordinate p) {
        if (head == null) {
            insertIntoEmptyTour(p);
        } else {
            Node newNode = new Node(p); // create new Node with Coordinate p
            Node minNode = head; // helper Node to track Node with smallest distance
            double distance = 0.0;
            double minDistance = newNode.coordinate.distanceTo(head.coordinate); // distance from newNode to head
            for (Node t = head; t != tail; t = t.next) {
                distance = newNode.coordinate.distanceTo(t.coordinate); // distance from newNode to each Node
                if (distance < minDistance) { // checks if the distance is smaller than current smallest distance
                    minDistance = distance;
                    minNode = t; // saves the Node with the smallest distance
                }
            }
            newNode.next = minNode.next;
            minNode.next = newNode;
            size++;
        }
    }

    /**
     * Inserts coordinate p immediately into the tour where it increases total distance by the least amount.
     * 
     * @param p The Coordinate for the Node to be inserted
     */
    public void insertSmallest(Coordinate p) {
        if (head == null) {
            insertIntoEmptyTour(p);
        } else {
            Node newNode = new Node(p); // create new Node with Coordinate p
            Node minNode = head; // helper Node to track Node with smallest distance
            double distance = 0.0;
            double minDistance = (newNode.coordinate.distanceTo(head.coordinate)
                    + newNode.coordinate.distanceTo(head.next.coordinate)) - head.coordinate.distanceTo(head.next.coordinate); // increase
                                                                                                                               // in
                                                                                                                               // Tour's
                                                                                                                               // distance
                                                                                                                               // from
                                                                                                                               // head
            for (Node t = head; t != tail; t = t.next) {
                distance = (newNode.coordinate.distanceTo(t.coordinate) + newNode.coordinate.distanceTo(t.next.coordinate))
                        - t.coordinate.distanceTo(t.next.coordinate); // increase in Tour's distance for each Node
                if (distance < minDistance) { // checks if the increase in distance is smaller than current smallest distance
                    minDistance = distance;
                    minNode = t; // saves the Node with the smallest increase in distance
                }
            }
            newNode.next = minNode.next;
            minNode.next = newNode;
            size++;
        }
    }

    /**
     * Prints all of the coordinates in the tour. Returns a String.
     * 
     * @return All coordinates in the tour.
     */
    public String toString() {
        String s = "";
        if (size() == 0) {
            return s;
        }
        for (Node t = head; t != null; t = t.next) {
            s += t.coordinate + "\n";
        }
        return s;
    }

}
