import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
/**
 * Homework 2
 * @author Alisha Agrawal, aa3se
 * 
 */
public class PhotoLibraryTest {

    @Test
    public void testSimilarity() {
        /**
         * Does similarity() return a value when there are similar photos
         */

        // create two PhotoLibrary objects to compare
        PhotoLibrary one = new PhotoLibrary("one", 1);
        PhotoLibrary two = new PhotoLibrary("two", 2);

        // create Photograph objects to add to PhotoLibrarys
        Photograph flower = new Photograph("flower", "flower");
        Photograph beach = new Photograph("beach", "beach");
        Photograph friends = new Photograph("friends", "friends");
        Photograph sunset = new Photograph("sunset", "sunset");
        Photograph sunrise = new Photograph("sunrise", "sunrise");
        Photograph art = new Photograph("art", "art");
        Photograph selfie = new Photograph("selfie", "selfie");

        // add Photograph objects to PhotoLibrarys
        one.addPhoto(flower);
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);

        two.addPhoto(beach);
        two.addPhoto(sunset);
        two.addPhoto(friends);
        two.addPhoto(art);
        two.addPhoto(selfie);

        double expected = 0.6;
        double actual = PhotoLibrary.similarity(one, two);
        assertEquals("The similarity between PhotoLibrary one and two is not 0.6.", expected, actual, 0.0001);
    }

    @Test
    public void testSimilarity2() {
        /**
         * Does similarity() return a value other than 0.0 when there are no similar photos
         */

        // create two PhotoLibrary objects to compare
        PhotoLibrary one = new PhotoLibrary("one", 1);
        PhotoLibrary two = new PhotoLibrary("two", 2);

        // create Photograph objects to add to PhotoLibrarys
        Photograph beach = new Photograph("beach", "beach");
        Photograph friends = new Photograph("friends", "friends");
        Photograph sunset = new Photograph("sunset", "sunset");
        Photograph sunrise = new Photograph("sunrise", "sunrise");
        Photograph art = new Photograph("art", "art");
        Photograph selfie = new Photograph("selfie", "selfie");
        Photograph ootd = new Photograph("ootd", "ootd");
        Photograph mirror = new Photograph("mirror", "mirror");
        Photograph makeup = new Photograph("makeup", "makeup");
        Photograph concert = new Photograph("concert", "concert");

        // add Photograph objects to PhotoLibrarys
        one.addPhoto(sunrise);
        one.addPhoto(mirror);
        one.addPhoto(ootd);
        one.addPhoto(makeup);
        one.addPhoto(concert);

        two.addPhoto(beach);
        two.addPhoto(sunset);
        two.addPhoto(friends);
        two.addPhoto(art);
        two.addPhoto(selfie);

        double expected = 0.0;
        double actual = PhotoLibrary.similarity(one, two);
        assertEquals("The similarity between PhotoLibrary one and two is not 0.0.", expected, actual, 0.0001);
    }

    @Test
    public void testGetPhotos() {
        /**
         * Does getPhotos() return Photographs when the rating is in the list of photos
         */

        // create PhotoLibrary object to test
        PhotoLibrary one = new PhotoLibrary("one", 1);

        // create Photograph objects
        Photograph flower = new Photograph("flower", "flower", "2020-06-26", 3);
        Photograph beach = new Photograph("beach", "beach", "2020-06-26", 1);
        Photograph friends = new Photograph("friends", "friends", "2020-06-26", 2);
        Photograph sunrise = new Photograph("sunrise", "sunrise", "2020-06-26", 5);
        Photograph selfie = new Photograph("selfie", "selfie", "2020-06-26", 4);

        // add photograph objects to PhotoLibrary
        one.addPhoto(flower);
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);

        ArrayList<Photograph> expected = new ArrayList<>();
        expected.add(flower);
        expected.add(sunrise);
        expected.add(selfie);
        ArrayList<Photograph> actual = new ArrayList<>(one.getPhotos(3));
        assertEquals("There are not three photos with a rating of 3 or greater", expected, actual);
    }

    @Test
    public void testGetPhotos2() {
        /**
         * Does getPhotos() return Photographs when the rating is not in the list of photos
         */

        // create PhotoLibrary object to test
        PhotoLibrary one = new PhotoLibrary("one", 1);

        // create Photograph objects
        Photograph flower = new Photograph("flower", "flower", "2020-06-26", 3);
        Photograph beach = new Photograph("beach", "beach", "2020-06-26", 1);
        Photograph friends = new Photograph("friends", "friends", "2020-06-26", 2);
        Photograph sunrise = new Photograph("sunrise", "sunrise", "2020-06-26", 4);
        Photograph selfie = new Photograph("selfie", "selfie", "2020-06-26", 4);

        // add photograph objects to PhotoLibrary
        one.addPhoto(flower);
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);

        ArrayList<Photograph> expected = new ArrayList<>();
        ArrayList<Photograph> actual = new ArrayList<>(one.getPhotos(5));
        assertEquals("There are photos with a rating 5", expected, actual);
    }

    @Test
    public void testGetPhotosInMonth() {
        /**
         * Does getPhotosInMonth() return Photographs when there are Photographs in the given month and year
         */

        // create PhotoLibrary object to test
        PhotoLibrary one = new PhotoLibrary("one", 1);

        // create Photograph objects
        Photograph flower = new Photograph("flower", "flower", "2020-06-26", 3);
        Photograph beach = new Photograph("beach", "beach", "2020-05-23", 1);
        Photograph friends = new Photograph("friends", "friends", "2020-06-12", 2);
        Photograph sunrise = new Photograph("sunrise", "sunrise", "2020-08-28", 4);
        Photograph selfie = new Photograph("selfie", "selfie", "2019-06-26", 4);

        // add photograph objects to PhotoLibrary
        one.addPhoto(flower);
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);

        ArrayList<Photograph> expected = new ArrayList<>();
        expected.add(flower);
        expected.add(friends);
        ArrayList<Photograph> actual = new ArrayList<>(one.getPhotosInMonth(6, 2020));
        assertEquals("There are not two photos taken in June 2020", expected, actual);
    }

    @Test
    public void testGetPhotosInMonth2() {
        /**
         * Does getPhotosInMonth() return Photographs when none of the Photographs are in the given month and year
         */

        // create PhotoLibrary object to test
        PhotoLibrary one = new PhotoLibrary("one", 1);

        // create Photograph objects
        Photograph flower = new Photograph("flower", "flower", "2020-06-26", 3);
        Photograph beach = new Photograph("beach", "beach", "2020-05-23", 1);
        Photograph friends = new Photograph("friends", "friends", "2020-06-12", 2);
        Photograph sunrise = new Photograph("sunrise", "sunrise", "2020-08-28", 4);
        Photograph selfie = new Photograph("selfie", "selfie", "2019-06-26", 4);

        // add photograph objects to PhotoLibrary
        one.addPhoto(flower);
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);

        ArrayList<Photograph> expected = new ArrayList<>();
        ArrayList<Photograph> actual = new ArrayList<>(one.getPhotosInMonth(6, 2018));
        assertEquals("There are photos taken in June 2018", expected, actual);
    }

    @Test
    public void testGetPhotosBetween() {
        /**
         * Does getPhotosBetween() return Photographs when beginDate is before endDate
         */

        // create PhotoLibrary object to test
        PhotoLibrary one = new PhotoLibrary("one", 1);

        // create Photograph objects
        Photograph flower = new Photograph("flower", "flower", "2020-06-26", 3);
        Photograph beach = new Photograph("beach", "beach", "2020-05-23", 1);
        Photograph friends = new Photograph("friends", "friends", "2020-06-12", 2);
        Photograph sunrise = new Photograph("sunrise", "sunrise", "2020-08-28", 4);
        Photograph selfie = new Photograph("selfie", "selfie", "2019-06-26", 4);

        // add photograph objects to PhotoLibrary
        one.addPhoto(flower);
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);

        ArrayList<Photograph> expected = new ArrayList<>();
        expected.add(flower);
        expected.add(beach);
        expected.add(friends);
        expected.add(selfie);
        ArrayList<Photograph> actual = new ArrayList<>(one.getPhotosBetween("2019-05-02", "2020-06-26"));
        assertEquals("There are not four photos taken between May 2, 2019 and June 26, 2020", expected, actual);
    }

    @Test
    public void testGetPhotosBetween2() {
        /**
         * Does getPhotosBetween() return Photographs when beginDate is after endDate
         */

        // create PhotoLibrary object to test
        PhotoLibrary one = new PhotoLibrary("one", 1);

        // create Photograph objects
        Photograph flower = new Photograph("flower", "flower", "2020-06-26", 3);
        Photograph beach = new Photograph("beach", "beach", "2020-05-23", 1);
        Photograph friends = new Photograph("friends", "friends", "2020-06-12", 2);
        Photograph sunrise = new Photograph("sunrise", "sunrise", "2020-08-28", 4);
        Photograph selfie = new Photograph("selfie", "selfie", "2019-06-26", 4);

        // add photograph objects to PhotoLibrary
        one.addPhoto(flower);
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);

        ArrayList<Photograph> expected = new ArrayList<>();
        ArrayList<Photograph> actual = new ArrayList<>(one.getPhotosBetween("2020-12-02", "2020-12-26"));
        assertEquals("There are photos taken between December 2-26 in 2020", expected, actual);
    }

    @Test
    public void testErasePhoto() {
        /**
         * Does erasePhoto() erase a Photograph object that is in the list of Photograph objects and in an Album
         */

        // create PhotoLibrary object to test
        PhotoLibrary one = new PhotoLibrary("one", 1);

        // create Album object
        one.createAlbum("temp");

        // create Photograph objects
        Photograph flower = new Photograph("flower", "flower", "2020-06-26", 3);
        Photograph beach = new Photograph("beach", "beach", "2020-05-23", 1);
        Photograph friends = new Photograph("friends", "friends", "2020-06-12", 2);
        Photograph sunrise = new Photograph("sunrise", "sunrise", "2020-08-28", 4);
        Photograph selfie = new Photograph("selfie", "selfie", "2019-06-26", 4);

        // add photograph objects to PhotoLibrary
        one.addPhoto(flower);
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);

        // add photograph objects to Album
        one.addPhotoToAlbum(flower, "temp");
        one.addPhotoToAlbum(beach, "temp");
        one.addPhotoToAlbum(friends, "temp");

        boolean expected = true;
        boolean actual = one.erasePhoto(flower);
        assertEquals("The photo flower was not removed from the PhotoLibrary and Album", expected, actual);
    }

    @Test
    public void testErasePhoto2() {
        /**
         * Does erasePhoto() erase a Photograph object that is not in the list of Photograph objects
         */

        // create PhotoLibrary object to test
        PhotoLibrary one = new PhotoLibrary("one", 1);

        // create Album object
        one.createAlbum("temp");

        // create Photograph objects
        Photograph flower = new Photograph("flower", "flower", "2020-06-26", 3);
        Photograph beach = new Photograph("beach", "beach", "2020-05-23", 1);
        Photograph friends = new Photograph("friends", "friends", "2020-06-12", 2);
        Photograph sunrise = new Photograph("sunrise", "sunrise", "2020-08-28", 4);
        Photograph selfie = new Photograph("selfie", "selfie", "2019-06-26", 4);

        // add photograph objects to PhotoLibrary
        one.addPhoto(beach);
        one.addPhoto(friends);
        one.addPhoto(sunrise);
        one.addPhoto(selfie);

        // add photograph objects to Album
        one.addPhotoToAlbum(beach, "temp");
        one.addPhotoToAlbum(friends, "temp");

        boolean expected = false;
        boolean actual = one.erasePhoto(flower);
        assertEquals("There is a Photograph that was removed from the PhotoLibrary", expected, actual);
    }

}
