/**
 * Simple int wrapped for usage in classes that need a wrapper
 */

package Abstractions;

public class WrappedInt extends IntWrapper {

    public WrappedInt(int initialValue) {
        value = initialValue;
    }

    @Override
    public void setValue(int newValue) {
        value = newValue;
    }

    @Override
    public void addValue(int i) {
        value+=i;
    }

    @Override
    public void inc(boolean b) {
        if(b) inc(); else dec();
    }

    @Override
    public void inc() {
        value++;
    }

    @Override
    public void dec() {
        value--;
    }

}
