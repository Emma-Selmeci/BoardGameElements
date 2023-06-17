import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Dependencies {

}

/*
 * 0,0,1366,768
 *||
 *
 * */
class MatrixGenerator {
    int x = 0;
    int y = 0;
    int rows;
    int columns;

    MatrixGenerator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    void next() {
        if(y == rows-1) {
            y = 0;
            x++;
        } else y++;
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

}
class MinMaxInt {

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
                    } while (value - range > min);
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
                    } while (value + range < max);
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
class StandardFrame extends JFrame {

    StandardFrame(String windowtitle) {
        this.setTitle(windowtitle);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.setResizable(false);
        this.setExtendedState(6);
        this.setUndecorated(true);
        this.getContentPane().setBackground(Color.GRAY);
        this.setVisible(true);
    }

}
class StandardPanel extends JPanel {

    public StandardPanel(int x, int y, int width, int height) {

        setBounds(x,y,width,height);
        setLayout(null);
        setOpaque(false);

    }

    public StandardPanel() {

        setBounds(0,0,1366,768);
        setLayout(null);
        setOpaque(false);

    }

}
class StandardLabel extends JLabel {

    public StandardLabel(int x, int y, int width, int height) {

        setBounds(x,y,width,height);
        setOpaque(false);

    }

    public StandardLabel(int x, int y, int width, int height, String text) {
        this(x,y,width,height);
        setText(text);
        setOpaque(false);

    }

}
class StandardTextField extends TextField {

    public StandardTextField(int x, int y, int width, int height) {

        setBounds(x,y,width,height);

    }

}
class Switchableboolean {

    private boolean b;

    public Switchableboolean(boolean initialvalue) {

        b = initialvalue;

    }

    void switchstate() {

        if(b) b = false; else b = true;

    }

    boolean getvalue() {
        return(b);
    }

}
class CounterwithText extends StandardLabel {

    private String initialtext;
    private int value = 0;

    public CounterwithText(int x, int y, int width, int height) {
        super(x,y,width,height);
        setText("");
        refreshtext();
    }

    public CounterwithText(int x, int y, int width, int height, String initialtext) {
        this(x,y,width,height);
        setnewtext(initialtext);
        refreshtext();
    }

    private void refreshtext() {

        setText(initialtext + " " + value);

    }

    public void setnewtext(String newtext) {

        initialtext = newtext;
        refreshtext();

    }

    public int getvalue() {
        return value;
    }

    public void addpoints(int newpoints) {

        value+=newpoints;
        refreshtext();

    }

}
class CounterwithButtons extends StandardPanel {

    private Counterbutton[] buttons = new Counterbutton[2];
    private String initialtext;
    private Mainlabel label;
    private int min;
    private int max;
    private int value;

    public CounterwithButtons(int x, int y, int width, int height) {
        super(x,y,width,height);
        add(buttons[0] = new Counterbutton(0,width,height,true));
        add(buttons[1] = new Counterbutton(height/2,width,height,false));
        add(label = new Mainlabel(width,height));
    }

    public CounterwithButtons(int x, int y, int width, int height, String initialtext, int min, int max) {
        this(x,y,width,height);
        setinitialtext(initialtext);
        setvalues(min,max);
        rewrite();
    }

    int getvalue() {return value;}

    private void setinitialtext(String initialtext) {
        this.initialtext = initialtext;
    }

    public void setvalues(int min, int max) {
        value = min;
        this.min = min;
        this.max = max;
        rewrite();
    }

    void update() {

    }
    private void rewrite() {
        label.setText(initialtext + " " + value);
    }
    private void buttonaction(boolean state) {
        if(state) {
            if(value < max) value++;
        } else {
            if(value > min) value--;
        }
        update();
        rewrite();
    }

    private class Mainlabel extends StandardLabel {

        Mainlabel(int width, int height) {
            super(0,0,width-30,height);
        }

    }
    private class Counterbutton extends StandardLabel implements MouseListener {
        private boolean state;

