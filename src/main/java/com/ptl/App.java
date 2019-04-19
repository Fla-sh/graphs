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
        Graph graph = new Graph(10, 0.95f);
        graph.print();
        com.ptl.GraphEdgeList.Graph AGraph = new com.ptl.GraphEdgeList.Graph(graph);
        AGraph.print();
    }
}
