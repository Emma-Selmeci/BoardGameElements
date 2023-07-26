public class Main {
    public static void main(String[] args) {


        MultiButton m;
        StandardFrame f = new StandardFrame("Test Hexagons");
        f.add(m = new MultiButton(0,0,500,20,new String[] {
                "1","2","3",
        },true));
        f.repaint();
        m.forceSelection(2);
        f.repaint();

    }
}