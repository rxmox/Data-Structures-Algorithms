import java.util.*;

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
      // create another new edge with the ending point node, starting point node, and weight for bidirectional edge
      Edge reverseEdge = new Edge(endingPointNode, startingPointNode, weight);

      // add the new edges
      startingPointNode.edges.add(newEdge);
      // add the reverse edge to the ending point node's edges list to make it bidirectional
      endingPointNode.edges.add(reverseEdge);
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

  // print the distance and shortest path from source to a node (id = nodeID) using city names
  void printDistanceAndShortestPathFromSource(int nodeID, HashMap<Integer, String> idToCity){
   Node u = this.getNode(nodeID);
   if(u.distance == Graph.INF){
       System.out.println("There is no path from source to " + idToCity.get(u.id) + ".");
       return;
   }
   System.out.print("The distance of the shortest path from source to " + idToCity.get(u.id) + " is " + u.distance + " hours, and the shortest path is ");
   ArrayList<Node> path = this.getShortestPathFromSource(u);
   for(int i = 0; i < path.size(); i++){
       if(i != 0){
           System.out.print(" -> ");
       }
        System.out.print(idToCity.get(path.get(i).id));
    }
    System.out.println(".");
  }


  // Removes all edges connected to a given node
  void removeEdgesConnectedTo(int nodeID) {
    for (Node n : nodes) {
        n.edges.removeIf(e -> e.endingPointNode.id == nodeID || e.startingPointNode.id == nodeID);
    }
  }

  // Build the graph with the cities and flight durations, by adding edges between cities
  void buildCanadaGraph(Map<String, Integer> cityIds) {
    this.addEdge(cityIds.get("Vancouver"), cityIds.get("Calgary"), 1);
    this.addEdge(cityIds.get("Vancouver"), cityIds.get("Edmonton"), 2);
    this.addEdge(cityIds.get("Vancouver"), cityIds.get("Toronto"), 6);
    this.addEdge(cityIds.get("Edmonton"), cityIds.get("Montreal"), 5);
    this.addEdge(cityIds.get("Calgary"), cityIds.get("Toronto"), 4);
    this.addEdge(cityIds.get("Toronto"), cityIds.get("Saskatoon"), 3);
    this.addEdge(cityIds.get("Toronto"), cityIds.get("Montreal"), 1);
    this.addEdge(cityIds.get("Montreal"), cityIds.get("Fredericton"), 1);
  }
}

public class Bonus{
  public static void main(String[] args) {
    
    //map each city name to an integer ID to use with graph nodes
    HashMap<String, Integer> cityIds = new HashMap<>();
        cityIds.put("Vancouver", 0);
        cityIds.put("Calgary", 1);
        cityIds.put("Edmonton", 2);
        cityIds.put("Toronto", 3);
        cityIds.put("Montreal", 4);
        cityIds.put("Saskatoon", 5);
        cityIds.put("Fredericton", 6);
    
    // Create a reverse mapping from node IDs to city names for printing the path
    HashMap<Integer, String> idToCity = new HashMap<>();
    for (Map.Entry<String, Integer> entry : cityIds.entrySet()) {
        idToCity.put(entry.getValue(), entry.getKey());
    }

    // Create a graph with 7 nodes (one for each city)
    Graph graph = new Graph(7);
    // Build the graph with flight durations
    graph.buildCanadaGraph(cityIds);


    // Part A: Run Dijkstra's algorithm from Calgary to all destinations
    graph.dijkstraShortestPath(cityIds.get("Calgary"));
    // Print the shortest path from Calgary to Fredericton using city names
    graph.printDistanceAndShortestPathFromSource(cityIds.get("Fredericton"), idToCity);


    // Part B: Handle the snowstorm scenario by removing edges connected to Toronto
    graph.removeEdgesConnectedTo(cityIds.get("Toronto"));
    // Run Dijkstra's algorithm from Calgary to all destinations after the snowstorm
    graph.dijkstraShortestPath(cityIds.get("Calgary"));
    // Print the shortest path from Calgary to Fredericton after the snowstorm using city names
    graph.printDistanceAndShortestPathFromSource(cityIds.get("Fredericton"), idToCity);
  }
}