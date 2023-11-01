/*import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorSelectorManager {

    private final Color[] colors;
    private int selectorCounter = 0;
    private final ColorSelector[] colorSelectors;
    private static final int maxColorNumber = 20; //I don't think that I'll ever need more colors than this. In case I do, I'll inc this number

    public ColorSelectorManager(Color[] colors) {

        this.colors = colors;

        colorSelectors = new ColorSelector[colors.length];

        for(int i = 0; i < colorSelectors.length; i++) colorSelectors[i] = new ColorSelector(i);

    }

    public ColorSelector getColorSelector(int x, int y) {
        colorSelectors[selectorCounter].setNewBounds(x,y);
        return(colorSelectors[selectorCounter++]);
    }

    public Color[] getSelectedColors() {
        Color[] selectedColors = new Color[colors.length];

        for(int i = 0; i < selectedColors.length; i++) {
            selectedColors[i] = colors[colorSelectors[i].getSelectedColorNumber()];
        }

        return selectedColors;
    }

    private void stateChange(int originatorId, int desiredColorNumber) {
        for(int i = 0; i < colorSelectors.length; i++) {
            if(i != originatorId) {
                if (colorSelectors[i].getSelectedColorNumber() == desiredColorNumber) {
                    colorSelectors[i].setColorNumber(colorSelectors[originatorId].getSelectedColorNumber());
                    colorSelectors[originatorId].setColorNumber(desiredColorNumber);
                    break;
                }
            }
        }
    }

    class ColorSelector extends StandardPanel {

        private final int id;
        private int selectedColorNumber;
        private final ColorPanel[] colorPanels;

        ColorSelector(int id) {
            super();
            this.id = id;

            selectedColorNumber = id;

            setBackground(Color.DARK_GRAY);
            setOpaque(true);

            MatrixGenerator m = new MatrixGenerator(3,maxColorNumber/3+1,false);

            colorPanels = new ColorPanel[colors.length];
            for(int i = 0; i < colorPanels.length; i++) {
                add(colorPanels[i] = new ColorPanel(i,m.x(),m.y(),colors[i],i == id));
                m.next();
            }
        }

        private void setColorNumber(int newColorNumber) {
            colorPanels[getSelectedColorNumber()].invert(false);
            colorPanels[newColorNumber].invert(true);
            selectedColorNumber = newColorNumber;
        }

        private void newSelectedColorNumber(int desiredColorNumber) {
            if(desiredColorNumber != getSelectedColorNumber()) {
                stateChange(getId(), desiredColorNumber);
            }
        }

        private int getSelectedColorNumber() {
            return selectedColorNumber;
        }

        private int getId() {
            return id;
        }
        private void setNewBounds(int x, int y) { //We need to set the bounds later because it will be the requesting class who tells the x and y coordinate
            if(colors.length%3 > 0) {
                setBounds(x,y,(colors.length/3+1)*30,90);
            } else {
                setBounds(x,y,(colors.length/3)*30,90);
            }

        }

        private class ColorPanel extends StandardPanel implements MouseListener {

            private final int id;

            private ColorPanel(int id,int x, int y,Color color,boolean isActive) {
                super(x*30,y*30,30,30);
                this.id = id;

                setOpaque(true);
                if(isActive) {
                    setBackground(Color.WHITE);
                } else setBackground(Color.BLACK);

                StandardLabel colorLabel;
                add(colorLabel = new StandardLabel(5,5,20,20));
                colorLabel.setOpaque(true);
                colorLabel.setBackground(color);

                addMouseListener(this);
            }

            private void invert(boolean isWhite) {
                if(isWhite) setBackground(Color.WHITE); else setBackground(Color.BLACK);
            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                newSelectedColorNumber(id);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }

    }

}
*/