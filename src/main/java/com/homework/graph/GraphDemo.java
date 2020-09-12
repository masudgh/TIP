package com.homework.graph;

/*
Implement a simple unweighted Graph class with following operations:
+addEdge()
+printUsingBFS()
+printUsingDFS()
+findShortestDistance(src, dst) //return number of hops
+isPathExist(src, dst).  //if path exists between the two vertext
 */



import java.util.*;

class QueueNode{
     int vertex;
     int dis; //Distance between start to this node
     List<QueueNode> nodeList;

     public QueueNode(int vertex, int dis) {
         this.vertex = vertex;
         this.dis = dis;
         nodeList = new ArrayList<>();
     }
 }

class SimpleGraph {

    LinkedList<Integer> [] adjacentList ; //Array of linked list, represents all the adjacent list
    int size=0;

    public SimpleGraph(int size) {
        this.size = size;
        if(size <=0 ) { //Default graph size
            this.size = 10;
        }
        adjacentList = new LinkedList[this.size];
        Arrays.fill(adjacentList,null);  //Default edges are null
    }

    public void addEdge(int vertex , int connected)   {

        LinkedList<Integer> list;
        try {
            list=adjacentList[vertex];
            if (list == null) {
                list = new LinkedList<>();
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println( String.format("The edge  from vertex %s to node %s can not be connected, because the " +
                            "graph exceed its size limit %s ", vertex, connected, size));
            return;
        }
        list.add(connected);
        adjacentList[vertex] = list;

    }

    //BFS Printing
    public void printUsingBFS(){
        Deque<Integer> deque = new ArrayDeque<>();
        boolean [] isVisited = new boolean[ size];
        Arrays.fill(isVisited, false);

        for(int i=0; i < size; i++){

            if(!isVisited[i]){
                deque.offer(i); //????
                isVisited[i]=true;
            }

            while(!deque.isEmpty()){
                Integer vertex = deque.poll(); //Get the current vertex and print
                System.out.print(vertex+ " ");

                //get the siblings and print
                LinkedList<Integer> siblings = adjacentList [i];

                if(siblings!=null) {
                    for (Integer c : siblings) {
                        if (c != null && !isVisited[c]) {
                            deque.offer(c);
                            isVisited[c] = true;
                        }
                    }// For lop of Sibling
                }

            }//While

        }//For loop of Adjacent list
        System.out.println();
    }// End of Print


    //DFS Printing
    public void  printUsingDFS(){
        boolean [] isVisited = new boolean[ size];
        Arrays.fill(isVisited, false);

        for(int i=0; i < size; i++){
            if(!isVisited[i])
                dfs(i, isVisited);
        }//For loop of Adjacent list
        System.out.println();
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



    // Shortest distance - non-weight graph (Use BSF) -best available approach
    public int findShortestDistance( int start, int end){
        int noHops =0 ;
        Deque<QueueNode> deque = new ArrayDeque<>();
        boolean [] isVisited = new boolean[ size];
        Arrays.fill(isVisited, false);


        if(!isVisited[start]){
            deque.offer(new QueueNode(start,0)); //????
            isVisited[start]=true;
        }

        while(!deque.isEmpty()){
            QueueNode queueNode = deque.poll(); //Get the current vertex
            Integer vertex = queueNode.vertex;
            int dist = queueNode.dis;
            if( vertex == end){
                return dist;
            }

            //get the siblings and print
            LinkedList<Integer> siblings = adjacentList [vertex];

            if(siblings!=null) {
                for (Integer c : siblings) {
                    if (c != null && !isVisited[c]) {

                        deque.offer(new QueueNode(c,dist+1));
                        isVisited[c] = true;

                    }
                }// For lop of Sibling
            }

        }//While

        return -1;
    }// End of method




    //Check path between the vertex
    public boolean isPathExist(int start, int end){

        boolean [] isVisited = new boolean[ size];
        Arrays.fill(isVisited, false);

        LinkedList<Integer> list = null;
        boolean  isAlive = false;
        for(int i=0; i < size; i++){
            if( i == start){
                isAlive =  isPathExist(i, isVisited, end);
                break;
            }
        }//For loop of Adjacent list

        //For loop of Adjacent list
        return isAlive;

    }

    private  boolean isPathExist (int i, boolean [] isVisited,  int end){

        isVisited[i] = true;

        if( i == end ) return true;

        LinkedList<Integer> list = adjacentList[i];
        if(list != null) {
            for(Integer v : list) {
                if(v != null && !isVisited[v]) {
                    if (isPathExist(v, isVisited, end)) return true;
                }
            }
        }

        return false;
    }

}





public class GraphDemo {

    public static void main ( String [] args){

        SimpleGraph graph = new SimpleGraph(7);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(4,0);
        graph.addEdge(3,0);
        graph.addEdge(5,6);

        System.out.println("BFS printing .....");
        graph.printUsingBFS();


        System.out.println("DFS printing .....");
        graph.printUsingDFS();

        System.out.println("Shortest distance 1 and 4: " + graph.findShortestDistance(1,4));
        System.out.println("Shortest distance 1 and 5: " + graph.findShortestDistance(1,5));

        System.out.println("Is path exist between 0 and 4: " + graph.isPathExist(1,4));
        System.out.println("Is path exist between 1 and 5: " + graph.isPathExist(1,5));

    }



}
