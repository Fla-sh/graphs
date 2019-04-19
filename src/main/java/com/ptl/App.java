package com.ptl;
import com.ptl.graph_utils.Graph;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        Graph graph = new Graph(5, 0.95f);
        graph.print();
        com.ptl.GraphAdjacencyMatrix.Graph AGraph = new com.ptl.GraphAdjacencyMatrix.Graph(graph);
        System.out.println(AGraph.topoSortBFS());
    }
}
