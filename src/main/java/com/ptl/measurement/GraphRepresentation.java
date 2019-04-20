package com.ptl.measurement;

import com.ptl.graph_utils.Sample;

import java.util.ArrayList;

public abstract class GraphRepresentation {
    public abstract void print();
    public abstract void load(Sample graph);
    public abstract String name();
    public abstract ArrayList<Integer> topoSortDFS();
    public abstract ArrayList<Integer> topoSortBFS();
}
