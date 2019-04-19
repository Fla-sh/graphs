package com.ptl.graph_utils;

import java.util.Arrays;
import java.util.Random;

public class Graph {

    private Integer[][] graph;
    private Integer size;

    public Graph(Integer size, Float density){
        this.size = size;
        graph = new Integer[size][size];
        fillConnections();
    }

    public void print(){
        /**
         * function prints graph described by its class
         */
        for(int i = 0; i < size; i++){
            System.out.println(Arrays.asList(graph[i]));
        }
    }

    public Integer getSize(){
        return size;
    }

    public Integer getField(Integer x, Integer y){
        return graph[x][y];
    }

    private void fillConnections(){
        Integer endsAt = size - 1;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(j <= endsAt) graph[i][j] = 1;
                else graph[i][j] = 0;
            }
            endsAt--;
        }
    }
}
