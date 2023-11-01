/**
 * To easily add borders to StandardPanels
 */

package Graphics;

import BaseClasses.StandardPanel;

import java.awt.*;

public class PanelBorder extends StandardPanel {
    private Color selectedColor;
    private int width;
    private int height;

    public PanelBorder(StandardPanel parentPanel) {
        super(0,0,parentPanel.getWidth(), parentPanel.getHeight());
        width = parentPanel.getWidth()-1;
        height = parentPanel.getHeight()-1;
        selectedColor = Color.BLACK;
    }

    public void setColor(Color color) {
        selectedColor = color;
        repaint();
    }

    public void paint(Graphics gr) {

        Graphics2D g = (Graphics2D) gr;
        g.setColor(selectedColor);
        g.drawRect(0,0,width,height);

    }

}

