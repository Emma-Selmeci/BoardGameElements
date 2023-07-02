import java.lang.reflect.Array;

public class AdjacencyManager {

    Node[] content;

    AdjacencyManager(int numberOfNodes) {
        content = new Node[numberOfNodes];
        for(int i = 0; i < content.length; i++) {
            content[i] = new Node();
            content[i].TEST_ID = i; //TO DELETE WHEN TESTING IS OVER
        }
    }
    public boolean isConnected(int[] nodesToConnect) {
        Node[] connectedNodes = new Node[nodesToConnect.length];
        Node[] notConnectedNodes = new Node[nodesToConnect.length];

        for(int i = 0; i < notConnectedNodes.length-1; i++) {
            notConnectedNodes[i] = content[nodesToConnect[i]];
        }
        connectedNodes[0] = content[nodesToConnect[nodesToConnect.length-1]];

        int foundConnections = 1;
        System.out.println("Reached tricky part...");
        for(int i = 0; i < notConnectedNodes.length; i++) { //At least this many times to find them all
            System.out.println( "main loop " + i + " for search, found connections " + foundConnections);

            //This mess of a code is for debugging
            System.out.print("connected array: ");
            for(int l = 0; l < connectedNodes.length; l++) if(connectedNodes[l] != null) System.out.print(connectedNodes[l].TEST_ID + " ");
            System.out.println();
            System.out.print("not connected array: ");
            for(int l = 0; l < notConnectedNodes.length; l++) if(notConnectedNodes[l] != null) System.out.print(notConnectedNodes[l].TEST_ID + " ");
            boolean didWeFindAConnectionInThisIteration = false; //If we don't find a connection by the end of the current run, there's no further connection
            System.out.println();

            for(int j = 0; j < foundConnections; j++) { //Check all elements of connected nodes
                System.out.println("checking connected node " + j + " for connections, with id " + connectedNodes[j].TEST_ID);

                for(int k = 0; k < notConnectedNodes.length-foundConnections+1; k++) { //Check all elements of not connected nodes for each node
                    System.out.println("checking if aforementioned node is adjacent to node " + k + " with id " + notConnectedNodes[k].TEST_ID);

                    if(connectedNodes[j].isConnected(notConnectedNodes[k])) { //We found a connection
                        System.out.println("Connection found!");
                        didWeFindAConnectionInThisIteration = true;
                        connectedNodes[foundConnections] = notConnectedNodes[k];
                        Node[] temp = new Node[notConnectedNodes.length-1];
                        ArrayOperations.leaveOneOut(notConnectedNodes,temp,k);
                        notConnectedNodes = temp;
                        foundConnections++;
                    }
                }
            }
            if(didWeFindAConnectionInThisIteration == false) {
                System.out.println("No connection found");
                return false;
            }
            if(connectedNodes.length == foundConnections) {
                System.out.println("We found all connections early");
                return true;
            }
        }
        return true;

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
        void addConnections(Node[] connections) {
            this.connections = connections;
        }
        boolean isConnected(Node isThisNodeConnected) {
            for(Node n : connections) if(n == isThisNodeConnected) return true;
            return false;
        }

    }

}
