import javax.swing.*;

class StandardPanel extends JPanel {

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

}
