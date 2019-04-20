package com.ptl.GraphAdjacencyList;

import com.ptl.graph_utils.Sample;
import com.ptl.measurement.GraphRepresentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * LISTA NASTENIKOW
 */

public class Graph extends GraphRepresentation {
    private HashMap<Integer, ArrayList<Integer>> graph;
    private Integer size;
    private Boolean[] visited;
    private ArrayList<Integer> topoSorted;
    private ArrayList<Integer> remainingToSort;


    public Graph(){
        this.graph = new HashMap<>();
    }

    public String name(){
        return "Adjacency List";
    }

    public void load(Sample graphToconvert){
        size = graphToconvert.getSize();
        instanitateGraph();
        convert(graphToconvert);
    }

    private void instanitateGraph(){
        for(int i = 0; i < size; i++){
            this.graph.put(i, new ArrayList<Integer>());
        }
    }

    private void convert(Sample toConvert){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(toConvert.getField(i, j) == 1) graph.get(j).add(i);
            }
        }
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.print(i + " | " + graph.get(i) + "\n");
        }
    }

    public ArrayList<Integer> topoSortDFS(){
        visited = new Boolean[size];
        topoSorted = new ArrayList<>();
        remainingToSort = new ArrayList<>();
        Integer startAt = Math.round(size / 4);

        for(int i = 0; i < size; i++){
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

    private void DFS(Integer vertex){
        ArrayList<Integer> nodes = graph.get(vertex);
        for(Integer node : nodes){
            if(!visited[node]){
                visited[node] = true;
                DFS(node);
            }
        }
        topoSorted.add(vertex);
        remainingToSort.remove(vertex);
    }

    public ArrayList<Integer> topoSortBFS(){
        topoSorted = new ArrayList<>();
        Integer[] inRanks = new Integer[size];

        Arrays.fill(inRanks, 0);
        for(int i = 0; i < size; i++){
            for(Integer element : graph.get(i)){
                inRanks[element]++;
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(inRanks[j] == 0){
                    inRanks[j] = -1;
                    for(Integer element : graph.get(j)){
                        inRanks[element]--;
                    }
                    topoSorted.add(j);
                }
            }
        }
        return topoSorted;
    }
}
