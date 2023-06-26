import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OnOffSwitch extends StandardLabel implements MouseListener {

    private boolean state = false;
    private boolean isActive = true;

    public OnOffSwitch(int x, int y, int width, int height,String text) {
        super(x,y,width,height);
        setText(text);
        setBackground(Color.BLACK);
        setForeground(Color.RED);
        setOpaque(true);
        addMouseListener(this);
    }

    boolean getState() {
        return state;
    }
    void setActive(boolean isActive) {this.isActive = isActive;}
    void switchState() {
        mouseClicked();
    }
    private void mouseClicked() {
        if(state) {
            state = false;
            setForeground(Color.RED);
        } else {
            state = true;
            setForeground(Color.GREEN);
        }
    }

    void mouseClicked2() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(isActive) {
            mouseClicked();
            mouseClicked2();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
