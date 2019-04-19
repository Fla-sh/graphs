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
        com.ptl.GraphAdjacencyList.Graph AGraph = new com.ptl.GraphAdjacencyList.Graph(graph);
        AGraph.print();
        System.out.println(AGraph.topoSortBFS());
    }
}
