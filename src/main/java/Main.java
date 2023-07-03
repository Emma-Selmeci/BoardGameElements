import java.awt.*;

public class Main {
    public static void main(String[] args) {

        /*SimpleGraphRouter a = new SimpleGraphRouter(6);

        a.setConnection(0, new int[]{1, 2, 4});
        a.setConnection(1, new int[]{0, 4});
        a.setConnection(2, new int[]{0, 3, 4});
        a.setConnection(3, new int[]{2, 4, 5});
        a.setConnection(4, new int[]{0, 1, 2, 3, 5});
        a.setConnection(5, new int[]{3, 4});

        int[] j = a.route(0,5);
        System.out.print("Final route : ");
        for(int i : j) System.out.print(i + "");*/

        AdvancedGraphRouter ag = new AdvancedGraphRouter(7);

        /*
        * 0 - Münster
        * 1 - Duisburg
        * 2 - Essen
        * 3 - Dortmund
        * 4 - Düsseldorf
        * 5 - Aachen
        * 6 - Köln
        * */

        ag.setConnection(0,2,6);
        ag.setConnection(1,2,0);
        ag.setConnection(2,3,4);
        ag.setConnection(0,3,2);
        ag.setConnection(2,4,2);
        ag.setConnection(3,6,10);
        ag.setConnection(4,5,9);
        ag.setConnection(5,6,7);
        ag.setConnection(4,6,4);

        int[] j = ag.route(0,5);
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
