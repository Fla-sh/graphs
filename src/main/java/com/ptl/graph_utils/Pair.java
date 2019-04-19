package com.ptl.graph_utils;

public class Pair {
    private Integer first;
    private Integer second;

    public Pair(Integer first, Integer second){
        this.first = first;
        this.second = second;
    }

    public Integer first(){
        return this.first;
    }

    public Integer second(){
        return second;
    }

    public String toStr(){
        return this.first + " " + this.second;
    }
}
