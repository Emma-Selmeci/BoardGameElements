import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimpleSwitch extends StandardLabel implements MouseListener {

    private SwitchableBoolean isOn = new SwitchableBoolean(true);
    SimpleSwitch(int x, int y, int width, int height, String text) {
        super(x,y,width,height,text);
        addMouseListener(this);
    }

    public void onOff() {
        isOn.switchState();
    }

    public void update() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        update();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
