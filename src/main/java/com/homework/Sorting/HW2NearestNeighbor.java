package com.homework.Sorting;

/*
Given a point P, and other N points in two dimensional space, find K points out of the N points
which are nearest to P.
* Distance between two points is measured by standard euclidean method.
(Hint: This problem can either be done with QuickSort partitioning, or can be done with Heaps.
Which one would you use? Why? Why not try both in your IDE and see the runtime for large
inputs?)
Interview time: 45 minutes
Solution: http://stackoverflow.com/questions/20398799/find-k-nearest-points-to-point-p-in-2-
dimensional-plane
 */




import java.util.*;

public class HW2NearestNeighbor {


    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    // k  closest point
    private static List<Point> findNearestPoint(Point p, List<Point> n, int k, String solN){

        double minDistance=0;
        List<Point> nearestPoint = new ArrayList<>();

        double [] [] distances = new double [2][n.size()];

        //Calculate distances from point P
        for(int i =0; i< n.size(); i++){
            double d = Math.sqrt((Math.abs( p.y - n.get(i).y))^2 +( Math.abs(p.x-n.get(i).x))^2);
            distances[0][i] = i;
            distances[1][i] = d;
        }

        //Do quick sort here
        // k = we want to get orgered list upto kth position
       // int partition =  getPartition (  n, 0, k);

        if(solN.equals("1")) {
            doQuickSort(distances, 0, n.size() - 1, k);
        }else if (solN.equals("2")) {
            priorityQueueSol(n, distances, k);
        }

        for(int i= 0; i<k;i++){
            nearestPoint.add( n.get((int) distances[0][i])) ;
        }

        return nearestPoint;
    }

    // Solution 1  : Recursive call
    //Time complexity: O(n)
    private static void doQuickSort( double [] [] arr, int low, int high, int k){
        if(arr==null) return;

        if(high> low) {
            int partitionIndex = getPartition(arr, low, high);
            if(k == partitionIndex) return;
            else if(k > partitionIndex)  //---->>Prune -- No need to search to the right segment of the Kth element
                doQuickSort(arr, partitionIndex + 1, high, k);
            else
                doQuickSort(arr, low, partitionIndex - 1, k);
        }
    }




    // Solution 2 : Priority Queue
    //Time complexity: O(n*logn)
    private static void priorityQueueSol( List<Point> n,  double [] [] arr,  int k){
        if(arr==null) return;


        PriorityQueue<Double> pq = new PriorityQueue<>();
        HashMap<Double,Integer> map = new HashMap<>();
        for (int i =0; i< arr[0].length;  i++) {
             pq.add(arr[1][i]);
             map.put(arr[1][i],(int) arr[0][i]);
        }

        List<Point> points = new ArrayList<>();
        int j =0;
        while( j<k && (!map.isEmpty() )){
            int index =  map.get(pq.poll()) ;
            points.add(n.get(index));
            j++;
        }

        for(j=0;j<k;j++) n.add(j, points.get(j));
    }

    static int getPartition (double [] [] arr, int low, int high)
    {
        // pivot (Element to be placed at right position)
        double pivot = arr[1][high];

        int i = low-1 ;  // Index of smaller element

        for (int j = low; j < high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[1][j] < pivot)
            {
                i++;    // increment index of smaller element
                swap (arr, i, j);
            }
        }
        swap (arr, i + 1, high);
        return (i + 1);
    }

    static void swap(double[][] arr, int i, int j){

        double tmpIndex = arr[0][i];
        double tmpVal = arr[1][i];

        arr[0][i]=   arr[0][j];
        arr[1][i]=   arr[1][j];

        arr[0][j]= tmpIndex;
        arr[1][j]= tmpVal;
    }


    public static void main(String [] args){
        int x =3;
        int y = 5;

        Point p = new Point(x, y);

        System.out.println("Given Point: ");
        System.out.println(p.x + ","+ p.y);

        List<Point> n = new ArrayList<>();
        List<Point> nOriginal = new ArrayList<>();

        // create random object
        Random r = new Random();
        // setting seed
        long s = 10;
        r.setSeed(s);

        int OFFSET = 10;
        int NUM_POINTS = 100;
        //Generate random <NUM_POINTS> points within <OFFSET> unit offset of p
        System.out.println(NUM_POINTS + " Random Generated Points: ");
        for(int i=0;i <NUM_POINTS; i++) {
            Point tmp = makePoint(r, x, y, OFFSET);
            System.out.println(tmp.x + ","+ tmp.y);
            n.add(tmp);
        }

        nOriginal.addAll(n);

        int k=2;

        long t1 = System.currentTimeMillis();
        List<Point> np =  findNearestPoint(p,n, k, "1");
        long t2 = System.currentTimeMillis() ;
        System.out.println("Time [ms] - use quick select recursive : " + (t2-t1));

        System.out.println("Nearest "+ k +" Point(s) : ");
        for(int i=0; i<np.size(); i++) {
            System.out.println(np.get(i).x + "," + np.get(i).y);
        }



        n.clear();
        n.addAll(nOriginal);

        t1 = System.currentTimeMillis();
        np =  findNearestPoint(p,n, k, "2");
        t2 = System.currentTimeMillis() ;
        System.out.println("Time [ms] use Priority Queue  : " + (t2-t1));

        System.out.println("Nearest "+ k +" Point(s) : ");
        for(int i=0; i<np.size(); i++) {
            System.out.println(np.get(i).x + "," + np.get(i).y);
        }


    }

    private static Point makePoint(final Random seed, final int x, final int y, int offset) {
       // final int offset = radius;
        final double rotation = 2 * Math.PI * Math.random();
        final int x1 = (int) (Math.sin(rotation) * offset);
        final int y1 = (int) (Math.cos(rotation) * offset);
        return new Point(x + x1, y + y1);
    }
}
