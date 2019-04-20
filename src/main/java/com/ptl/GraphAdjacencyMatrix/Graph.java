package com.ptl.GraphAdjacencyMatrix;

import com.ptl.graph_utils.Sample;
import com.ptl.measurement.GraphRepresentation;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph extends GraphRepresentation {
    private Integer[][] graph;
    private Integer size;
    private Boolean[] visited;
    private ArrayList<Integer> topoSorted;
    private ArrayList<Integer> remainingToSort;

    public Graph(){
    }

    public String name(){
        return "Adjacency Matrix";
    }

    public void load(Sample toConvert){
        size = toConvert.getSize();
        graph = new Integer[size][size];
        convert(toConvert);
    }

    private void convert(Sample toConvert){
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

    public ArrayList<Integer> topoSortDFS(){
        remainingToSort = new ArrayList<>();
        visited = new Boolean[size];
        topoSorted = new ArrayList<>();
        Integer startAt = Math.round(size / 10);

        for(int i = 0; i < size; i++){
            remainingToSort.add(i);
            visited[i] = false;
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
        Integer next = 0;
        while(next < size){
            if(graph[next][vertex] == 1 && !visited[next]){
                visited[next] = true;
                DFS(next);
            }
            next++;
        }
        topoSorted.add(vertex);
        remainingToSort.remove(vertex);
    }

    public ArrayList<Integer> topoSortBFS(){
        topoSorted = new ArrayList<>();
        Integer[] inRanks = new Integer[size];

        for(int i = 0; i < size; i++){
            inRanks[i] = 0;
            for(int j = 0; j < size; j++){
                inRanks[i] += graph[i][j];
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(inRanks[j] == 0){
                    inRanks[j] = -1;
                    for(int z = 0;  z < size; z++){
                        inRanks[z] -= 1 * graph[z][j];
                    }
                    topoSorted.add(j);
                }
            }
        }
        return topoSorted;
    }
}
