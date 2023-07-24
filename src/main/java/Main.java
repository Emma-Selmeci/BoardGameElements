import java.awt.*;

public class Main {
    public static void main(String[] args) {

        StandardFrame f = new StandardFrame("Test Hexagons");
        f.add(new StandardSetupScreen(2,7,new Color[]{
                Color.RED,Color.BLUE,Color.BLACK,Color.CYAN,Color.YELLOW,Color.LIGHT_GRAY,Color.WHITE,
        }));
        f.repaint();

    }
}