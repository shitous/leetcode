// A Java Program to detect cycle in an undirected graph
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph
{
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List Represntation

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	boolean isCyclicUtil(boolean [] visited, int v, int parent){
	    visited[v]= true;
	    int i; 
	    Iterator<Integer> it = adj[v].iterator();
	    while(it.hasNext()){
	        i=it.next();
	        if(!visited[i]){
	            if(isCyclicUtil(visited, i, v)) return true;
	        }
	        else{
	            if( i != parent) return true;
	        }
	    }
	    return false;
	}
	boolean isCyclic(){
	    boolean [] visited = new boolean [V];
	    for ( int i =0; i< visited.length; i++){
	        visited[i]=false;
	    }
	    for ( int i=0; i< adj.length; i++){
	        if(! visited[i]){
	            if( isCyclicUtil(visited, i, -1)) return true;
	        }
	    }
	    return false;
	}




	// Driver method to test above methods
	public static void main(String args[])
	{
		// Create a graph given in the above diagram
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		//g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.addEdge(3,2);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		Graph g2 = new Graph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}
}


    2. Detect Cycle in an undirected graph: BFS, DFS, Union Find

Detect Cycle in a directed graph: DFS, http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/


    enum Color {
        WHITE, GRAY, BLACK;
    }

    /**
     * http://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
     * WHITE : Vertex is not processed yet. Initially all vertices are WHITE.
     * 
     * GRAY : Vertex is being processed (DFS for this vertex has started, but
     * not finished which means that all descendants (ind DFS tree) of this
     * vertex are not processed yet (or this vertex is in function call stack)
     * 
     * BLACK : Vertex and all its descendants are processed.
     * 
     * While doing DFS, if we encounter an edge from current vertex to a GRAY
     * vertex, then this edge is back edge and hence there is a cycle.
     */
     // 1 -> 3
     // 1 -> 2, 2 -> 3
    public boolean hasCycle(GraphNode rootNode) {
        // you can actually use two sets, one for processing and one for
        // processed, this way you save space
        return hasCycle(rootNode, new HashMap<>());
    }

    private boolean hasCycle(GraphNode rootNode, Map<GraphNode, Color> map) {
        if (rootNode == null) {
            return false;
        }
        // base case
        Color state = map.getOrDefault(rootNode, Color.WHITE);
        if (state == Color.GRAY) {
            return true;
        }
        map.put(rootNode, Color.GRAY);

        for (GraphNode node : rootNode.getChildren()) {
            if (hasCycle(node, map)) {
                return true;
            }
        }

        map.put(rootNode, Color.BLACK);
        return false;
    }
