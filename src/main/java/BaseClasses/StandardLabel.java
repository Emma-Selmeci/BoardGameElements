/**
 * Standard JLabel class, constructor with text and without text
 */

package BaseClasses;

import javax.swing.*;
import java.awt.*;

public class StandardLabel extends JLabel {

    public StandardLabel(int x, int y, int width, int height) {

        setBounds(x,y,width,height);
        setOpaque(true);
        setForeground(Color.WHITE);
        setBackground(Color.BLACK);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);

    }

    public StandardLabel(int x, int y, int width, int height, String text) {
        this(x,y,width,height);
        setText(text);

    }

    public void setBlank() {
        setOpaque(false);
        setForeground(Color.BLACK);
    }

    public String toString() {
        return getText();
    }

    //Does not repaint to save on processing
    public StandardLabel addTo(StandardPanel p) {
        p.add(this);
        return this;
    }
    //Does not repaint to save on processing
    public StandardLabel addTo(StandardFrame f) {
        f.add(this);
        return this;
    }

}
