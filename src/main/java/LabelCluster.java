public class LabelCluster extends StandardPanel {

    private StandardLabel[] labels;

    LabelCluster(int x, int y, int width, int rows) {
        super(x,y,width,rows*20);
        labels = new StandardLabel[rows];
        for(int i = 0; i < labels.length; i++) add(labels[i] = new StandardLabel(0,i*20,width,20));
        repaint();
    }

    public void clear() {
        for(StandardLabel s : labels) s.setText("");
    }

    public void setText(String[] text) {
        for(int i = 0; i < labels.length; i++) {
            if(i < text.length) {
                labels[i].setText(text[i]);
            } else labels[i].setText("");
        }
    }

}
