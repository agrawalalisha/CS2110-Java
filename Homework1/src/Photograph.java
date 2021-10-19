/**
 * Homework 1 
 * Alisha Agrawal, aa3se 
 * 
 * Sources: Big Java Book, PezDispenser Example
 */

public class Photograph {

    /**
     * The caption of the photograph; never changes
     */
    private String caption;

    /**
     * The filename of the photograph; never changes
     */
    private String filename;

    /**
     * Creates a Photograph object.
     * 
     * @param cap  The caption of the new Photograph
     * @param file The filename of the new Photograph
     */
    public Photograph(String cap, String file) {
        caption = cap;
        filename = file;
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
    public String getFileName() {
        return filename;
    }

}