        Counterbutton(int y, int width,int height,boolean upper) {
            super(width-30,y,30,height/2);
            addMouseListener(this);
            state = upper;
            if(upper) {
                setText("INC");
            } else setText("DEC");
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            buttonaction(state);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
class AdvancedCounter extends StandardLabel {
    private OverFlowMinMaxInt content;
    private String text;

    public AdvancedCounter(int x, int y, int width, int height, String text, int initialvalue, int min, int max, boolean loopable) {
        super(x,y,width,height);
        this.content = new OverFlowMinMaxInt(initialvalue,min,max,loopable);
        this.text = text;
        setText(text + " " + content.getValue());
    }
    public void refresh() {
        setText(text + " " + content.getValue());
    }
    public void addValue(int i) {
        content.add(i);
        refresh();
    }
    public int getValue() {return content.getValue();}

    public void overFlow(boolean up) {

    }
    class OverFlowMinMaxInt extends MinMaxInt {

        OverFlowMinMaxInt(int initialvalue, int min, int max, boolean loopable) {
            super(initialvalue,min,max,loopable);
        }

        void overflow(boolean up) {
            overFlow(up);
        }

    }

}
class AdvancedCounterwithButtons extends StandardPanel {

    AdvancedCounter counter;
    IncButton[] buttons;

    AdvancedCounterwithButtons(int x, int y, int width, int height,String text, int initialvalue, int min, int max, boolean loopable) {
        super(x,y,width,height);
        add(counter = new AdvancedCounter(0,0,width-30,20,text,initialvalue,min,max,loopable));
        buttons = new IncButton[2];
        add(buttons[0] = new IncButton(width-30,0,"INC",true));
        add(buttons[1] = new IncButton(width-30,20,"DEC",false));
    }

    void buttonclicked(boolean inc) {
        if(inc) counter.addValue(1); else counter.addValue(-1);
    }

    int getValue() {return counter.getValue();}
    class IncButton extends SimpleSwitch {
        boolean inc;

        IncButton(int x,int y,String text,boolean inc) {
            super(x,y,30,20,text);
            this.inc = inc;
        }

        public void clicked() {
            buttonclicked(inc);
        }

    }

}
class MinMaxPoint {
    MinMaxInt x;
    MinMaxInt y;
    MinMaxPoint(int xin, int xmax, int yin, int ymax) {
        x = new MinMaxInt(xin,0,xmax,false);
        y = new MinMaxInt(yin,0,ymax,false);
    }
}
class SimpleSwitch extends StandardLabel implements MouseListener {

    SimpleSwitch(int x, int y, int width, int height, String text) {
        super(x,y,width,height,text);
        addMouseListener(this);
    }

    public void clicked() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
class OnOffswitch extends StandardLabel implements MouseListener {

    private boolean state = false;
    private boolean isActive = true;

    public OnOffswitch(int x, int y, int width, int height,String text) {
        super(x,y,width,height);
        setText(text);
        setBackground(Color.BLACK);
        setForeground(Color.RED);
        setOpaque(true);
        addMouseListener(this);
    }

    boolean getstate() {
        return state;
    }
    void setActive(boolean isActive) {this.isActive = isActive;}
    void switchstate() {
        mouseclicked();
    }
    private void mouseclicked() {
        if(state) {
            state = false;
            setForeground(Color.RED);
        } else {
            state = true;
            setForeground(Color.GREEN);
        }
    }

    void mouseclicked2() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(isActive) {
            mouseclicked();
            mouseclicked2();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
class StringArraySelector extends StandardPanel {

    String[] content;
    int value = 0;
    StandardLabel contentLabel;
    ValueButton[] buttons = new ValueButton[2];

    StringArraySelector(int x, int y, int width, int height,String[] content) {
        super(x,y,width,height);
        this.content = content;
        add(contentLabel = new StandardLabel(0,0,width-30,height,content[value]));
        add(buttons[0] = new ValueButton(width,0,"INC",true));
        add(buttons[1] = new ValueButton(width,height/2,"DEC",false));
    }
    private void changevalue(boolean inc) {
        if(inc) {
            if(value < content.length-1) value++; else value = 0;
        } else if(value > 0) value--; else value= content.length-1;
        contentLabel.setText(content[value]);
    }
    public int getValue() {
        return value;
    }
    public void activate(boolean b) {
        if(b) {
            add(buttons[0]);
            add(buttons[1]);
        } else {
            remove(buttons[0]);
            remove(buttons[1]);
        }
        repaint();
    }
    class ValueButton extends SimpleSwitch {
        private boolean inc;
        public void clicked() {
            changevalue(inc);
        }
        ValueButton(int width, int y,String content,boolean inc) {
            super(width-30,y,30,20,content);
            this.inc = inc;
        }

    }

}
class MultiPanel extends StandardPanel {
    private StandardPanel[] content;

    MultiPanel(int x, int y, int width, int height,StandardPanel[] content) {
        super(x,y,width,height);
        this.content = content;
        add(content[0]);
    }

    void changePanel(int newpanelnumber) {
        for(int i = 0; i< content.length;i++) {
            if(i !=newpanelnumber) remove(content[i]); else add(content[i]);
        }
        repaint();
    }
}
class MultiButton extends StandardPanel {
    MySwitch[] buttons;
    int activebutton;

    MultiButton(int x, int y, int width, int height,String[] buttontext, boolean horizontal) {
        super(x, y, width, height);
        buttons = new MySwitch[buttontext.length];
        if(horizontal) {
            int offset = width / buttons.length;
            for (int i = 0; i < buttons.length; i++) {
                add(buttons[i] = new MySwitch(i, i * offset, 0, offset, height, buttontext[i]));
            }
        } else {
            int offset = height / buttons.length;
            for (int i = 0; i < buttons.length; i++) {
                add(buttons[i] = new MySwitch(i, 0,i * offset, width, offset, buttontext[i]));
            }
        }
        buttons[0].switchstate();
        activebutton = 0;
    }

    public void statechange(int buttonnumber) {

    }

    void buttonSelected(int buttonnumber) {
        buttons[activebutton].switchstate();
        activebutton = buttonnumber;
        statechange(buttonnumber);
    }

    class MySwitch extends OnOffswitch {
        int id;
        MySwitch(int id, int x, int y, int width, int height,String text) {
            super(x,y,width,height,text);
            this.id = id;
        }

        @Override
        void mouseclicked2() {
            buttonSelected(id);
        }
    }

}
class CounterPanel extends StandardPanel {

    StandardPanel[] content;

    CounterPanel(int x, int y, int width, int height, StandardPanel[] content) {
        super(x,y,width,height);
        this.content = content;
        setPanelNumber(1);
    }

    public void setPanelNumber(int numberOfActivePanels) {
        for(int i = 0; i < content.length; i++) {
            if(i > numberOfActivePanels-1) remove(content[i]); else add(content[i]);
        }
        repaint();
    }

}
class StandardPlayerSetupPanel extends StandardPanel {

    StandardTextField playerName;

    StandardPlayerSetupPanel(int id, int y, int width, int height) {
        super(0,y,width,height);
        add(playerName = new StandardTextField(20,20,150,20));
        playerName.setText("Player " + id);
    }

    public String getPlayerName() {
        return playerName.getText();
    }

}