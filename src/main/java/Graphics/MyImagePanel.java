/**
 * Prototype class for future dynamic graphics system
 */

package Graphics;

import BaseClasses.StandardPanel;

import java.awt.*;

public class MyImagePanel extends StandardPanel {
    MyImage image;
    float ratio;
    int width;
    int height;

    MyImagePanel(int x, int y, MyImage image) {
        super(x,y,image.width,image.height);
        this.image = image;
    }

    void newSize(int x, int y, float newSize) {
        this.width = (int) (image.width*newSize+1);
        this.height = (int) (image.height*newSize+1);
        ratio = newSize;
        setBounds(x,y,width,height);
        repaint();
    }

    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        byte currentColor = -1;
        byte currentPixel;

        float xCount = 0f;
        float yCount = 0f;

        int currentPixelX1;
        int currentPixelY1;
        int currentPixelX2;
        int currentPixelY2;

        for(int i = 0; i < image.width; i++) {
            currentPixelY1 = (int) yCount;
            currentPixelY2 = (int) (yCount + ratio);
            xCount = 0f;

            for (int j = 0; j < image.height; j++) {

                currentPixelX1 = (int) xCount;
                currentPixelX2 = (int) (xCount + ratio);

                if(currentColor != image.pixelMatrix[j][i]) {
                    currentPixel = image.pixelMatrix[j][i];
                    if(currentPixel == 0)  g.setColor(image.backGroundColor); else g.setColor(image.getColor(currentPixel));
                }
                for(int k = currentPixelY1; k < currentPixelY2; k++) {
                    g.drawLine(currentPixelX1,k,currentPixelX2,k);
                }

                xCount+=ratio;
            }
            yCount+=ratio;
        }
    }

}
