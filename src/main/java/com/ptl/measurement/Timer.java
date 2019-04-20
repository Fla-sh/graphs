package com.ptl.measurement;

import com.ptl.GraphAdjacencyMatrix.Graph;
import com.ptl.graph_utils.Sample;
import org.apache.commons.lang3.time.StopWatch;

import java.io.*;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

public class Timer {

    private final Integer[] sizes = {100, 500, 1000, 2000, 5000, 7500, 10000};
    private Sample[] testSamples;
    private StopWatch stopWatch;
    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;

    public Timer(){
        stopWatch = new StopWatch();
        createSamples();
        core();
    }

    private void createSamples(){
        testSamples = new Sample[sizes.length];
        Integer index = 0;
        for(Integer size : sizes){
            testSamples[index] = new Sample(size);
            index++;
        }
    }

    private void core(){
        GraphRepresentation[] graphs = {new com.ptl.GraphAdjacencyMatrix.Graph(),
                                        new com.ptl.GraphAdjacencyList.Graph(),
                                        /*new com.ptl.GraphEdgeList.Graph()*/};
        for(Sample sample : testSamples){
            for(GraphRepresentation graph : graphs){
                Long[] times = run(graph, sample);
                saveToFile(times, graph.name(), sample.getSize());
            }
            System.out.println();
        }
    }

    private void saveToFile(Long[] times, String representation, Integer size){
        try {
            fileWriter = new FileWriter("times.csv", true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(representation + "," + times[0] + "," + times[1] + "," + size + "\n");
            bufferedWriter.close();
            fileWriter.close();
            System.out.println(representation + ": " + size + " " + times[0] + " " + times[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Long[] run(GraphRepresentation graph, Sample sample){
        Long[] times = {0l, 0l};
        graph.load(sample);
        stopWatch.reset();

        stopWatch.start();
        graph.topoSortDFS();
        stopWatch.stop();
        times[0] = stopWatch.getTime(TimeUnit.MILLISECONDS);

        stopWatch.reset();

        stopWatch.start();
        graph.topoSortBFS();
        stopWatch.stop();
        times[1] = stopWatch.getTime(TimeUnit.MILLISECONDS);

        return times;
    }
}
