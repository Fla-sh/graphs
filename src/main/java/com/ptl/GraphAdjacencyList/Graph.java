package com.ptl.GraphAdjacencyList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * LISTA NASTENIKOW
 */

public class Graph {
    private HashMap<Integer, ArrayList<Integer>> graph;
    private Integer size;

    public Graph(com.ptl.graph_utils.Graph graphToconvert){
        size = graphToconvert.getSize();
        this.graph = new HashMap<>();
        instanitateGraph();
        convert(graphToconvert);
    }

    private void instanitateGraph(){
        for(int i = 0; i < size; i++){
            this.graph.put(i, new ArrayList<Integer>());
        }
    }

    private void convert(com.ptl.graph_utils.Graph toConvert){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(toConvert.getField(i, j) == 1) graph.get(i).add(j);
            }
        }
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.print(i + " | " + graph.get(i) + "\n");
        }
    }
}
