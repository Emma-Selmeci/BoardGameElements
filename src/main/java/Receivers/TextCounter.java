package Receivers;

import BaseClasses.StandardLabel;

public class TextCounter extends StandardLabel implements BaseReceiver {
    private final boolean textBeforeValue;
    private int value;
    private String text;

    public TextCounter(int x, int y, int width, int height, String text, boolean textBeforeValue) {
        super(x,y,width,height);
        this.textBeforeValue = textBeforeValue;
        this.text = text;
        setValue(0);
    }

    @Override
    public void setValue(int i) {
        value = i;
        if(textBeforeValue) {
            setText(text + " " + String.valueOf(value));
        } else {
            setText(String.valueOf(value) + " " + text);
        }
    }

    @Override
    public int getValue() {
        return value;
    }
}
