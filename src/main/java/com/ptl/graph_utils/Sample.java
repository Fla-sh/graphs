package com.ptl.graph_utils;

import java.util.Arrays;
import java.util.Random;

public class Sample {

    private Integer[][] graph;
    private Integer size;

    public Sample(Integer size){
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

    /**
     *
     * @return size of outer array, so the maximal value of element
     */
    public Integer getSize(){
        return size;
    }

    public Integer getField(Integer x, Integer y){
        return graph[x][y];
    }

    private void fillConnections(){
        Integer startsAt = 1;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(j >= startsAt) graph[i][j] = 1;
                else graph[i][j] = 0;
            }
            startsAt++;
        }
    }
}
