package Controllers;

import Abstractions.SwitchableBoolean;
import BaseClasses.StandardLabel;
import BaseClasses.StandardPanel;
import Graphics.PanelBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OnOffSwitch extends StandardPanel implements MouseListener {

    private BoolEffect effect;
    private PanelBorder border;
    private StandardLabel s;
    private boolean isOn = true;
    private SwitchableBoolean value;

    public OnOffSwitch(int x, int y, int width, int height, String text, boolean initialValue, BoolEffect effect) {
        super(x,y,width,height);

        this.value = new SwitchableBoolean(initialValue);
        this.effect = effect;

        add(s = new StandardLabel(0,0,width,height,text));
        s.setHorizontalAlignment(SwingConstants.CENTER);
        s.setVerticalAlignment(SwingConstants.CENTER);
        s.setOpaque(false);
        setLabelColor();

        addMouseListener(this);
        setOpaque(true);
        setBackground(Color.BLACK);

        add(border = new PanelBorder(this));
        border.setColor(Color.YELLOW);
    }

    private void setLabelColor() {
        if(isOn) {
            if(value.getValue()) {
                s.setForeground(Color.GREEN);
            } else {
                s.setForeground(Color.RED);
            }
        } else {
            if(value.getValue()) {
                s.setForeground(new Color(120,255,70));
            } else {
                s.setForeground(new Color(255,120,120));
            }
        }
    }

    public void setOn(boolean isOn) {
        if(isOn) {
            this.isOn = true;
            border.setColor(Color.YELLOW);
        } else {
            this.isOn = false;
            border.setColor(Color.GRAY);
        }
        setLabelColor();
    }
    public void setValue(boolean isOn) {
        value.setValue(isOn);
        setLabelColor();
    }
    public void switchState() {
        value.switchState();
        setLabelColor();
    }

    public boolean isOn() {return isOn;}
    public boolean getValue() {return value.getValue();}
    private void effect() {
        effect.effect(value.getValue());
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
            switchState();
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
