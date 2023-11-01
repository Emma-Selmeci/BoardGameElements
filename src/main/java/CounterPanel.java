/*public class CounterPanel extends StandardPanel {

    StandardPanel[] content;

    CounterPanel(int x, int y, int width, int height, StandardPanel[] content) {
        super(x,y,width,height);
        this.content = content;
        setPanelNumber(1);
    }

    public void setPanelNumber(int numberOfActivePanels) {
        for(int i = 0; i < content.length; i++) {
            if(i > numberOfActivePanels-1) remove(content[i]); else add(content[i]);
        }
        repaint();
    }

}
*/