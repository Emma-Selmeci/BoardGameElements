package Controllers;

import BaseClasses.StandardLabel;
import BaseClasses.StandardPanel;
import Graphics.PanelBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StandardButton extends StandardPanel implements MouseListener {
    private VoidEffect effect;
    private PanelBorder border;
    private StandardLabel s;
    private boolean isOn = true;
    public StandardButton(int x, int y, int width, int height, String text) {
        super(x,y,width,height);
        add(s = new StandardLabel(0,0,width,height,text));
        s.setHorizontalAlignment(SwingConstants.CENTER);
        s.setVerticalAlignment(SwingConstants.CENTER);
        s.setForeground(Color.WHITE);
        s.setOpaque(false);

        addMouseListener(this);
        setOpaque(true);
        setBackground(Color.BLACK);

        add(border = new PanelBorder(this));
        border.setColor(Color.YELLOW);
    }
    public StandardButton(int x, int y, int width, int height, String text, VoidEffect effect) {
        this(x,y,width,height,text);

        this.effect = effect;
    }
    public void setOn(boolean isOn) {
        if(isOn) {
            this.isOn = true;
            border.setColor(Color.YELLOW);
            s.setForeground(Color.WHITE);
        } else {
            this.isOn = false;
            border.setColor(Color.GRAY);
            s.setForeground(Color.DARK_GRAY);
        }
    }

    public void setText(String text) {
        s.setText(text);
    }

    public void addEffect(VoidEffect effect) {
        this.effect = effect;
    }

    public boolean isOn() {return isOn;}

    private void effect() {
        effect.effect();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(isOn)border.setColor(Color.BLACK);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(isOn) {
            border.setColor(Color.GREEN);
            effect();
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(isOn)border.setColor(Color.GREEN);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(isOn)border.setColor(Color.YELLOW);
    }
}
