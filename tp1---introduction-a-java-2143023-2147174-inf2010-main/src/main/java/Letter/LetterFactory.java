package Letter;

import Point.Point2d;
import Shape.*;
import Shape.Rectangle;

import java.awt.*;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;


    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        Rectangle rightHorizontaleLine = new Rectangle(halfStripeThickness/4, halfMaxHeight);
        //
        //
        Rectangle leftHorizontalLine = new Rectangle(halfStripeThickness/3, halfMaxHeight);
        leftHorizontalLine.rotate(leftHorizontalLine.getCoords(), Math.toRadians(10));
        leftHorizontalLine.translate(leftHorizontalLine.getCoords(), new Point2d(stripeThickness*1.5, 0.0));
        //
        //
        Rectangle middleLine = new Rectangle(halfStripeThickness/4, halfMaxHeight/6);
        middleLine.rotate(middleLine.getCoords(), Math.toRadians(90));
        middleLine.translate(middleLine.getCoords(), new Point2d(stripeThickness,4.0));
        //
        //
        rightHorizontaleLine.rotate(rightHorizontaleLine.getCoords(),Math.toRadians(350));
        rightHorizontaleLine.add(leftHorizontalLine);
        rightHorizontaleLine.add(middleLine);
        //
        return rightHorizontaleLine;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        Rectangle verticalLine = new Rectangle(stripeThickness/2.25,halfMaxHeight);
        //
        //
        Circle upperCercle =  new Circle(maxHeight/4);
        upperCercle.translate(upperCercle.getCoords(), new Point2d((halfMaxWidth/2) +15, (halfMaxHeight/2)));
        //
        //
        Circle lowerCercle =  new Circle(maxHeight/4);
        lowerCercle.translate(lowerCercle.getCoords(), new Point2d((halfMaxWidth/2) + 15, (-halfMaxHeight/2)));
        //
        return verticalLine.add(lowerCercle).add(upperCercle);
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        Rectangle rectToRemove = new Rectangle(halfMaxWidth, 0.80*halfMaxWidth);
        rectToRemove.translate(rectToRemove.getCoords(), new Point2d(0.70*halfMaxWidth, 0.0));
        //
        //
        Ellipse firstEllipse = new Ellipse(2*stripeThickness, halfMaxHeight);
        Ellipse thirdEllipse = new Ellipse(1.75*stripeThickness, halfMaxHeight);
        Ellipse secondEllipse = new Ellipse(1.5*stripeThickness, halfMaxHeight);
        Ellipse fourthEllipse = new Ellipse(1.25*stripeThickness, halfMaxHeight);
        Ellipse fifthEllipse = new Ellipse(1.0*stripeThickness, halfMaxHeight);
        //
        return firstEllipse.add(secondEllipse).add(thirdEllipse).add(fourthEllipse).add(fifthEllipse).remove(rectToRemove);
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        Rectangle upperLine = new Rectangle(halfMaxWidth, halfStripeThickness);
        upperLine.rotate(upperLine.getCoords(), Math.toRadians(180));
        upperLine.translate(upperLine.getCoords(), new Point2d(stripeThickness + 6, -halfMaxHeight+9.0));
        //
        //
        Rectangle middleLine = new Rectangle(halfMaxWidth, halfStripeThickness);
        middleLine.rotate(middleLine.getCoords(), Math.toRadians(180));
        middleLine.translate(middleLine.getCoords(), new Point2d(stripeThickness + 6, 0.0));
        //
        //
        Rectangle lowerLine = new Rectangle(halfMaxWidth, halfStripeThickness);
        lowerLine.rotate(lowerLine.getCoords(), Math.toRadians(180));
        lowerLine.translate(lowerLine.getCoords(), new Point2d(stripeThickness + 6, halfMaxHeight-9.0));
        //
        return new Rectangle(halfStripeThickness,halfMaxHeight).add(upperLine).add(middleLine).add(lowerLine);
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        Rectangle leftLine = new Rectangle(stripeThickness/1.5, maxHeight/2);
        Rectangle middleLine = new Rectangle(maxWidth/1.5,stripeThickness/1.75);
        Rectangle rightLine = new Rectangle(stripeThickness/1.5, maxHeight/2);
        //
        //
        middleLine.translate(middleLine.getCoords(),new Point2d(halfMaxWidth,0.0));
        rightLine.translate(rightLine.getCoords(), new Point2d(maxWidth, 0.0));
        //
        return leftLine.add(middleLine).add(rightLine);
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        /** TODO
         * Create the letter N graphically
         * @return BaseShape containing the letter N
         */
        /** TODO
         * Create the letter N graphically
         * @return BaseShape containing the letter N
         */
        Rectangle leftBar = new Rectangle(halfStripeThickness,maxHeight/2);
        Rectangle middleBar = new Rectangle(halfStripeThickness,maxHeight/2);
        Rectangle rightBar = new Rectangle(halfStripeThickness,maxHeight/2);
        //
        //
        middleBar.rotate(middleBar.getCoords(),Math.toRadians(23));
        middleBar.translate(middleBar.getCoords(),new Point2d(halfMaxWidth+2 ,-halfStripeThickness+6));
        rightBar.translate(rightBar.getCoords(),new Point2d(maxWidth+3, 0.0));
        //
        return leftBar.add(middleBar).add(rightBar);
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        Ellipse ellipseFirst = new Ellipse(1.25*stripeThickness, 1.00*halfMaxHeight);
        Ellipse ellipseSecond = new Ellipse(1.45*stripeThickness, 1.00*halfMaxHeight);
        Ellipse ellipseThird = new Ellipse(1.65*stripeThickness, 1.00*halfMaxHeight);
        Ellipse ellipseFourth = new Ellipse(1.85*stripeThickness, 1.00*halfMaxHeight);
        Ellipse ellipseFifth = new Ellipse(2.05*stripeThickness, 1.00*halfMaxHeight);
        Ellipse ellipseSixth = new Ellipse(2.25*stripeThickness, 1.00*halfMaxHeight);
        //
        //
        return ellipseFirst.add(ellipseSecond).add(ellipseThird).add(ellipseFourth).add(ellipseFifth).add(ellipseSixth);
    }
}
