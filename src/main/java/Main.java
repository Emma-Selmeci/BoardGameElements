import java.awt.*;

public class Main {
    public static void main(String[] args) {

        StandardFrame f = new StandardFrame("Test Hexagons");
        f.add(new MyPanel());
        f.repaint();

    }
}

class MyPanel extends StandardPanel {


    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        Point[] points = Geometry.getHexagon(new Point(100,100),300);

        for(int i = 0; i < 5; i++) {
            g.drawLine(points[i].x,points[i].y,points[i+1].x,points[i+1].y);
        }
        g.drawLine(points[5].x,points[5].y,points[0].x,points[0].y);

    }

}
