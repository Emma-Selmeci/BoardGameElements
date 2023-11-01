/*import Assets.ArrayOperations;

import java.awt.*;

public class StandardSetupScreen extends StandardPanel {

    private ColorSelectorManager colorSelectorManager;
    private PlayerNumberSelector playerNumberSelector;
    private CounterPanel playerPanels;
    private PlayerSetupScreen[] playerSetupScreens;

    StandardSetupScreen(int minPlayers, int maxPlayers, Color[] selectableColors) {

        if(selectableColors.length > 0) colorSelectorManager = new ColorSelectorManager(selectableColors);

        playerSetupScreens = new PlayerSetupScreen[maxPlayers];
        MatrixGenerator m = new MatrixGenerator(5,2,false);
        for(int i = 0; i < playerSetupScreens.length; i++, m.next()) {
            playerSetupScreens[i] = new PlayerSetupScreen(i,m.x(),m.y());
        }

        add(playerPanels = new CounterPanel(0,20,600,750,playerSetupScreens));

        playerPanels.setPanelNumber(minPlayers);

        add(playerNumberSelector = new PlayerNumberSelector(minPlayers,maxPlayers));
        add(new ReadyButton());
        add(new RandomButton());
        repaint();
    }

    private void ready() {
        String[] playerNames = new String[playerNumberSelector.getValue()];

        for(int i = 0; i < playerNames.length; i++) {
            playerNames[i] = playerSetupScreens[i].getPlayerName();
        }

        if(colorSelectorManager == null) {
            update(playerNames,new Color[]{});
            return;
        }

        Color[] playerColors = new Color[playerNumberSelector.getValue()];
        Color[] colorsInOrder = colorSelectorManager.getSelectedColors();

        for(int i = 0; i < playerColors.length; i++) {
            Color c = colorsInOrder[playerSetupScreens[i].initialId];
            playerColors[i] = c;
        }

        update(playerNames,playerColors);
    }

    public void update(String[] playerNames, Color[] playerColors) {

    }

    private void randomizePlayerOrder() {
        remove(playerPanels);
        PlayerSetupScreen[] temp = new PlayerSetupScreen[playerNumberSelector.getValue()];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = playerSetupScreens[i];
        }
        PlayerSetupScreen[] tempShuffled = new PlayerSetupScreen[temp.length];
        ArrayOperations.shuffle(temp,tempShuffled);
        for(int i = 0; i < tempShuffled.length; i++) {
            playerSetupScreens[i] = tempShuffled[i];
        }
        MatrixGenerator m = new MatrixGenerator(5,2,false);
        for(int i = 0; i < tempShuffled.length; i++,m.next()) {
            playerSetupScreens[i].id = i;
            playerSetupScreens[i].setBounds(m.x()*300,m.y()*150,300,150);
        }
        add(playerPanels = new CounterPanel(0,20,600,750,playerSetupScreens));
        playerPanels.setPanelNumber(playerNumberSelector.getValue());
        repaint();
    }

    private void changePlayerOrder(int location, boolean up) {
        if(location == 0 && up) return;
        if(location == playerNumberSelector.getValue()-1 && !up) return;
        remove(playerPanels);
        PlayerSetupScreen[] temp = new PlayerSetupScreen[playerNumberSelector.getValue()];
        if(up) {
            for(int i = 0; i < temp.length; i++) {
                if(i != location || i != location-1) {
                    temp[i] = playerSetupScreens[i];
                }
            }
            temp[location-1] = playerSetupScreens[location];
            temp[location] = playerSetupScreens[location-1];
        } else {
            for(int i = 0; i < temp.length; i++) {
                if(i != location || i != location+1) {
                    temp[i] = playerSetupScreens[i];
                }
            }
            temp[location+1] = playerSetupScreens[location];
            temp[location] = playerSetupScreens[location+1];
        }
        MatrixGenerator m = new MatrixGenerator(5,2,false);
        for(int i = 0; i < temp.length; i++,m.next()) {
            playerSetupScreens[i] = temp[i];
            playerSetupScreens[i].id = i;
            playerSetupScreens[i].setBounds(m.x()*300,m.y()*150,300,150);
        }
        add(playerPanels = new CounterPanel(0,20,600,750,playerSetupScreens));
        playerPanels.setPanelNumber(playerNumberSelector.getValue());
        repaint();
    }

    class ReadyButton extends SimpleSwitch {

        ReadyButton() {
            super(500,0,250,20,"Ready");
        }

        public void update() {
            ready();
        }

    }
    class RandomButton extends SimpleSwitch {

        RandomButton() {
            super(230,0,200,20,"Random order");
        }

        public void update() {
            randomizePlayerOrder();
        }

    }
    class PlayerNumberSelector extends CounterWithButtons {
        PlayerNumberSelector(int min, int max) {
            super(0,0,200,20,"Number of Players: ",min,max);
        }

        public void update() {
            playerPanels.setPanelNumber(getValue());
            repaint();
        }

    }

    class PlayerSetupScreen extends StandardPanel {

        final int initialId;
        int id;
        StandardTextField playerName;


        PlayerSetupScreen(int id, int x, int y) {
            super(x*300,y*150,300,150);
            initialId = id;
            this.id = initialId;
            add(playerName = new StandardTextField(50,0,200,20,"Player " + (id+1)));
            add(new PosChanger(0,0,50,20,"UP"));
            add(new PosChanger(0,130,50,20,"DOWN"));
            if(colorSelectorManager != null) {
                add(colorSelectorManager.getColorSelector(50,30));
            }
            add(new PanelBorder(this));
        }

        String getPlayerName() {
            return playerName.getText();
        }

        class PosChanger extends SimpleSwitch {

            final private boolean up;

            PosChanger(int x, int y, int width, int height, String text) {
                super(x,y,width,height,text);
                up = text == "UP";
            }

            public void update() {
                changePlayerOrder(id,up);
            }

        }

    }

}
*/