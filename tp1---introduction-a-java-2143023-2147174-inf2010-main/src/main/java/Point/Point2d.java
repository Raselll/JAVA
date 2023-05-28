package Point;

import java.awt.*;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    /**
     * TODO
     * 2D Point Constructor from coordinates
     *
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point2d(Double x, Double y) {
        super(new double[]{x, y});
    }

    /**
     * TODO
     * 2D Point Constructor from vector
     *
     * @param vector Vector containing X and Y coordinates
     */
    public Point2d(Double[] vector) {
        this(vector[0], vector[1]);
    }

    /**
     * @return X coordinate
     */
    public double X() {

        return this.vector[X];
    }

    /**
     * @return Y coordinate
     */
    public double Y() {

        return this.vector[Y];
    }

    /**
     * TODO
     * Translate the point by the given vector
     *
     * @param translateVector The vector by which to translate
     * @return Translated point
     */
    @Override
    public Point2d translate(Double[] translateVector) {
        PointOperator.translate(this.vector, translateVector);

        return this;
    }

    /**
     * TODO
     * Translate the point by the given 2D Point
     *
     * @param translateVector The 2D Point by which to translate
     * @return Translated point
     */
    public Point2d translate(Point2d translateVector) {
        translate(translateVector.vector);

        return this;
    }

    /**
     * TODO
     * Rotate the point by the given rotation Matrix
     *
     * @param rotationMatrix Matrix by which to rotate
     * @return Rotated point
     */
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        PointOperator.rotate(this.vector, rotationMatrix);

        return this;
    }

    /**
     * TODO
     * Rotate the point by the given angle
     *
     * @param angle Angle in radians
     * @return Rotated point
     */
    public Point2d rotate(Double angle) {
        // Inspired by : https://stackoverflow.com/questions/53519156/rotate-a-point-at-a-given-angle
        Point2d PD2 = new Point2d(this.vector);
        this.vector[X] = Math.cos(angle) * PD2.vector[X] - Math.sin(angle) * PD2.vector[Y];
        this.vector[Y] = Math.sin(angle) * PD2.vector[X] - Math.cos(angle) * PD2.vector[Y];

        return this;
    }

    /**
     * TODO
     * Divide the X and Y coordinates of a 2D point by a scalar
     *
     * @param divider Scalar used to divide
     * @return Divided point
     */
    @Override
    public Point2d divide(Double divider) {
        this.vector[X] = vector[X] / divider;
        this.vector[Y] = vector[Y] / divider;

        return this;
    }

    /**
     * TODO
     * Multiply the X and Y coordinates of a 2D point by a scalar
     *
     * @param multiplier Scalar used to multiply
     * @return Multiplied point
     */
    @Override
    public Point2d multiply(Double multiplier) {
        this.vector[X] = vector[X] * multiplier;
        this.vector[Y] = vector[Y] * multiplier;

        return this;
    }

    /**
     * TODO
     * Add a scalar to the X and Y coordinates of a 2D point
     *
     * @param adder Scalar to add
     * @return Added point
     */
    @Override
    public Point2d add(Double adder) {
        this.vector[X] = vector[X] + adder;
        this.vector[Y] = vector[Y] + adder;

        return this;
    }

    /**
     * TODO
     *
     * @return Deep copy of the 2D point
     */
    @Override
    public Point2d clone() {
        Point2d point2d = new Point2d(this.vector);

        return point2d;
    }
}
