/**
 * Base class for objects that use a wrapped int class
 */

package Abstractions;

public abstract class IntWrapper {
    protected int value;
    public int getValue() {return value;}
    public String toString() {return String.valueOf(value);}
    public abstract void setValue(int newValue);
    public abstract void addValue(int i);
    public abstract void inc(boolean b);
    public abstract void inc();
    public abstract void dec();
}