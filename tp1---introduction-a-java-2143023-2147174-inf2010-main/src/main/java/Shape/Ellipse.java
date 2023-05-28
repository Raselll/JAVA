package Shape;

import Point.Point2d;

import java.util.Collection;

public class Ellipse extends BaseShape {
    /** TODO
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        super();
        for (double angle = 0.0; angle <= 360; angle += 0.1) {
            this.add(new Point2d(widthDiameter * Math.cos(Math.toRadians(angle)),
                    heightDiameter * Math.sin(Math.toRadians(angle))
            ));
        }
    }

    /** TODO
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions) {
        super();
        for (double angle = 0.0; angle <= 360; angle += 0.1) {
            this.add(new Point2d(dimensions.X(),
                    dimensions.Y())
            );
        }
    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    private Ellipse(Collection<Point2d> coords) {

        super(coords);
    }

    /** TODO
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone() {

        return (Ellipse) super.clone();
    }
}
