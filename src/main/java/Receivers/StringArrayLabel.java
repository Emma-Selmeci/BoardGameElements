package Receivers;

import BaseClasses.StandardLabel;

public class StringArrayLabel extends StandardLabel implements BaseReceiver {

    private final String[] content;
    private int value;

    public StringArrayLabel(int x, int y, int width, int height, String[] content) {
        super(x,y,width,height);
        this.content = content;
        setValue(0);
    }

    public String getStringValue() {return content[value];}

    @Override
    public int getValue() {return value;}

    @Override
    public void setValue(int i) {
        value=i;
        setText(content[value]);
    }
}
