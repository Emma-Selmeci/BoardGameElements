class AdvancedCounter extends StandardLabel {
    private OverFlowMinMaxInt content;
    private String text;

    public AdvancedCounter(int x, int y, int width, int height, String text, int initialvalue, int min, int max, boolean loopable) {
        super(x,y,width,height);
        this.content = new OverFlowMinMaxInt(initialvalue,min,max,loopable);
        this.text = text;
        setText(text + " " + content.getValue());
    }
    private void refresh() {
        setText(text + " " + content.getValue());
    }

    public void setNewText(String newtext) {

        text = newtext;
        refresh();

    }

    public int getValue() {return content.getValue();}
    public void addValue(int i) {
        content.add(i);
        refresh();
    }

    public void overFlow(boolean up) {

    }
    class OverFlowMinMaxInt extends MinMaxInt {

        OverFlowMinMaxInt(int initialvalue, int min, int max, boolean loopable) {
            super(initialvalue,min,max,loopable);
        }

        void overflow(boolean up) {
            overFlow(up);
        }

    }

}
