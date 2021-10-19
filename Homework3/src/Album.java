import java.util.ArrayList;

/**
 * Homework 3
 * 
 * @author Alisha Agrawal, aa3se
 */

public class Album extends PhotographContainer {
    /**
     * Creates an Album object.
     * 
     * @param name The name of the new Album object
     */
    public Album(String name) {
        super(name);
        this.name = name;
        this.photos = new ArrayList<Photograph>();
    }

}
