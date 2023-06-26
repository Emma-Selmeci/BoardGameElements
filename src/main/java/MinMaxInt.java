public class MinMaxInt {

    int value;
    int min;
    int max;
    int range;
    boolean loopable;

    MinMaxInt(int initialvalue, int min, int max, boolean loopable) {
        value = initialvalue;
        this.min = min;
        this.max = max;
        this.loopable = loopable;
        range = max-min+1;
    }

    int getValue() {
        return value;
    }

    int next() { if(value < max) return (value+1); else if(loopable) return min; else return max;}
    int prev() { if(value > min) return (value-1); else if(loopable) return max; else return min;}
    void inc() {
        if(value < max) value++; else if(loopable) value = min; else overflow(true);
    }
    void dec() {
        if(value > min) value--; else if(loopable) value = max; else overflow(false);
    }
    void add(int i) {
        if(value + i <= max && value + i >= min) {
            value+=i;
        } else {
            if(value + i > max) {
                if(!loopable) {
                    value = max;
                    overflow(true);
                }else {
                    value+=i;
                    do {
                        System.out.println("Inside range loop, value : " + value);
                        value -= range;
                    } while (value - range >= min);
                }
            } else {
                if(!loopable) {
                    value = min;
                    overflow(false);
                } else {//value+i < min
                    System.out.println("Range excess in minus");
                    value+=i;
                    do {
                        System.out.println("Inside range loop, value : " + value);
                        value += range;
                    } while (value + range <= max);
                }
            }
        }
    }

    void set(int i) {
        if(i <= max && i >= min) {
            value = i;
        } else if(i > max) i = max; else i = min;
    }

    void overflow(boolean up) {}

}
