import java.util.HashSet;

/**
 * Homework 2
 * @author Alisha Agrawal, aa3se
 */

public class Album {
    /**
     * Contains the Album's name
     */
    private String name;

    /**
     * A HashSet of Photograph objects in the album
     */
    private HashSet<Photograph> photos;

    /**
     * Creates an Album object.
     * 
     * @param name The name of the new Album object
     */

    /**
     * Creates an Album object.
     * 
     * @param name The name of the new Album object
     */
    public Album(String name) {
        this.name = name;
        this.photos = new HashSet<Photograph>();
    }

    /**
     * Get the name of the Album.
     * 
     * @return the value of the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name for the Album.
     * 
     * @param name The new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the set of photos in the Album.
     * 
     * @return The set of photos
     */
    public HashSet<Photograph> getPhotos() {
        return photos;
    }

    /**
     * Adds a Photograph object to the Album if it is not already in the set of photos. Returns true if the Photograph is
     * added.
     * 
     * @param p The Photograph object to be added
     * @return Whether or not the Photograph object has been added
     */
    public boolean addPhoto(Photograph p) {
        if (p != null) { // checks photograph object
            return photos.add(p);
        }
        return false;
    }

    /**
     * Checks if a Photograph object is in the set of photos. Returns true if the Photograph is in the set of photos.
     * 
     * @param p The Photograph object to be checked
     * @return Whether or not the Photograph object is in the set of photos
     */
    public boolean hasPhoto(Photograph p) {
        return photos.contains(p);

    }

    /**
     * Removes a Photograph object if it is in the set of photos. Returns true if the Photograph has been removed from the
     * set of photos.
     * 
     * @param p The Photograph object to be removed
     * @return Whether or not the Photograph object has been removed from the set of photos
     */
    public boolean removePhoto(Photograph p) {
        return photos.remove(p);

    }

    /**
     * Gives the number of Photographs the object has in the set of photos.
     * 
     * @return the number of Photographs in the set of photos.
     */
    public int numPhotographs() {
        return photos.size();
    }

    /**
     * Checks if a Album object's name is equal to the current Album object's name. Returns true if the names match.
     * 
     * @param o Album object to be matched
     * @return Whether or not the two Album objects names match
     */
    public boolean equals(Object o) {
        if (o instanceof Album) {
            Album other = (Album) o;
            return other.name.equals(name);
        } else {
            return false;
        }
    }

    /**
     * A means to print out a Album object. Returns a String.
     * 
     * @return The values of the fields name and photos
     */
    public String toString() {
        String s = "";
        s += "Name: " + name + "\n";
        s += "Photos: " + photos;
        return s;
    }

    /**
     * Overrides default hashCode method in the Object class to produce a unique integer for a Album.
     * 
     * @return hash code of the name field
     */
    public int hashCode() {
        return name.hashCode();
    }

}
