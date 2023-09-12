import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class CounterWithButtons extends StandardPanel {

    private CounterButton[] buttons = new CounterButton[2];
    private String initialText;
    private MainLabel label;
    private int min;
    private int max;
    private int value;

    public CounterWithButtons(int x, int y, int width, int height) {
        super(x,y,width,height);
        add(buttons[0] = new CounterButton(0,width,height,true));
        add(buttons[1] = new CounterButton(height/2,width,height,false));
        add(label = new MainLabel(width,height));
    }

    public CounterWithButtons(int x, int y, int width, int height, String initialText, int min, int max) {
        this(x,y,width,height);
        setInitialText(initialText);
        setBounds(min,max);
        rewrite();
    }

    public int getValue() {return value;}

    private void setInitialText(String initialText) {
        this.initialText = initialText;
    }

    public void setBounds(int min, int max) {
        value = min;
        this.min = min;
        this.max = max;
        rewrite();
    }

    public void update() {

    }

    public void add(int i) {
        if(value + i <= max && value + i >= min) {
            value+=i;
        } else if(value + i > max) value = max; else value = min;
    }

    public void inc() {
        buttonAction(true);
    }

    public void dec() {
        buttonAction(false);
    }

    private void rewrite() {
        label.setText(initialText + " " + value);
    }
    private void buttonAction(boolean state) {
        if(state) {
            if(value < max) value++;
        } else {
            if(value > min) value--;
        }
        update();
        rewrite();
    }

    private class MainLabel extends StandardLabel {

        MainLabel(int width, int height) {
            super(0,0,width-30,height);
        }

    }
    private class CounterButton extends StandardLabel implements MouseListener {
        private boolean state;

        CounterButton(int y, int width, int height, boolean upper) {
            super(width-30,y,30,height/2);
            addMouseListener(this);
            state = upper;
            if(upper) {
                setText("INC");
            } else setText("DEC");
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            buttonAction(state);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
