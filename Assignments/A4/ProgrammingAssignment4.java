/*
    Here is the code skeleton for the fourth programming assignment.
    Complete the missing parts according to the PA-4 specs.

    TODOs:
        (1) implement Graph.addEdge(int startingPointNodeID, int endingPointNodeID, int weight) (1 mark)
        (2) complete the custom compare function for nodes (1 mark)
        (3) complete the Initialization of the distance and shortestPathParent variables of the source node (1 mark)
        (4) complete the Initialization of the distance and shortestPathParent variables of nodes other than source (1 mark)
        (5) complete the main loop of Dijkstra's algorithm (4 marks)
        (6) implement Graph.getShortestPathFromSource(Node u) (1 mark)

    Make sure you *understand* the algorithms and implement the missing parts on *your own*.
    Comment every line of code, clearly describing what is going on, and the rationale for your choices.
    "" DO NOT CHANGE THE REST OF THE SKELETON CODE ""

====================================================================================

    Student's full name: Omar Ahmed

    Student's UCID: 30154382

====================================================================================
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// Graph edge class
class Edge{
    Node startingPointNode, endingPointNode;
    int weight;

    Edge(Node startingPointNode, Node endingPointNode, int weight){
        this.startingPointNode = startingPointNode;
        this.endingPointNode = endingPointNode;
        this.weight = weight;
    }
}

// Graph node class
class Node{
    // id is the unique number for each node (0 <= id < number of nodes)
    // distance is the distance from source in the Dijkstra's algorithm
    int id, distance;
    // shortestPathParent is the parent node in the Dijkstra's shortest path from source
    Node shortestPathParent;
    // edges is a list of edges going out from current node
    ArrayList <Edge> edges;

    Node(int id){
        this.id = id;
        this.distance = -1;
        this.shortestPathParent = null;
        this.edges = new ArrayList <Edge> ();
    }

    // add an out going edge from current node
    void addEdge(Node endingPointNode, int weight){
        Edge edge = new Edge(this, endingPointNode, weight);
        this.edges.add(edge);
    }
}

// Graph class
class Graph{
    // INF is the infinity value used in the Dijkstra's algorithm
    static final int INF = 1000000;

    // numberOfNodes is the number of nodes in the graph
    int numberOfNodes;
    // nodes is the list of nodes in the graph
    ArrayList <Node> nodes;

    Graph(int numberOfNodes){
        this.numberOfNodes = numberOfNodes;
        this.nodes = new ArrayList <Node> ();
        // creating nodes with unique ids (0 <= id < number of nodes)
        for(int id = 0; id < this.numberOfNodes; id++){
            this.nodes.add(new Node(id));
        }
    }

    // get the node with a specific id
    Node getNode(int nodeID){
        return this.nodes.get(nodeID);
    }

    // add an edge from a node (id = startingPointNodeID) to another node (id = endingPointNodeID)
    void addEdge(int startingPointNodeID, int endingPointNodeID, int weight){
        // TODO-1
        // get the starting point node and ending point node
        Node startingPointNode = this.getNode(startingPointNodeID);
        Node endingPointNode = this.getNode(endingPointNodeID);

        // create a new edge with the starting point node, ending point node, and weight
        Edge newEdge = new Edge(startingPointNode, endingPointNode, weight);

        // add the new edge to the starting point node's edges list
        startingPointNode.edges.add(newEdge);
    }

    // Dijkstra's algorithm
    void dijkstraShortestPath(int sourceNodeID){
        Comparator <Node> customComparator = new Comparator <Node> (){
            @Override
            public int compare(Node firstNode, Node secondNode){

                // compare firstNode and secondNode based on their distances from th source node
                // TODO-2
                // if the distance of the first node is less than the distance of the second node, return -1
                // if the distance of the first node is greater than the distance of the second node, return 1
                // if the distances of the two nodes are equal, return 0

                //return firstNode.distance - secondNode.distance;
                return Integer.compare(firstNode.distance, secondNode.distance);
            }
        };
        PriorityQueue <Node> pq = new PriorityQueue <Node> (customComparator);

        Node source = this.getNode(sourceNodeID);

        for(int id = 0; id < this.numberOfNodes; id++){
            if(id == source.id){

                // initialize the distance and shortestPathParent variables of the node (id = source.id)
                // TODO-3
                source.distance = 0;
                source.shortestPathParent = null;

            }else{

                // initialize the distance and shortestPathParent variables of the nodes that are not source node
                // TODO-4
                // set the distance of the node to infinity
                this.nodes.get(id).distance = INF;
                // set the shortest path parent of the node to null
                this.nodes.get(id).shortestPathParent = null;
            }
            pq.add(this.nodes.get(id));
        }

        while(pq.isEmpty() == false){

            // TODO-5
            // main loop of Dijkstra's algorithm
            //take and remove the node with smallest distance (u)
            Node u = pq.poll();  // Poll retrieves and removes the head of the queue

            //update all its neighbors' distance and shortestPathParent, if necessary (make sure when you update the neighbors then the pq is updated as well!)
            for (Edge edge : u.edges) {
                Node v = edge.endingPointNode;
                int weight = edge.weight;

                // Calculate the new distance to v potentially via u
                int distanceThroughU = u.distance + weight;

                // Check if the new distance is shorter than the current distance
                if (distanceThroughU < v.distance) {
                // Update the distance
                v.distance = distanceThroughU;
                // Update the shortest path parent
                v.shortestPathParent = u;

                // Since PriorityQueue does not update automatically, reinsert the node.
                // Remove and re-add the node to update its position in the priority queue
                pq.remove(v);
                pq.add(v);
                }
            }
        }
    }

    // get the shortest path from source to u
    ArrayList <Node> getShortestPathFromSource(Node u){
        ArrayList <Node> path = new ArrayList <Node> ();

        // use the shortestPathParent variable of a node
        // TODO-6

        // starting with node u
        Node currentNode = u;

        // while the current node is not null
        while (currentNode != null) {
            // add the current node to the path
            path.add(currentNode);
            // move to the next node
            currentNode = currentNode.shortestPathParent;
        }

        // reverse the path
        Collections.reverse(path);

        return path;
    }

    // print the distance and shortest path from source to a node (id = nodeID)
    void printDistanceAndShortestPathFromSource(int nodeID){
        Node u = this.getNode(nodeID);
        if(u.distance == Graph.INF){
            System.out.println("There is no path from source to " + u.id + ".");
            return;
        }
        System.out.print("The distance of the shortest path from source to " + u.id + " is " + u.distance + ", and the shortest path is ");
        ArrayList <Node> path = this.getShortestPathFromSource(u);
        for(int i = 0; i < path.size(); i++){
            if(i != 0){
                System.out.print(" -> ");
            }
            System.out.print(path.get(i).id);
        }
        System.out.println(".");
    }
}

public class ProgrammingAssignment4{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // get number of nodes from user
        System.out.println("Please enter the number of nodes in the graph:");
        int n = scanner.nextInt();
        System.out.println();

        // create a graph with n nodes
        Graph graph = new Graph(n);

        // get number of edges from user
        System.out.println("Please enter the number of edges in the graph:");
        int m = scanner.nextInt();
        System.out.println();

        for(int i = 1; i <= m; i++){
            // get edge[i]
            System.out.println("Please enter the starting point node id (0: " + (n - 1) +"), ending point node id (0: " + (n - 1) +"), and the weight of the edge[" + i + "]:");
            int startingPointNodeID = scanner.nextInt();
            int endingPointNodeID = scanner.nextInt();
            int weight = scanner.nextInt();
            System.out.println();

            graph.addEdge(startingPointNodeID, endingPointNodeID, weight);
        }

        // get id of the source node from user
        System.out.println("Please enter the source node id for Dijkstra's algorithm:");
        int sourceNodeID = scanner.nextInt();
        System.out.println();

        // run the Dijkstra's algorithm
        graph.dijkstraShortestPath(sourceNodeID);

        for(int id = 0; id < n; id++){
            // print the distance and shortest path from source to node with id = id
            graph.printDistanceAndShortestPathFromSource(id);
        }

        scanner.close();
    }
}
