/**
 * Tells the shortest path from one node of the graph to another in weighted graphs
 * This class might be flawed but is very rarely used
 */

package Routers;

import Assets.ArrayOperations;

public class AdvancedGraphRouter {

    Node[] content;
    int dest;

    public int[] route(int start, int dest) {

        this.dest = dest;
        for(Node n : content) {
            n.routeValue = -1;
            n.prevRoute = new int[0];
        }

        content[start].route(0,new int[]{});

        int[] end = new int[content[dest].prevRoute.length+1];
        for(int i = 0; i < content[dest].prevRoute.length; i++) {
            end[i] = content[dest].prevRoute[i];
        }
        end[end.length-1] = content[dest].routeValue;
        return end;

    }

    AdvancedGraphRouter(int numberOfNodes) {
        content = new Node[numberOfNodes];
        for(int i = 0; i < content.length; i++) content[i] = new Node(i);
    }

    void setConnection(int n1, int n2, int weight) {
        Node[] connections = new Node[2];
        connections[0] = content[n1];
        connections[1] = content[n2];
        new Connection(connections,weight);
    }

    class Node {

        int id;
        Connection[] connections = new Connection[0];
        int[] prevRoute = new int[0];
        int routeValue = -1;

        Node(int id) {
            this.id = id;
        }

        void connect(Connection c) {
            Connection[] temp = new Connection[connections.length + 1];
            ArrayOperations.addToArray(connections,c,temp);
            connections = temp;
        }

        void route(int givenValue, int[] receivedRoute) {
            if(routeValue == -1 || givenValue < routeValue) {
                routeValue = givenValue;
                int[] temp = new int[receivedRoute.length+1];
                for(int i = 0; i < receivedRoute.length; i++) {
                    temp[i] = receivedRoute[i];
                }
                temp[temp.length-1] = id;
                prevRoute = temp;
                for(int i : prevRoute) System.out.print(i+"");
                System.out.println();
                if(dest != id) {
                    for(Connection c : connections) {
                        c.getNode(this).route(routeValue + c.weight,prevRoute);
                    }
                }
            }
        }

    }

    class Connection {

        int weight;
        Node[] connections;

        Connection(Node[] connections,int weight) {
            this.weight = weight;
            this.connections = connections;
            for(Node n : connections) n.connect(this);
        }

        Node getNode(Node n) {
            for(Node node : connections) if(n != node) return node;
            return new Node(-1); // we fucked up :(
        }

    }

}
