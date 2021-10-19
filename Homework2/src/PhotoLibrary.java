import java.util.ArrayList;
import java.util.HashSet;

/**
 * Homework 2
 * @author Alisha Agrawal, aa3se
 * 
 * Sources: 
 * Big Java Book, Class Lecture Notes
 */

public class PhotoLibrary {
    /**
     * Contains the PhotoLibrary's name
     */
    private String name;

    /**
     * Constant containing the PhotoLibrary's unique ID
     */
    private int id;

    /**
     * An ArrayList of Photograph objects the user has posted to their feed in this library
     */
    private ArrayList<Photograph> photos;

    /**
     * A HashSet of Album objects the user has created where each album will contain photos from this user's photo stream
     * that they have organized
     */
    private HashSet<Album> albums;

    /**
     * Creates a PhotoLibrary object.
     * 
     * @param name The name of the new PhotoLibrary
     * @param id   The unique id of the new PhotoLIbrary
     */
    public PhotoLibrary(String name, int id) {
        this.name = name;
        this.id = id;
        photos = new ArrayList<Photograph>();
        albums = new HashSet<Album>();

    }

    /**
     * Adds a Photograph object to the PhotoLibrary if it is not already in the list of photos. Returns true if the
     * Photograph is added.
     * 
     * @param p The Photograph object to be added
     * @return Whether or not the Photograph object has been added
     */
    public boolean addPhoto(Photograph p) {
        if (!hasPhoto(p)) { // check if Photograph is in the list of photos already
            photos.add(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a Photograph object is in the list of photos. Returns true if the Photograph is in the list of photos.
     * 
     * @param p The Photograph object to be checked
     * @return Whether or not the Photograph object is in the list of photos
     */
    public boolean hasPhoto(Photograph p) {
        if (photos.contains(p)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a Photograph object if it is in the list of photos. Returns true if the Photograph has been removed from the
     * list of photos.
     * 
     * @param p The Photograph object to be removed
     * @return Whether or not the Photograph object has been removed from the list of photos
     */
    public boolean erasePhoto(Photograph p) {
        if (hasPhoto(p)) { // check if Photograph is in the list of photos
            photos.remove(p);
            for (Album album : albums) {
                album.removePhoto(p);
            }
            return true;
        } else {
            return false;
        }
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
     * Checks if a PhotoLibrary object's ID is equal to the current PhotoLibrary object's ID. Returns true if the
     * PhotoLibrary objects IDs match.
     * 
     * @param o PhotoLibrary object to be matched
     * @return Whether or not the two PhotoLibrary objects IDs match
     */
    public boolean equals(Object o) {
        if (o instanceof PhotoLibrary) {
            PhotoLibrary other = (PhotoLibrary) o;
            return other.id == id;
        } else {
            return false;
        }
    }

    /**
     * A means to print out a PhotoLibrary object. Returns a String.
     * 
     * @return The values of the fields name and id and photos
     */
    public String toString() {
        String s = "";
        s += "Name: " + name + "\n";
        s += "ID: " + id + "\n";
        s += "Photos: " + photos;
        s += "Albums: " + albums;
        return s;
    }

    /**
     * Determines if two Photograph objects represent the same photograph from two PhotoLibrary objects. Returns an
     * ArrayList of Photograph objects.
     * 
     * @param a PhotoLibrary object to check
     * @param b PhotoLibrary object to check
     * @return An ArrayList of the photos that both PhotoLibrary a and PhotoLibrary b have in their list of photos
     */
    public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {
        ArrayList<Photograph> temp = new ArrayList<>();
        for (Photograph aPhoto : a.photos) {
            for (Photograph bPhoto : b.photos) {
                if (aPhoto.equals(bPhoto)) { // equals method from Photograph class
                    temp.add(aPhoto);
                }
            }
        }
        return temp;
    }

    /**
     * Calculates a measure for how similar two PhotoLibrary objects list of photos are. Returns a double between 0 and 1.
     * 
     * @param a PhotoLibrary object to check
     * @param b PhotoLibrary object to check
     * @return A measure of how similar the photo feeds are between two PhotoLibrary objects.
     */
    public static double similarity(PhotoLibrary a, PhotoLibrary b) {
        int commonPhotos = commonPhotos(a, b).size();
        if (commonPhotos == 0) {
            return 0.0;
        } else if (a.numPhotographs() > b.numPhotographs()) {
            double bPhotos = b.numPhotographs();
            return commonPhotos / bPhotos;
        } else { // handles <= case
            double aPhotos = a.numPhotographs();
            return commonPhotos / aPhotos;
        }
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

    /**
     * Creates a new Album with name albumName if an Album with that name doesn't exist in the set of Albums Returns true if
     * the add was successful.
     * 
     * @param albumName The name of the Album to be added
     * @return whether or not the Album was added to the set of Albums
     */
    public boolean createAlbum(String albumName) {
        Album newAlbum = new Album(albumName);
        return albums.add(newAlbum);
    }

    /**
     * Removes an Album with name albumName if an Album with that name exists in the set of Albums Returns true if the
     * removal was successful.
     * 
     * @param albumName The name of the Album to be removed
     * @return whether or not the Album was removed from the set of Albums
     */
    public boolean removeAlbum(String albumName) {
        Album remove = new Album(albumName);
        return albums.remove(remove);
    }

    /**
     * Adds a Photograph to the Album with albumName if it is the PhotoLibrary's list of Photos and not already in the album
     * Returns true if the Photograph is successfully added.
     * 
     * @param p         Photograph to be added
     * @param albumName Name of the album the Photograph is to be added to
     * @return whether or not the Photograph was added to the Album with name albumName
     */
    public boolean addPhotoToAlbum(Photograph p, String albumName) {
        try {
            if (photos.contains(p) && !getAlbumByName(albumName).hasPhoto(p)) {
                return getAlbumByName(albumName).addPhoto(p); // returns true
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }

    }

    /**
     * Removes a Photograph from the Album in the set of Albums that has name albumName. Returns true if the Photograph is
     * successfully removed.
     * 
     * @param p         The Photograph to be removed
     * @param albumName The name of the Album from which the Photograph is to be removed
     * @return whether or not the Photograph is successfully removed
     */
    public boolean removePhotoFromAlbum(Photograph p, String albumName) {
        try {
            if (getAlbumByName(albumName).hasPhoto(p)) {
                return getAlbumByName(albumName).removePhoto(p); // returns true
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }

    }

    /**
     * Get the Album with name albumName. Returns an Album.
     * 
     * @param albumName The name of the album
     * @return an Album with name albumName
     */
    private Album getAlbumByName(String albumName) {
        for (Album album : albums) {
            if (album.getName() == albumName) {
                return album;
            }
        }
        return null;

    }

    /**
     * Get the name of the PhotoLibrary. Returns a String.
     * 
     * @return The value of the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the PhotoLibrary.
     * 
     * @param name The updated name of the PhotoLibrary
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the unique ID of the PhotoLibrary. Returns an integer.
     * 
     * @return The value of the ID
     */
    public int getId() {
        return id;
    }

    /**
     * Get the list of photos in the PhotoLibrary. Returns an ArrayList.
     * 
     * @return The list of photos
     */
    public ArrayList<Photograph> getPhotos() {
        return photos;
    }

    /**
     * Get the set of albums in the PhotoLibrary. Returns a HashSet.
     * 
     * @return The set of albums
     */
    public HashSet<Album> getAlbums() {
        return albums;
    }
}
