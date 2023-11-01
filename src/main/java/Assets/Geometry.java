/**
 * Geometry class helps with geometrical thingies
 * Coordinate-geometry methods in here are designed to work with the java Swing  library in mind. The X axis runs from left to right but the Y axis runs from top to bottom, contrary to regular geometry
 * Most methods approximate and truncate the remainder. If this causes precision-errors, methods should be revised to return int
 * getHexagon() returns the coordinates of a Hexagon of given size at given coordinates (from top-left coordinate)
 * angleOf() return an int value from 0 to 359, showing the angle of the op line to the vertical (0 degrees is straight down, 180 is straight up)
 */

package Assets;

import java.awt.*;

public class Geometry {

    public static Point[] getHexagon(Point coordinates, int width) { //This method return the coordinates of a Hexagon - the hexagon stands on a point
        double a = width / Math.sqrt(3);
        Point[] toReturn = new Point[6];

        toReturn[0] = new Point(coordinates.x+width/2,coordinates.y); //Top point
        toReturn[1] = new Point(coordinates.x+width,(int) Math.round(coordinates.y+a/2)); //Top right point
        toReturn[2] = new Point(coordinates.x+width,(int) Math.round(coordinates.y+a*1.5)); //Bottom right
        toReturn[3] = new Point(coordinates.x+width/2,(int )Math.round(coordinates.y+2*a)); //Bottom
        toReturn[4] = new Point(coordinates.x,(int) Math.round(coordinates.y+a*1.5)); //Bottom left
        toReturn[5] = new Point(coordinates.x,(int) Math.round(coordinates.y+a/2)); //Top left

        return toReturn;
    }
    public static int distance(Point p1, Point p2) {
        int a = Math.abs(p1.x-p2.x);
        int b = Math.abs(p1.y-p2.y);
        return (int) Math.sqrt(a*a+b*b);
    }
    public static int getHexagonA(int hexagonWidth) {
        return (int) Math.round(hexagonWidth / Math.sqrt(3));
    }
    public static int angleOf(Point o, Point p) {
        double c = Geometry.distance(p,o);
        int degree = (int) Math.toDegrees(Math.asin((p.x-o.x)/(c)));
        if(p.y > o.y) {
            if(degree < 0) {
                return 360-Math.abs(degree);
            } else {
                return degree;
            }
        } else {
            if(degree > 0) {
                return 180-degree;
            } else {
                return 180 + Math.abs(degree);
            }
        }
    }
    public static int distFromLine(Point o, int angle, Point p) {
        return (int) Math.abs(((Math.cos(Math.toRadians(angle)))*(o.y-p.y) + (Math.sin(Math.toRadians(angle))*(o.x-p.x))));
    }
    public static int distFromLineAbsolute(Point o, int angle, Point p) {
        if(angleOf(o,p) < angle + 180) {
            return distFromLine(o,angle,p);
        } else {
            return -distFromLine(o,angle,p);
        }
    }
    public static Point distInAngle(Point o, int angle, int distance) {
        return new Point((int) (o.x + Math.sin(Math.toRadians(angle))*distance),(int) (o.y + Math.cos(Math.toRadians(angle))*distance));
    }
    /*
     * This method will be used to calculate the difference of two angles
     * I not yet know if it will calculate 0 and 359 to have 1 degree of difference or not :(
     */
    public static int angleDifference(int angle1, int angle2) {
        return -1;
    }
    public static void main(String[] args) {
    }

}

