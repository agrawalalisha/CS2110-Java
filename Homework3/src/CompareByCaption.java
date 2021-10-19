import java.util.Comparator;

/**
 * Homework 3
 * 
 * @author Alisha Agrawal, aa3se
 * 
 * Sources: StudentScoreComparator
 */

public class CompareByCaption implements Comparator<Photograph> {
    /**
     * Compares two Photographs by caption in alphabetical order. If two captions are identical, then compare by rating
     * (descending order)
     */
    @Override
    public int compare(Photograph o1, Photograph o2) {
        if (o1.getCaption().equals(o2.getCaption())) {
            return o2.getRating() - o1.getRating();
        } else {
            return o1.getCaption().compareTo(o2.getCaption());
        }
    }

}
