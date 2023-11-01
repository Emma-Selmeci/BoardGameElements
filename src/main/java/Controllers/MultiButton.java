package Controllers;

import Assets.ArrayOperations;
import BaseClasses.StandardPanel;

public class MultiButton extends StandardPanel {

    private MySwitch[] buttons;
    private DummyController[] controllers = new DummyController[0];
    private IntEffect[] intEffects = new IntEffect[0];

    public MultiButton(int x, int y, int width, int height, boolean isHorizontal, String[] buttonNames) {
        super(x,y,width,height);

        buttons = new MySwitch[buttonNames.length];
        if(isHorizontal) {
            int incrementation = width / buttonNames.length;
            for(int i = 0; i < buttonNames.length; i++) {
                add(buttons[i] = new MySwitch(i*incrementation,0,incrementation,height,buttonNames[i],false,i));
            }
        } else {
            int incrementation = height / buttonNames.length;
            for(int i = 0; i < buttonNames.length; i++) {
                add(buttons[i] = new MySwitch(0,i*incrementation,width,incrementation,buttonNames[i],false,i));
            }
        }
        buttonPressed(0,false);

    }

    public MultiButton addController(DummyController d) {
        DummyController[] temp = new DummyController[controllers.length+1];
        ArrayOperations.addToArray(controllers,d,temp);
        controllers = temp;
        return this;
    }
    public MultiButton addEffect(IntEffect e) {
        IntEffect[] temp = new IntEffect[intEffects.length+1];
        ArrayOperations.addToArray(intEffects,e,temp);
        intEffects = temp;
        return this;
    }

    private void buttonPressed(int buttonId, boolean state) {
        for(MySwitch m : buttons) {
            m.setValue(false);
            m.setOn(true);
        }
        buttons[buttonId].setValue(true);
        buttons[buttonId].setOn(false);
        for(DummyController d : controllers) d.effect();
        for(IntEffect e : intEffects) e.effect(buttonId);
    }

    private class MySwitch extends OnOffSwitch {
        private final int id;
        public MySwitch(int x, int y, int width, int height, String text, boolean initialValue, int id) {
            super(x, y, width, height, text, initialValue, (boolean b) -> buttonPressed(id,b));
            this.id = id;
        }
    }

}
