/**
 * MouseListener and Graphics2D works fine together on different layers
 *
 */

import Abstractions.MinMaxInt;
import BaseClasses.StandardLabel;
import BaseClasses.StandardPanel;
import BaseClasses.StandardFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {
        new FinallyWorksFrame();
    }

}

class FinallyWorksFrame extends StandardFrame {

    StandardLabel mousePosLabel;
    StandardLabel inCoordLabel;
    StandardLabel incLabel;
    int minx = 200,maxx=500,miny=200,maxy=400;
    MinMaxInt incCounter = new MinMaxInt(0,0,(maxx-minx)+(maxy-miny),false);
    ButtonPanel panel;

    FinallyWorksFrame() {
        add(mousePosLabel = new StandardLabel(0,0,200,20));
        add(inCoordLabel = new StandardLabel(0,20,200,20));
        add(incLabel = new StandardLabel(0,40,200,20));
        add(panel = new ButtonPanel());
        add(new StandardLabel(minx,miny,maxx-minx,maxy-miny,"HOVER HERE TO ACTIVATE A COOL ANIMATION"));
        Thread t = new Thread(new MouseFlow());
        t.run();
    }

    private void mousePosHandler(Point p) {
        mousePosLabel.setText(p.toString());
        if(p.x > minx && p.x <maxx && p.y < maxy && p.y > miny) {
            inCoordLabel.setText("TRUE");
            incCounter.addValue(10);
            incLabel.setText(String.valueOf(incCounter));
        } else {
            inCoordLabel.setText("FALSE");
            incCounter.addValue(-10);
            incLabel.setText(String.valueOf(incCounter));
        }
        panel.repaint();
    }

    class MouseFlow implements Runnable {

        @Override
        public void run() {
            for(;;) {
                mousePosHandler(MouseInfo.getPointerInfo().getLocation());
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class ButtonPanel extends StandardPanel {
        private int width;
        private int height;
        ButtonPanel() {
            super(minx,miny,maxx-minx,maxy-miny);

            width = maxx-minx;
            height = maxy-miny;
        }

        public void paint(Graphics gr) {
            Graphics2D g = (Graphics2D) gr;
            int inc = incCounter.getValue();
            g.setColor(Color.YELLOW);
            if(inc >= width) {
                g.drawLine(0,0,width,0);
                g.drawLine(width-1,0,width-1,inc-width);
            } else {
                g.drawLine(0,0,inc,0);
            }
            if(inc>= height) {
                g.drawLine(0,0,0,height);
                g.drawLine(0,height-1,inc-height,height-1);
            } else {
                g.drawLine(0,0,0,inc);
            }
        }

    }

}

class CoolButton extends StandardPanel {
    private boolean isRunning;
    private Thread t1;
    private Thread t2;
    private int i = 0;
    private boolean inThere = false;
    private GraphicsPanel gPanel;

    public CoolButton(int x, int y, int width, int height, StandardLabel l) {
        super(x, y, width, height);
        //this.l = l;
        add(new ListenerPanel(width, height));
        add(gPanel = new GraphicsPanel(width,height));
        t2 = new Thread(gPanel);

    }

    private void mouseEnteredOuter() {
        initialize();
        inThere = true;
    }

    private void mouseExitedOuter() {
        inThere = false;
    }
    private void setLabel() {
        gPanel.next();
    }
    private void initialize() {
        if (!isRunning) {
            t1 = new Thread(new GraphicsThread());
            t1.run();
            t2.run();
        }
    }

    private class ListenerPanel extends StandardPanel implements MouseListener {

        ListenerPanel(int width, int height) {
            super(0, 0, width, height);
            addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mouseEnteredOuter();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            mouseExitedOuter();
        }
    }

    private class GraphicsPanel extends StandardPanel implements Runnable {
        private MinMaxInt i;
        private int texWidth;
        private int texHeight;
        GraphicsPanel(int width, int height) {
            super(0,0,width,height);
            texWidth = width-10;
            texHeight = height-10;
            i = new MinMaxInt(0,0,width-20+height-20,false);
        }
        private void next() {
            System.out.println(i.getValue());
            if(inThere) i.addValue(10); else i.addValue(10);
            repaint();
        }
        public void paint(Graphics gr) {
            Graphics2D g = (Graphics2D) gr;
            g.setColor(Color.YELLOW);
            if(i.getValue() > texWidth) {
                g.drawLine(10,10,10+texWidth,10);
                g.drawLine(10+texWidth,10,10+texHeight,10+i.getValue()-texHeight);
            } else {
                g.drawLine(10,10,i.getValue()+10,10);
            }
            if(i.getValue() > texHeight) {
                g.drawLine(10,10,10,10+texHeight);
                g.drawLine(10,10+texHeight,10+i.getValue()-texWidth,10+texWidth);
            } else {
                g.drawLine(10,10,10,i.getValue()+10);
            }
        }

        @Override
        public void run() {

        }
    }

    private class GraphicsThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread Running");
            for (; ; ) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                setLabel();
            }
        }

    }

}

class ListenerAndGraphicsButton extends StandardPanel {
    private boolean inThere = true;
    private GraphicsPanel g;
    ListenerAndGraphicsButton() {
        super(100,300,200,100);
        add(new ListenerPanel(200,100));
        add(g =new GraphicsPanel(200,100));
    }

    private void mouseEnteredOuter() {
        g.next();
    }

    private void mouseExitedOuter() {

    }
    private class ListenerPanel extends StandardPanel implements MouseListener {

        ListenerPanel(int width, int height) {
            super(0, 0, width, height);
            addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mouseEnteredOuter();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            mouseExitedOuter();
        }
    }
    private class GraphicsPanel extends StandardPanel {
        private MinMaxInt i;
        private int texWidth;
        private int texHeight;
        GraphicsPanel(int width, int height) {
            super(0,0,width,height);
            texWidth = width-10;
            texHeight = height-10;
            i = new MinMaxInt(0,0,width-20+height-20,false);
        }
        private void next() {
            System.out.println(i.getValue());
            if(inThere) i.addValue(10); else i.addValue(10);
            repaint();
        }
        public void paint(Graphics gr) {
            Graphics2D g = (Graphics2D) gr;
            g.setColor(Color.YELLOW);
            if(i.getValue() > texWidth) {
                g.drawLine(10,10,10+texWidth,10);
                g.drawLine(10+texWidth,10,10+texHeight,10+i.getValue()-texHeight);
            } else {
                g.drawLine(10,10,i.getValue()+10,10);
            }
            if(i.getValue() > texHeight) {
                g.drawLine(10,10,10,10+texHeight);
                g.drawLine(10,10+texHeight,10+i.getValue()-texWidth,10+texWidth);
            } else {
                g.drawLine(10,10,10,i.getValue()+10);
            }
        }

    }

}