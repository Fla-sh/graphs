package com.ptl.graph_utils;

public class GraphElement {
    /**
     * class used to describe elements of graph
     * each element consist:
     *      label    -  integer
     *      data     -  string
     * class by its own provide node numeration, which can't be affected
     * by user so each number appears only once
     */
    private static Integer numerator = 0;
    private Integer label;
    private String data;

    public GraphElement(String data){
        this.data = data;
        this.label = this.numerator;
        this.numerator++;
    }

    public String getData(){
        return data;
    }

    public Integer getLabel(){
        return label;
    }

    public static Integer getNumerator(){
        return numerator;
    }
}
