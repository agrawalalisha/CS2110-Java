/**
 * Homework 1 
 * Alisha Agrawal, aa3se 
 * 
 * Sources: Big Java Book, PezDispenser Example
 */

import java.util.ArrayList;

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
     * Creates a PhotoLibrary object.
     * 
     * @param name The name of the new PhotoLibrary
     * @param id   The unique id of the new PhotoLIbrary
     */
    public PhotoLibrary(String name, int id) {
        this.name = name;
        this.id = id;
        photos = new ArrayList<Photograph>();

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

    public static void main(String[] args) {

        // PHOTOLIBRARY OBJECTS
        PhotoLibrary one = new PhotoLibrary("one", 1);
        PhotoLibrary two = new PhotoLibrary("two", 2);
        PhotoLibrary three = new PhotoLibrary("three", 3);
        PhotoLibrary four = new PhotoLibrary("four", 1);

        // PHOTOGRAPH OBJECTS
        Photograph flower = new Photograph("tulips", "flower");
        Photograph beach = new Photograph("nothing like a nice breeze", "beach");
        Photograph ocean = new Photograph("wavy", "ocean");
        Photograph pasta = new Photograph("yummy alfredo", "pasta");
        Photograph friends = new Photograph("i love them", "friends");
        Photograph sunset = new Photograph("so pretty", "sunset");
        Photograph sunrise = new Photograph("never thought i would be up to see this view", "sunrise");
        Photograph art = new Photograph("vangogogo", "art");
        Photograph quote = new Photograph("what needed to be said", "quote");
        Photograph music = new Photograph("never disappoints", "music");
        Photograph selfie = new Photograph("felt kewt might delete later", "selfie");
        Photograph portrait = new Photograph("a picture of me", "portrait");
        Photograph car = new Photograph("a new edition to the family", "car");
        Photograph ootd = new Photograph("im not into fashion", "ootd");
        Photograph mirror = new Photograph("mirror mirror on the wall...", "mirror");
        Photograph makeup = new Photograph("i am broke", "makeup");
        Photograph resturant = new Photograph("i missed this place", "resturant");
        Photograph dance = new Photograph("i cant dance", "dance");
        Photograph singer = new Photograph("i love their music", "singer");
        Photograph concert = new Photograph("i miss going to concerts", "concert");

        // ADD AND REMOVE PHOTOGRAPH OBJECTS IN PHOTOLIBRARYS
        one.addPhoto(flower);
        one.addPhoto(flower); // check if it adds the same photo twice
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);
        one.addPhoto(mirror);
        one.addPhoto(ootd);
        one.addPhoto(dance);
        one.addPhoto(concert);

        one.erasePhoto(beach); // total number of Photograph Objects in PhotoLibrary one = 8

        two.addPhoto(beach);
        two.addPhoto(sunset);
        two.addPhoto(friends);
        two.addPhoto(art);
        two.addPhoto(selfie);
        two.addPhoto(music);
        two.addPhoto(car);
        two.addPhoto(portrait);

        two.erasePhoto(car); // total number of Photograph Objects in PhotoLibrary two = 7

        three.addPhoto(quote);
        three.addPhoto(sunset);
        three.addPhoto(portrait);
        three.addPhoto(ocean);
        three.addPhoto(car);
        three.addPhoto(makeup);
        three.addPhoto(resturant);
        three.addPhoto(singer);
        three.addPhoto(pasta); // total number of Photograph Objects in PhotoLibrary three = 9

        // PHOTOGRAPH TOSTRING()
        System.out.println(flower.toString());
        System.out.println(beach.toString());

        // PHOTOGRAPH EQUALS()
        System.out.println("\n");
        System.out.println(flower.equals(concert)); // false
        System.out.println(flower.equals(flower)); // true

        // PHOTOLIBRARY TOSTRING()
        System.out.println("\n");
        System.out.println(one.toString());
        System.out.println(two.toString());

        // PHOTOLIBRARY EQUALS()
        System.out.println("\n");
        System.out.println(one.equals(two)); // false
        System.out.println(two.equals(two)); // true
        System.out.println(one.equals(four)); // true

        // CHECK IF PHOTOLIBRARY HAS PHOTOGRAPH OBJECT
        System.out.println("\n");
        System.out.println(one.hasPhoto(flower)); // true
        System.out.println(one.hasPhoto(beach)); // false
        System.out.println(two.hasPhoto(selfie)); // true
        System.out.println(two.hasPhoto(friends)); // true

        // # OF PHOTOGRAPH OBJECTS IN PHOTOLIBRARY
        System.out.println("\n");
        System.out.println(one.numPhotographs()); // 8
        System.out.println(two.numPhotographs()); // 7
        System.out.println(three.numPhotographs()); // 9

        // LIST OF PHOTOGRAPH OBJECTS IN COMMON B/N TWO PHOTOLIBRARIES
        System.out.println("\n");
        System.out.println(commonPhotos(one, two)); // friends, selfie
        System.out.println("\n");
        System.out.println(commonPhotos(one, three)); // []
        System.out.println("\n");
        System.out.println(commonPhotos(two, three)); // sunset, portrait

        // MEASURE OF PHOTOGRAPH OBJECTS IN COMMON B/N TWO PHOTOLIBRARIES
        System.out.println("\n");
        System.out.println(similarity(one, two)); // 2 / 7.0
        System.out.println("\n");
        System.out.println(similarity(one, three)); // 0.0
        System.out.println("\n");
        System.out.println(similarity(two, three)); // 2 / 7.0

    }

}
