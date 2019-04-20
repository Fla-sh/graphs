package com.ptl.GraphEdgeList;

import com.ptl.graph_utils.Pair;
import com.ptl.graph_utils.Sample;
import com.ptl.measurement.GraphRepresentation;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph extends GraphRepresentation {
    private Integer size;
    private Integer maxElementValue;
    private ArrayList<com.ptl.graph_utils.Pair> graph;
    private ArrayList<Integer> topoSorted;
    private ArrayList<Integer> remainingToSort;
    private Boolean[] visited;

    public Graph(){
        graph = new ArrayList<>();
    }

    public String name(){
        return "Edge List";
    }

    public void load(Sample toConvert){
        maxElementValue = toConvert.getSize() - 1;
        convert(toConvert);
    }

    private void convert(Sample toConvert){
        Integer size = toConvert.getSize();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(toConvert.getField(i, j) == 1) graph.add(new Pair(j, i));
            }
        }
        this.size = graph.size();
    }

    public void print(){
        Integer size = graph.size();
        for(int i = 0; i < size; i++){
            System.out.println(graph.get(i).toStr());
        }
    }

    public ArrayList<Integer> topoSortDFS(){
        visited = new Boolean[maxElementValue + 1];
        topoSorted = new ArrayList<>();
        remainingToSort = new ArrayList<>();
        Integer startAt = Math.round((maxElementValue + 1) / 4);

        for (int i = 0; i < maxElementValue + 1; i++){
            visited[i] = false;
            remainingToSort.add(i);
        }

        visited[startAt] = true;
        DFS(startAt);

        while(remainingToSort.size() != 0){
            visited[remainingToSort.get(0)] = true;
            DFS(remainingToSort.get(0));
        }

        return topoSorted;
    }

    private void DFS(Integer next){
        for(Pair node : graph){
            if(node.first() == next && !visited[node.second()]){
                visited[node.second()] = true;
                DFS(node.second());
            }
        }
        topoSorted.add(next);
        remainingToSort.remove(next);
    }

    public ArrayList<Integer> topoSortBFS(){
        Integer[] inRanks = new Integer[maxElementValue + 1];
        topoSorted = new ArrayList<>();
        Arrays.fill(inRanks, 0);
        for(Pair node : graph){
            inRanks[node.second()]++;
        }

        for(int i = 0; i < maxElementValue + 1; i++){
            for(int j = 0; j < maxElementValue + 1; j++){
                if(inRanks[j] == 0){
                    inRanks[j] = -1;
                    for(Pair node : graph){
                        if(node.first() == j){
                            inRanks[node.second()]--;
                        }
                    }
                    topoSorted.add(j);
                }
            }
        }
        return topoSorted;
    }
}
