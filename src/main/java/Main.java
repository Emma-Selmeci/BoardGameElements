import java.awt.*;

public class Main {
    public static void main(String[] args) {

        AdjacencyManager a = new AdjacencyManager(6);

        /*
        0 - cyan
        1 - brown
        2 - red
        3 - blue
        4 - yellow
        5 - purple
        */

        a.setConnection(0,new int[]{1,2,4});
        a.setConnection(1,new int[]{0,4});
        a.setConnection(2,new int[]{0,3,4});
        a.setConnection(3,new int[]{2,4,5});
        a.setConnection(4,new int[]{0,1,2,3,5});
        a.setConnection(5,new int[]{3,4});
        System.out.println(a.isConnected(new int[]{0,2,4}));
        System.out.println(a.isConnected(new int[]{1,2,4}));
        System.out.println(a.isConnected(new int[]{0,1,5}));
    }
}
