public class SwitchableBoolean {
    private boolean b;
    private boolean isOn = true;

    public SwitchableBoolean(boolean initialValue) {

        b = initialValue;

    }

    void switchState() {

        if(isOn) b = !b;

    }

    void onOff(boolean isOn) {
        this.isOn = isOn;
    }

    boolean getValue() {
        return(b);
    }

}
