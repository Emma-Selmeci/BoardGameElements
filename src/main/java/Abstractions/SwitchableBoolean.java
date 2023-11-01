/**
 Simple wrapper for a boolean type with extra functions (invert and turn on/off)
 */
package Abstractions;
public class SwitchableBoolean {
    private boolean b;
    private boolean isOn = true;

    public SwitchableBoolean(boolean initialValue) {

        b = initialValue;

    }

    public void switchState() {

        if(isOn) b = !b;

    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }
    public void setValue(boolean b) { this.b = b; }

    public boolean getValue() {
        return(b);
    }
    public boolean isOn() {
        return(isOn);
    }
    public String toString() {
        return String.valueOf(b);
    }

}
