class AdvancedCounterWithButtons extends StandardPanel {

    private AdvancedCounter counter;
    private IncButton[] buttons;
    private String text;
    private final int width;
    private final boolean loopable;

    AdvancedCounterWithButtons(int x, int y, int width, int height,String text, int initialValue, int min, int max, boolean loopable) {
        super(x,y,width,height);
        this.width = width;
        this.loopable = loopable;
        this.text = text;
        add(counter = new AdvancedCounter(0,0,width-30,20,text,initialValue,min,max,loopable));
        buttons = new IncButton[2];
        add(buttons[0] = new IncButton(width-30,0,"INC",true));
        add(buttons[1] = new IncButton(width-30,20,"DEC",false));
    }
    public int getValue() {return counter.getValue();}

    public void setInitialText(String text) {
        this.text = text;
        refresh();
    }

    public void setBounds(int min, int max) {
        remove(counter);

        int initialValue = counter.getValue();

        add(counter = new AdvancedCounter(0,0,width-30,20,text,initialValue,min,max,loopable));
    }

    public void update() {
    }

    public void add(int i ) {
        counter.addValue(i);
    }

    public void inc() {
        buttonclicked(true);
    }

    public void dec() {
        buttonclicked(false);
    }

    private void refresh() {
        counter.setText(text);
    }
    void buttonclicked(boolean inc) {
        if(inc) counter.addValue(1); else counter.addValue(-1);
    }



    class IncButton extends SimpleSwitch {
        boolean inc;

        IncButton(int x,int y,String text,boolean inc) {
            super(x,y,30,20,text);
            this.inc = inc;
        }

        public void clicked() {
            buttonclicked(inc);
        }

    }

}