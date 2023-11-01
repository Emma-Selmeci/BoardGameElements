/**
 Standard textField to get input from user
 */


package BaseClasses;

import java.awt.*;

public class StandardTextField extends TextField {

    public StandardTextField(int x, int y, int width, int height) {

        setBounds(x,y,width,height);

    }

    public StandardTextField(int x, int y, int width, int height, String text) {

        this(x,y,width,height);
        setText(text);

    }

    public String toString() {
        return getText();
    }

    //Does not repaint to save on processing
    public void addTo(StandardPanel p) {
        p.add(this);
    }
    //Does not repaint to save on processing
    public void addTo(StandardFrame f) {
        f.add(this);
    }

}