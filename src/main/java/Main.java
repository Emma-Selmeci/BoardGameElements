import java.awt.*;

public class Main {
    public static void main(String[] args) {

        /*MatrixGenerator m = new MatrixGenerator(3,4,false);
        for(int i = 0; i < 20; i ++) {
            System.out.println(m.x() + " " + m.y());
            m.next();
        }*/

        ColorSelectorManager c = new ColorSelectorManager(new Color[]{
                Color.YELLOW,Color.RED,Color.BLUE,Color.BLACK,Color.MAGENTA,Color.LIGHT_GRAY,Color.pink,
        });

        StandardFrame f = new StandardFrame("TEST");
        f.add(c.getColorSelector(10,10));
        f.add(c.getColorSelector(10,200));
        f.add(c.getColorSelector(10,400));
        f.repaint();

    }
}
