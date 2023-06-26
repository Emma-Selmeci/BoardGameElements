import javax.swing.*;
import java.awt.*;

class StandardFrame extends JFrame {

    StandardFrame(String windowTitle) {
        this.setTitle(windowTitle);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setResizable(false);
        this.setExtendedState(6);
        this.setUndecorated(true);
        this.getContentPane().setBackground(Color.GRAY);
        this.setVisible(true);
    }

}
