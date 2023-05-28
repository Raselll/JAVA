package Interface;

import Point.Point2d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Transform implements Rotate, Translate{
    /** TODO
     * Rotate all points of collections given in parameters
     * with the angle given
     * @param coords collections of Point2d
     * @param angle
     * @return rotated collection
     * */
    public Collection<Point2d> rotate(Collection<Point2d> coords, Double angle) {
        // Inspired by : https://knowm.org/iterating-through-a-collection-in-java/#:~:text=There%20are%20three%20common%20ways,easy%20to%20read%20and%20write.
        // Also Inspired by the course book p.92 (Figure 3.36)
        Collection<Point2d> rotationCollection = new ArrayList<>();
        Iterator<Point2d> itr = coords.iterator();
        while (itr.hasNext()) {
            rotationCollection.add(itr.next().rotate(angle));
        }
        return rotationCollection;
    }

    // Inspired by : https://knowm.org/iterating-through-a-collection-in-java/#:~:text=There%20are%20three%20common%20ways,easy%20to%20read%20and%20write.
    // Also Inspired by the course book p.92 (Figure 3.36)

    /** TODO
     * Translate all points of a collection by a given vector
     * @param coords Collection of Point2d
     * @param translateVector Vector of translation
     * @return translated coords
     * */
    public Collection<Point2d> translate(Collection<Point2d> coords, Point2d translateVector) {
        // Inspired by : https://knowm.org/iterating-through-a-collection-in-java/#:~:text=There%20are%20three%20common%20ways,easy%20to%20read%20and%20write.
        // Also Inspired by the course book p.92 (Figure 3.36)
        Collection<Point2d> translateCollection = new ArrayList<>();
        Iterator<Point2d> itr = coords.iterator();
        while (itr.hasNext()) {
            translateCollection.add(itr.next().translate(translateVector));
        }
        return translateCollection;
    }
}

