public class MultiButton extends StandardPanel {
    MySwitch[] buttons;
    int activeButton;

    MultiButton(int x, int y, int width, int height,String[] buttonText, boolean horizontal) {
        super(x, y, width, height);
        buttons = new MySwitch[buttonText.length];
        if(horizontal) {
            int offset = width / buttons.length;
            for (int i = 0; i < buttons.length; i++) {
                add(buttons[i] = new MySwitch(i, i * offset, 0, offset, height, buttonText[i]));
            }
        } else {
            int offset = height / buttons.length;
            for (int i = 0; i < buttons.length; i++) {
                add(buttons[i] = new MySwitch(i, 0,i * offset, width, offset, buttonText[i]));
            }
        }
        buttons[0].switchState();
        activeButton = 0;
    }

    public void stateChange(int buttonNumber) {

    }

    void buttonSelected(int buttonNumber) {
        buttons[activeButton].switchState();
        activeButton = buttonNumber;
        stateChange(buttonNumber);
    }

    void forceSelection(int buttonNumber) {
        buttons[activeButton].switchState();
        activeButton = buttonNumber;
        buttons[activeButton].switchState();
        stateChange(buttonNumber);
    }

    class MySwitch extends OnOffSwitch {
        int id;
        MySwitch(int id, int x, int y, int width, int height,String text) {
            super(x,y,width,height,text);
            this.id = id;
        }

        @Override
        void mouseClicked2() {
            buttonSelected(id);
        }
    }

}
