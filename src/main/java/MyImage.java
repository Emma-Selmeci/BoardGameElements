import java.awt.Color;

public class MyImage {
    final int width;
    final int height;
    final Color backGroundColor;
    Color[] colorList = new Color[0]; //0 represents background color, the rest is taken from colorList starting with 1
    byte[][] pixelMatrix;


    public MyImage(int width, int height, Color backGroundColor) {
        this.width = width;
        this.height = height;
        this.backGroundColor = backGroundColor;
        pixelMatrix = new byte[width][height];
    }

    void addColor(Color newColor) {
        Color[] newColorList = new Color[colorList.length+1];
        ArrayOperations.addToArray(colorList,newColor,newColorList);
        colorList = newColorList;
    }

    void placePixel(int x, int y, int colorNumber) {
        pixelMatrix[x][y] = (byte) (colorNumber+1);
    }

    Color getColor(int colorNumber) {
        return colorList[colorNumber-1];
    }

}
