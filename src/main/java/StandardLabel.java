import javax.swing.*;

class StandardLabel extends JLabel {

    public StandardLabel(int x, int y, int width, int height) {

        setBounds(x,y,width,height);
        setOpaque(false);

    }

    public StandardLabel(int x, int y, int width, int height, String text) {
        this(x,y,width,height);
        setText(text);

    }

}
