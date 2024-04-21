import java.util.*;

public class AdjacencyListGraph {
    private List<Integer>[] adjacencyList;
    private int numVertices;

    public AdjacencyListGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = (List<Integer>[]) new List[numVertices];
        
        // Initialize each element of the array to ArrayList
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        // For undirected graph, uncomment the line below
        // adjacencyList[destination].add(source);
    }

    public void display() {
        for (int i = 0; i < numVertices; i++) {
            if(adjacencyList[i].size() == 0){
                continue;
            }
            System.out.print(i + " -> ");
            for (Integer neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.display();
    }
}
