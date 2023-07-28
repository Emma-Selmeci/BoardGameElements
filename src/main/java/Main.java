public class Main {
    public static void main(String[] args) {


        LabelCluster m;
        StandardFrame f = new StandardFrame("Test Hexagons");
        f.add(m = new LabelCluster(100,100,200,4));

        m.setText(new String[]{
                "Kolb","NE","Kolb2","KOLBAJS"
        });

        f.repaint();

    }
}