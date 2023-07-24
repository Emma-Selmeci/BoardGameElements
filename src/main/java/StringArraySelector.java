public class StringArraySelector extends StandardPanel {

    String[] content;
    int value = 0;
    StandardLabel contentLabel;
    ValueButton[] buttons = new ValueButton[2];

    StringArraySelector(int x, int y, int width, int height,String[] content) {
        super(x,y,width,height);
        this.content = content;
        add(contentLabel = new StandardLabel(0,0,width-30,height,content[value]));
        add(buttons[0] = new ValueButton(width,0,"INC",true));
        add(buttons[1] = new ValueButton(width,height/2,"DEC",false));
    }
    private void changeValue(boolean inc) {
        if(inc) {
            if(value < content.length-1) value++; else value = 0;
        } else if(value > 0) value--; else value= content.length-1;
        contentLabel.setText(content[value]);
    }
    public void setValue(int newValue) {
        value = newValue;
        contentLabel.setText(content[value]);
    }
    public int getValue() {
        return value;
    }
    public void activate(boolean b) {
        if(b) {
            add(buttons[0]);
            add(buttons[1]);
        } else {
            remove(buttons[0]);
            remove(buttons[1]);
        }
        repaint();
    }
    class ValueButton extends SimpleSwitch {
        private boolean inc;
        public void update() {
            changeValue(inc);
        }
        ValueButton(int width, int y,String content,boolean inc) {
            super(width-30,y,30,20,content);
            this.inc = inc;
        }

    }

}
