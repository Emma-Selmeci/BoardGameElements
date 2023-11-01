/**
 * Class to check if selected nodes of a graph are interconnected -> not entirely sure if it works correctly
 */

package Routers;

import Assets.ArrayOperations;

public class AdjacencyManager {

    Node[] content;

    public AdjacencyManager(int numberOfNodes) {
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

        for(int i = 0; i < 3; i++ )System.out.println();
        int foundConnections = 1;
        for(int i = 0; i < connectedNodes.length; i++) {

            if(connectedNodes[i] == null) return false; //if we haven't found any new connections during the last iteration, we are out
            if(connectedNodes[connectedNodes.length-1] != null) return true; //if we've already found all values (because we've found more than one in one turn

            System.out.print("connected array: ");
            for(int l = 0; l < connectedNodes.length; l++) if(connectedNodes[l] != null) System.out.print(connectedNodes[l].TEST_ID + " ");
            System.out.println();
            System.out.print("not connected array: ");
            for(int l = 0; l < notConnectedNodes.length; l++) if(notConnectedNodes[l] != null) System.out.print(notConnectedNodes[l].TEST_ID + " ");
            System.out.println();

            for(int j = 0; j < notConnectedNodes.length-foundConnections; j++) {
                System.out.println("Connection between node " + i + " with id " + connectedNodes[i].TEST_ID + " and node " + j + " with id " + notConnectedNodes[j].TEST_ID);
                if(connectedNodes[i] == null) return false;
                if(connectedNodes[i].isConnected(notConnectedNodes[j])) { //We found a connection
                    System.out.println("Connection found");
                    connectedNodes[foundConnections] = notConnectedNodes[j];
                    Node[] temp = new Node[notConnectedNodes.length];
                    ArrayOperations.leaveOneOut(notConnectedNodes,temp,j);
                    notConnectedNodes = temp;
                    foundConnections++;
                    j--;
                }
                System.out.println(foundConnections + "");
                System.out.println("Loop state " + j + " " + (notConnectedNodes.length-foundConnections));
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
