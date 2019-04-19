package com.ptl.GraphAdjacencyMatrix;

import java.util.Arrays;

public class Graph {
    private Integer[][] graph;
    private Integer size;

    public Graph(com.ptl.graph_utils.Graph toConvert){
        size = toConvert.getSize();
        graph = new Integer[size][size];
        convert(toConvert);
    }

    private void convert(com.ptl.graph_utils.Graph toConvert){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                graph[i][j] = toConvert.getField(i, j);
            }
        }
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.println(Arrays.asList(graph[i]));
        }
    }
}
