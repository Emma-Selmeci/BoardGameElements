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

    public static int getHexagonA(int hexagonWidth) {
        return (int) Math.round(hexagonWidth / Math.sqrt(3));
    }

}
