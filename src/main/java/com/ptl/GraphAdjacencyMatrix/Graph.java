package com.ptl.GraphAdjacencyMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Graph {
    private Integer[][] graph;
    private Integer size;
    private Boolean[] visited;
    private ArrayList<Integer> topoSorted;
    private ArrayList<Integer> remainingToSort;

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

    public ArrayList<Integer> topoSortDFS(){
        remainingToSort = new ArrayList<>();
        visited = new Boolean[size];
        topoSorted = new ArrayList<>();
        Integer startAt = Math.round(size / 10);

        for(int i = 0; i < size; i++){
            remainingToSort.add(i);
            visited[i] = false;
        }

        DFS(startAt);

        while(remainingToSort.size() != 0){
            DFS(remainingToSort.get(0));
        }
        return topoSorted;
    }

    private void DFS(Integer vertex){
        Integer next = 0;
        while(next < size){
            if(graph[vertex][next] == 1 && !visited[next]){
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
        Integer[] outRanks = new Integer[size];

        for(int i = 0; i < size; i++){
            outRanks[i] = 0;
            for(int j = 0; j < size; j++){
                outRanks[i] += graph[i][j];
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(outRanks[j] == 0){
                    outRanks[j] = -1;
                    for(int z = 0;  z < size; z++){
                        outRanks[z] -= 1 * graph[z][j];
                    }
                    topoSorted.add(j);
                }
            }
        }
        return topoSorted;
    }
}
