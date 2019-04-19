package com.ptl.GraphEdgeList;

import com.ptl.graph_utils.Pair;

import java.util.ArrayList;

public class Graph {
    private Integer size;
    private ArrayList<com.ptl.graph_utils.Pair> graph;

    public Graph(com.ptl.graph_utils.Graph toConvert){
        graph = new ArrayList<>();
        convert(toConvert);
    }

    private void convert(com.ptl.graph_utils.Graph toConvert){
        Integer size = toConvert.getSize();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(toConvert.getField(i, j) == 1) graph.add(new Pair(i, j));
            }
        }
    }

    public void print(){
        Integer size = graph.size();
        for(int i = 0; i < size; i++){
            System.out.println(graph.get(i).toStr());
        }
    }

    public ArrayList<Integer> topoSortDFS(){
        ArrayList<Integer> result = new ArrayList<>();

        return result;
    }
}
