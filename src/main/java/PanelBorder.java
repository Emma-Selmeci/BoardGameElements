import java.awt.*;

public class PanelBorder extends StandardPanel {

    private int width;
    private int height;

    PanelBorder(StandardPanel parentPanel) {
        super(0,0,parentPanel.getWidth(), parentPanel.getHeight());
        width = parentPanel.getWidth()-1;
        height = parentPanel.getHeight()-1;
    }

    public void paint(Graphics gr) {

        Graphics2D g = (Graphics2D) gr;
        g.drawRect(0,0,width,height);

    }

}
