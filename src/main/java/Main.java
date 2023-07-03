import java.awt.*;

public class Main {
    public static void main(String[] args) {

        SimpleGraphRouter a = new SimpleGraphRouter(6);

        a.setConnection(0, new int[]{1, 2, 4});
        a.setConnection(1, new int[]{0, 4});
        a.setConnection(2, new int[]{0, 3, 4});
        a.setConnection(3, new int[]{2, 4, 5});
        a.setConnection(4, new int[]{0, 1, 2, 3, 5});
        a.setConnection(5, new int[]{3, 4});

        int[] j = a.route(0,5);
        System.out.print("Final route : ");
        for(int i : j) System.out.print(i + "");

        /*{
            AdjacencyManager a = new AdjacencyManager(6);


        0 - cyan
        1 - brown
        2 - red
        3 - blue
        4 - yellow
        5 - purple


            a.setConnection(0, new int[]{1, 2, 4});
            a.setConnection(1, new int[]{0, 4});
            a.setConnection(2, new int[]{0, 3, 4});
            a.setConnection(3, new int[]{2, 4, 5});
            a.setConnection(4, new int[]{0, 1, 2, 3, 5});
            a.setConnection(5, new int[]{3, 4});
            System.out.println(a.isConnected(new int[]{4, 2, 0})); //true
            System.out.println(a.isConnected(new int[]{1, 2, 4})); //true
            System.out.println(a.isConnected(new int[]{1, 2, 5})); //false
            System.out.println(a.isConnected(new int[]{0, 5, 1})); //false
            System.out.println(a.isConnected(new int[]{0, 5, 1, 4})); //true
            System.out.println(a.isConnected(new int[]{0, 1, 2, 3, 5})); //true
            System.out.println(a.isConnected(new int[]{0, 1, 2, 3, 4, 5})); //true
        }*/
    }
}
