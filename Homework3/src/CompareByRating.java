import java.util.Comparator;

/**
 * Homework 3
 * 
 * @author Alisha Agrawal, aa3se
 * 
 * Sources: StudentScoreComparator
 */

public class CompareByRating implements Comparator<Photograph> {
    /**
     * Compares two Photographs by rating (descending order). If two ratings are identical, then compare by caption in
     * alphabetical order.
     */
    @Override
    public int compare(Photograph o1, Photograph o2) {
        if (o1.getRating() == o2.getRating()) {
            return o1.getCaption().compareTo(o2.getCaption());
        } else {
            return o2.getRating() - o1.getRating();
        }
    }

}
