/**
 * Yet another standard class for JPanel - default constructor creates a window-sized Panel
 */

package BaseClasses;

import Graphics.PanelBorder;

import javax.swing.*;
import java.awt.*;

public class StandardPanel extends JPanel {

    public StandardPanel(int x, int y, int width, int height) {

        setBounds(x,y,width,height);
        setLayout(null);
        setOpaque(false);

    }

    public StandardPanel() {

        setBounds(0,0,1366,768);
        setLayout(null);
        setOpaque(false);

    }

    public StandardPanel addBorder() {
        add(new PanelBorder(this));
        repaint();
        return this;
    }

    public void add(Component... components) {
        for(Component c : components) add(c);
        repaint();
    }

    public StandardPanel addTo(StandardFrame f) {
        f.add(this);
        return(this);
    }

    public StandardPanel addTo(StandardPanel p) {
        p.add(this);
        return(this);
    }

}
