public class CounterWithText extends StandardLabel {

    private String initialText;
    private int value = 0;

    public CounterWithText(int x, int y, int width, int height) {
        super(x,y,width,height);
        setText("");
        refreshText();
    }

    public CounterWithText(int x, int y, int width, int height, String initialText) {
        this(x,y,width,height);
        setNewText(initialText);
        refreshText();
    }

    public CounterWithText(int x, int y, int width, int height, String initialText, int initialValue) {
        this(x,y,width,height,initialText);
        addValue(initialValue);
    }

    private void refreshText() {

        setText(initialText + " " + value);

    }

    public void setNewText(String newtext) {

        initialText = newtext;
        refreshText();

    }

    public int getValue() {
        return value;
    }

    public void addValue(int i) {

        value+=i;
        refreshText();

    }

}
