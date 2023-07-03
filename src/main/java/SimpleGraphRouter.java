public class SimpleGraphRouter {

    Node[] content;
    int dest;

    public int[] route(int start, int dest) {
        this.dest = dest;
        for(Node n : content) {
            n.routeValue = -1;
            n.prevRoute = new int[0];
        }

        content[start].route(0,new int[]{});

        return content[dest].prevRoute;
    }

    SimpleGraphRouter(int numberOfNodes) {
        content = new Node[numberOfNodes];
        for(int i = 0; i < content.length; i++) {
            content[i] = new Node();
            content[i].TEST_ID = i; //TO DELETE WHEN TESTING IS OVER
        }
    }

    public void setConnection(int noteToSet, int[] connectionNumbers) {
        Node[] connections = new Node[connectionNumbers.length];
        for(int i = 0; i < connections.length; i++) {
            connections[i] = content[connectionNumbers[i]];
        }
        content[noteToSet].addConnections(connections);
    }

    class Node {

        Node[] connections;
        int TEST_ID;
        int[] prevRoute = new int[0];
        int routeValue = -1;

        void addConnections(Node[] connections) {
            this.connections = connections;
        }
        boolean isConnected(Node isThisNodeConnected) {
            for(Node n : connections) if(n == isThisNodeConnected) return true;
            return false;
        }

        void route(int givenValue, int[] receivedRoute) {
            if(receivedRoute.length > 0) System.out.println("Route method started from Node " + receivedRoute[receivedRoute.length-1] + " to Node " + TEST_ID + " with value " + givenValue + " vs current value of " + routeValue);
            if(routeValue == -1 || givenValue < routeValue) {
                System.out.println("Successful override");
                routeValue = givenValue;
                int[] temp = new int[receivedRoute.length+1];
                for(int i = 0; i < receivedRoute.length; i++) {
                    temp[i] = receivedRoute[i];
                }
                temp[temp.length-1] = TEST_ID;
                prevRoute = temp;
                System.out.print("Prevroute : ");
                for(int i : prevRoute) System.out.print(i + "");
                System.out.println();
                if(dest != TEST_ID) for(Node n : connections) n.route(routeValue+1,prevRoute);
            }
        }

    }

}
