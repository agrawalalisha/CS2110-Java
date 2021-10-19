import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Homework 3
 * 
 * @author Alisha Agrawal, aa3se
 * 
 * Sources: Big Java Book, Class Lecture Notes, ComparatorTester.java
 */
public class PhotoLibrary extends PhotographContainer {

    /**
     * Constant containing the PhotoLibrary's unique ID
     */
    private int id;

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
        super(name);
        this.name = name;
        this.id = id;
        photos = new ArrayList<Photograph>();
        albums = new HashSet<Album>();

    }

    /**
     * Removes a Photograph object if it is in the list of photos. Returns true if the Photograph has been removed from the
     * list of photos.
     * 
     * @param p The Photograph object to be removed
     * @return Whether or not the Photograph object has been removed from the list of photos
     */
    public boolean removePhoto(Photograph p) {
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
     * Get the unique ID of the PhotoLibrary. Returns an integer.
     * 
     * @return The value of the ID
     */
    public int getId() {
        return id;
    }

    /**
     * Get the set of albums in the PhotoLibrary. Returns a HashSet.
     * 
     * @return The set of albums
     */
    public HashSet<Album> getAlbums() {
        return albums;
    }

    public static void main(String[] args) {

        // PHOTOGRAPH OBJECTS
        Photograph flower = new Photograph("flower", "flower", "2020-06-26", 3);
        Photograph beach = new Photograph("beach", "beach", "2020-05-23", 1);
        Photograph friends = new Photograph("friends", "friends", "2020-06-12", 2);
        Photograph sunrise = new Photograph("sunrise", "sunrise", "2020-08-28", 4);
        Photograph selfie = new Photograph("selfie", "selfie", "2019-06-26", 4);

        // ARRAYLIST OF PHOTOGRAPH OBJECTS
        ArrayList<Photograph> list = new ArrayList<Photograph>();
        list.add(flower);
        list.add(beach);
        list.add(friends);
        list.add(sunrise);
        list.add(selfie);

        System.out.println("Original List:\n" + list);
        System.out.println("");

        // TEST COMPAREBYCAPTION()
        Collections.sort(list, new CompareByCaption());
        System.out.println("CompareByCaption " + list);
        System.out.println("");

        // TEST COMPAREBYRATING()
        Collections.sort(list, new CompareByRating());
        System.out.println("CompareByRating  " + list);

        /*
         * OUTPUT SHOULD BE [flower, beach, friends, sunrise, selfie] [beach, flower, friends, selfie, sunrise] [selife,
         * sunrise, flower, friends, beach]
         */
    }
}
