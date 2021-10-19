import java.util.ArrayList;

/**
 * Homework 3
 * 
 * @author Alisha Agrawal, aa3se
 */

public abstract class PhotographContainer {
    /**
     * Contains the PhotographContainer's name
     */
    protected String name;

    /**
     * A ArrayList of Photograph objects in the PhotographContainer
     */
    protected ArrayList<Photograph> photos;

    /**
     * Creates an PhotographContainer object.
     * 
     * @param name The name of the new Album object
     */
    public PhotographContainer(String name) {
        this.name = name;
        this.photos = new ArrayList<Photograph>();
    }

    /**
     * Get the name of the PhotographContainer.
     * 
     * @return the value of the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name for the PhotographContainer.
     * 
     * @param name The new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the list of photos in the PhotographContainer.
     * 
     * @return The list of photos
     */
    public ArrayList<Photograph> getPhotos() {
        return photos;
    }

    /**
     * Adds a Photograph object to the PhotographContainer if it is not already in the list of photos. Returns true if the
     * Photograph is added.
     * 
     * @param p The Photograph object to be added
     * @return Whether or not the Photograph object has been added
     */
    public boolean addPhoto(Photograph p) {
        if (p != null) { // checks photograph object
            if (!hasPhoto(p)) {
                return photos.add(p);
            }
        }
        return false;
    }

    /**
     * Checks if a Photograph object is in the list of photos. Returns true if the Photograph is in the list of photos.
     * 
     * @param p The Photograph object to be checked
     * @return Whether or not the Photograph object is in the list of photos
     */
    public boolean hasPhoto(Photograph p) {
        return photos.contains(p);

    }

    /**
     * Removes a Photograph object if it is in the list of photos. Returns true if the Photograph has been removed from the
     * list of photos.
     * 
     * @param p The Photograph object to be removed
     * @return Whether or not the Photograph object has been removed from the list of photos
     */
    public boolean removePhoto(Photograph p) {
        return photos.remove(p);

    }

    /**
     * Gives the number of Photographs the object has in the list of photos.
     * 
     * @return the number of Photographs in the list of photos.
     */
    public int numPhotographs() {
        return photos.size();
    }

    /**
     * Checks if a PhotographContainer object's name is equal to the current PhotographContainer object's name. Returns true
     * if the names match.
     * 
     * @param o PhotographContainer object to be matched
     * @return Whether or not the two PhotographContainer objects names match
     */
    public boolean equals(Object o) {
        if (o instanceof PhotographContainer) {
            PhotographContainer other = (PhotographContainer) o;
            return other.name.equals(name);
        } else {
            return false;
        }
    }

    /**
     * A means to print out a PhotographContainer object. Returns a String.
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
     * Overrides default hashCode method in the Object class to produce a unique integer for a PhotographContainer.
     * 
     * @return hash code of the name field
     */
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Get photos from photos feed that have a rating greater than or equal to parameter rating. Returns an ArrayList.
     * 
     * @param rating The rating for photographs wanted
     * @return An ArrayList of photos with rating >= to parameter rating
     */
    public ArrayList<Photograph> getPhotos(int rating) {
        ArrayList<Photograph> temp = new ArrayList<>();
        if (rating <= 5 && rating >= 0) { // checks ratings format
            for (Photograph photo : photos) {
                if (photo.getRating() >= rating) {
                    temp.add(photo);
                }
            }
            return temp;
        } else {
            return null;
        }
    }

    /**
     * Get photos from photos feed that were taken in year provided. Returns an ArrayList.
     * 
     * @param year The year of the photos wanted
     * @return an ArrayList of photos from parameter year
     */
    public ArrayList<Photograph> getPhotosInYear(int year) {
        ArrayList<Photograph> temp = new ArrayList<>();
        if (String.valueOf(year).length() == 4) { // checks year format
            for (Photograph photo : photos) {
                if (photo.getYear() == year) {
                    temp.add(photo);
                }
            }
            return temp;
        } else {
            return null;
        }

    }

    /**
     * Get photos from photos feed that were taken in month and year provided. Returns an ArrayList.
     * 
     * @param month The month of the photos wanted
     * @param year  The year of the photos wanted
     * @return an ArrayList of photos from parameter month and year
     */
    public ArrayList<Photograph> getPhotosInMonth(int month, int year) {
        ArrayList<Photograph> temp = new ArrayList<>();
        if (month <= 12 && String.valueOf(year).length() == 4) { // checks year and month format
            for (Photograph photo : photos) {
                if (photo.getYear() == year && photo.getMonth() == month) {
                    temp.add(photo);
                }
            }
            return temp;
        } else {
            return null;
        }
    }

    /**
     * Get photos taken between two dates. Returns an ArrayList.
     * 
     * @param beginDate The lower bound for the dates to look between
     * @param endDate   The upper bound for the dates to look between
     * @return An ArrayList of photos between the two dates
     */
    public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {
        ArrayList<Photograph> temp = new ArrayList<>();
        if (Photograph.isThisDateValid(beginDate) && Photograph.isThisDateValid(endDate)) { // check if valid date
            if (beginDate.compareTo(endDate) <= 0 && endDate.compareTo(beginDate) >= 0) { // check beginDate is after endDate
                for (Photograph photo : photos) {
                    if (photo.getDateTaken().compareTo(beginDate) >= 0 && photo.getDateTaken().compareTo(endDate) <= 0) {
                        temp.add(photo);
                    }
                }
                return temp;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
