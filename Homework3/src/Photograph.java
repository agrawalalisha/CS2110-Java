
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Homework 3
 * 
 * @author Alisha Agrawal, aa3se
 */

public class Photograph implements Comparable<Photograph> {
    /**
     * The caption of the photograph; never changes
     */
    private String caption;

    /**
     * The filename of the photograph; never changes
     */
    private String filename;

    /**
     * The date the photograph was taken;YYYY-MM-DD
     */
    private String dateTaken;

    /**
     * The rating of the photograph on a scale form 0 to 5
     */
    private int rating;

    /**
     * Creates a Photograph object.
     * 
     * @param caption  The caption of the new Photograph
     * @param filename The filename of the new Photograph
     */
    public Photograph(String caption, String filename) {
        this.caption = caption;
        this.filename = filename;
        this.dateTaken = "1901-01-01";
        this.rating = 0;
    }

    /**
     * Creates a Photograph object.
     * 
     * @param caption   The caption of the new Photograph
     * @param filename  The filename of the new Photograph
     * @param dateTaken The date the new Photograph was taken
     * @param rating    The rating of the new Photograph
     */
    public Photograph(String caption, String filename, String dateTaken, int rating) {
        this.caption = caption;
        this.filename = filename;
        if (isThisDateValid(dateTaken)) {
            this.dateTaken = dateTaken;
        } else {
            this.dateTaken = "1901-01-01";
        }
        if (rating <= 5 && rating >= 0) {
            this.rating = rating;
        } else {
            this.rating = 0;
        }

    }

    /**
     * Checks if a Photograph object is equal to the current Photograph object. Returns true if the objects match.
     * 
     * @param o Photograph object to be matched
     * @return Whether or not the two objects match
     */
    public boolean equals(Object o) {
        if (o instanceof Photograph) {
            Photograph other = (Photograph) o;
            return other.filename.equals(filename) && other.caption.equals(caption);
        } else {
            return false;
        }
    }

    /**
     * A means to print out a Photograph object. Returns a String.
     * 
     * @return The values of the fields caption and filename
     */
    public String toString() {
        String s = "";
        s += "Filename: " + filename + "\n";
        s += "Caption: " + caption;
        return s;
    }

    /**
     * Get the caption of the Photograph. Returns a String.
     * 
     * @return The value of the caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Get the filename of the Photograph. Returns a String.
     * 
     * @return The value of the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Get the date taken of the Photograph. Returns a String.
     * 
     * @return The value of dateTaken
     */
    public String getDateTaken() {
        return dateTaken;
    }

    /**
     * Get the rating of the Photograph. Returns an int.
     * 
     * @return The value of rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Get the year of the Photograph. Returns an int.
     * 
     * @return the value of the year
     */
    public int getYear() {
        return Integer.valueOf(dateTaken.substring(0, 4));
    }

    /**
     * Get the month of the Photograph. Returns an int.
     * 
     * @return the value of the month
     */
    public int getMonth() {
        return Integer.valueOf(dateTaken.substring(5, 7));
    }

    /**
     * Get the day of the Photograph. Returns and int.
     * 
     * @return the value of the day
     */
    public int getDay() {
        return Integer.valueOf(dateTaken.substring(8));
    }

    /**
     * Sets a new rating for the Photograph.
     * 
     * @param rating The new rating of the Photograph
     */
    public void setRating(int rating) {
        if (rating <= 5 && rating >= 0) { // checks if rating format is correct
            this.rating = rating;
        } else {
            this.rating = 0;
        }
    }

    /**
     * Sets a new caption for the Photograph.
     * 
     * @param caption The new caption of the Photograph
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * Check if a date is in the YYYY-MM-DD format required. Returns true if the date is valid.
     * 
     * @param date The date to check
     * @return whether or not the date is valid
     */
    public static boolean isThisDateValid(String date) {
        try {
            // date is not null
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // sets preferred date format
            df.setLenient(false);
            df.parse(date); // create date object and parse the string into date
            return true;
        } catch (ParseException e) {
            // date format is invalid
            return false;
        }
    }

    /**
     * Overrides default hashCode method in the Object class to produce a unique integer for a Photograph.
     * 
     * @return hash code of the filename field
     */
    public int hashCode() {
        return filename.hashCode();
    }

    /**
     * Overrides the default compareTo method in the Object class
     * 
     * @param p The Photograph object to compare to
     * @return An int value of the comparison
     */
    @Override
    public int compareTo(Photograph p) {
        if (dateTaken.equals(p.getDateTaken())) {
            return caption.compareTo(p.getCaption());
        } else {
            return dateTaken.compareTo(p.getDateTaken());
        }
    }
}
