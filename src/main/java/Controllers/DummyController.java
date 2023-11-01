package Controllers;

import Abstractions.IntWrapper;
import Receivers.BaseReceiver;

public class DummyController implements BaseController {
    private BaseReceiver[] receivers = new BaseReceiver[0];
    private final IntWrapper value;
    private final IntEffect[] effects;

    public DummyController(IntWrapper value, BaseReceiver receiver, IntEffect... effects) {
        this.value = value;
        this.effects = effects;
        if(receiver != null) receivers = new BaseReceiver[]{receiver};
    }

    public void inc() {
        value.inc();
        effect();
    }
    public void dec() {
        value.dec();
        effect();
    }
    public void inc(boolean b) {
        value.inc(b);
        effect();
    }
    public void setValue(int i) {
        value.setValue(i);
        effect();
    }
    public void addValue(int i) {
        value.addValue(i);
        effect();
    }
    public int getValue() {
        return value.getValue();
    }
    @Override
    public void effect() {
        for(IntEffect e : effects) e.effect(value.getValue());
        for(BaseReceiver r : receivers) r.setValue(value.getValue());
    }
}