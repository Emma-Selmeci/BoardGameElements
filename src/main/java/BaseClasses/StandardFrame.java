/**
 * Nothing special, just a preset JFrame
 */

package BaseClasses;

import javax.swing.*;
import java.awt.*;

public class StandardFrame extends JFrame {

    public StandardFrame() {
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setResizable(false);
        this.setExtendedState(6);
        this.setUndecorated(true);
        this.getContentPane().setBackground(Color.GRAY);
        this.setVisible(true);
    }

    public StandardFrame(String windowTitle) {
        this();
        this.setTitle(windowTitle);
    }

    public void add(Component... components) {
        for(Component c : components) add(c);
        repaint();
    }

}
