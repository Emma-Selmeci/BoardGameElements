import java.awt.*;

class StandardTextField extends TextField {

    public StandardTextField(int x, int y, int width, int height) {

        setBounds(x,y,width,height);

    }

    public StandardTextField(int x, int y, int width, int height, String text) {

        this(x,y,width,height);
        setText(text);

    }

}