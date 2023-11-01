/**
 * MinMaxInt is similar to WrappedInt but is capped.
 * canOverFlow determines if the value will overflow or cap
 */
package Abstractions;

public class MinMaxInt extends IntWrapper {

    private final int min;
    private final int max;
    private final boolean canOverFlow;

    public MinMaxInt(int initialValue, int min, int max, boolean canOverFlow) {
        value = 0;
        this.min = min;
        this.max = max;
        this.canOverFlow = canOverFlow;
        setValue(initialValue);
    }

    @Override
    public void setValue(int newValue) {

        boolean inRange = false;
        if(!canOverFlow) {
            if(newValue <= min) {value = min;return;}
            if(newValue >= max) {value = max;return;}
            inRange = true;
        }
        if(inRange || canOverFlow && newValue >= min && newValue <= max) {value = newValue;return;} //Heavily optimised line
        overFlow(newValue); //Only called when we are out of range and overflow is enabled
    }

    @Override
    public void addValue(int i) {
        setValue(value + i);
    }

    @Override
    public void inc(boolean b) {
        if(b) inc(); else dec();
    }

    @Override
    public void inc() {
        setValue(value + 1);
    }

    @Override
    public void dec() {
        setValue(value - 1);
    }

    private void overFlow(int i) { //I'll never want to do this part from scratch again
        int range = max - min + 1;
        if(i < min) {
            value = i + (((min - 1 - i) / range)+1) * range;
        }
        if(i > max) {
            value = i - (((i - max - 1) / range)+1) * range;
        }
    }

}
