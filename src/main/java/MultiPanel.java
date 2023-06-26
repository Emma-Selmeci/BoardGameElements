public class MultiPanel extends StandardPanel {
    private StandardPanel[] content;

    MultiPanel(int x, int y, int width, int height,StandardPanel[] content) {
        super(x,y,width,height);
        this.content = content;
        add(content[0]);
    }

    void changePanel(int newpanelnumber) {
        for(int i = 0; i< content.length;i++) {
            if(i !=newpanelnumber) remove(content[i]); else add(content[i]);
        }
        repaint();
    }
}
