package com.homework.graph;

import java.util.Arrays;
import java.util.LinkedList;

class ConnectedGraph extends SimpleGraph{

    public ConnectedGraph(int size) {
        super(size);
    }

    //DFS Printing
    public void  printConnectedVertex(){
        boolean [] isVisited = new boolean[ size];
        Arrays.fill(isVisited, false);

        for(int i=0; i < size; i++){
            if(!isVisited[i]) {
                dfs(i, isVisited);
                System.out.println();
            }
        }//For loop of Adjacent list

    }




    private  void dfs (int i, boolean [] isVisited){

        isVisited[i] = true;
        System.out.print(i + " ");

        LinkedList<Integer> list = adjacentList[i];
        if(list != null) {
            for(Integer v : list) {
                if(v != null && !isVisited[v]) {
                    dfs(v, isVisited);
                }
            }
        }

    }


}
public class ConnectedVertex {

    public static void main(String[] args){
        ConnectedGraph graph1 = new ConnectedGraph(8);
        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(2,3);
        graph1.addEdge(3,4);

        graph1.addEdge(5,6);
        graph1.addEdge(6,7);

        System.out.println("Print connected vertexs ..." );

        graph1.printConnectedVertex();
    }
}
