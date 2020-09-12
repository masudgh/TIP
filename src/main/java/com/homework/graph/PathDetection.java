package com.homework.graph;


import java.util.Arrays;
import java.util.LinkedList;

class PathGraph extends SimpleGraph {

    public PathGraph(int size) {
        super(size);
    }

    public boolean isPathExist(int start, int end){

        boolean [] isVisited = new boolean[ size];
        Arrays.fill(isVisited, false);

        if (hasVertex(start)) {
            return isPathExist(start, isVisited, end);
        }
        return false;
    }

    public boolean isPathExist( int i, boolean [] isVisited,  int end){
        isVisited[i] = true;
        LinkedList<Integer> list = adjacentList[i];
        if(list != null) {
            for(Integer v : list) {
                if(v != null && !isVisited[v]) {
                    if (isPathExist(v, isVisited,  end)) return true;
                    else if ( v == end){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

public class PathDetection {

    public static void main(String[] args) {
        PathGraph graph1 = new PathGraph(5);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(2,3);
        graph1.addEdge(3,4);

        System.out.println("Path Detection 0 to 4....." + graph1.isPathExist(0,4));

        System.out.println("Path Detection 1 to 4....." + graph1.isPathExist(1,4));

    }
}
