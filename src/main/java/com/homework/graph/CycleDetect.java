package com.homework.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a directed graph, check whether there is a cycle in it.
* There can be multiple cycles
* We don't need to print all the cycles. Just return a boolean true/false if there is/isnot at least one cycle respectively
Solution: http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */

class CycleGraph extends SimpleGraph{


    public CycleGraph(int size) {
        super(size);
    }


    public boolean isCyclic() {
        boolean cyclicFlag = false;
        boolean [] isVisited = new boolean[ size];
        Arrays.fill(isVisited, false);
        List<Integer> recStack  = new ArrayList<>(); // Track recursive vertices here

        for(int i=0; i < size; i++){
            if(!isVisited[i]) {
                recStack.add(i);
                cyclicFlag = isCyclic(i, isVisited, recStack );
                if(cyclicFlag) break;
            }
        }//For loop of Adjacent list

        return cyclicFlag;
    }

    private  boolean isCyclic(int i, boolean [] isVisited, List<Integer> recStack){

        isVisited[i] = true;
        recStack.add(i);
        System.out.print(i + " ");

        LinkedList<Integer> list = adjacentList[i];
        if(list != null) {
            for(Integer v : list) {
                if(v != null && !isVisited[v]) {
                    if(isCyclic(v, isVisited,  recStack)) return true;
                }else if ( recStack.contains(i)){
                    return true;
                }
            }
        }
        recStack.remove(i);
        return false;
    }


}


public class CycleDetect {
    public static void main(String[] args) {

        CycleGraph graph1 = new CycleGraph(4);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(1,2);
        graph1.addEdge(2,0);
        graph1.addEdge(2,3);
        graph1.addEdge(3,3);

        System.out.println("Cycle Detection ....." + graph1.isCyclic());


        CycleGraph graph2 = new CycleGraph(4);
        graph2.addEdge(0,1);
        graph2.addEdge(0,2);
        graph2.addEdge(2,3);


        System.out.println("Cycle Detection ....." + graph2.isCyclic());

    }

}
