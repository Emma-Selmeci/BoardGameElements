package Controllers;

public class ButtonPair {

    private StandardButton[] buttons = new StandardButton[2];
    private DummyController[] dummies;
    private BoolEffect[] effects;

    public ButtonPair(int x1, int y1, int x2, int y2, int width, int height, String text1, String text2, DummyController[] dummies, BoolEffect... effects) {
        this.dummies = dummies;
        buttons[0] = new StandardButton(x1,y1,width,height,text1,() -> effect(true));
        buttons[1] = new StandardButton(x2,y2,width,height,text2,() -> effect(false));
        this.effects = effects;
    }

    private void effect(boolean b) {
        for(BoolEffect e : effects) e.effect(b);
        for(DummyController d : dummies) d.inc(b);
    }

    public void setOn(boolean isOn) {
        for(StandardButton b : buttons) b.setOn(isOn);
    }

    public StandardButton[] getButtons() {
        return buttons;
    }

}
