package com.practice;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Interval{

    int start;
    int end;

    public Interval(int start, int end) {  // epoch time
        this.start = start;
        this.end = end;
    }

    public Interval(double start, double end) { //fraction time

    }

    public Interval(String start, String end) { // string format time

    }

}





public class CalenderDemo {



    public  List<Interval> getMergeInterval(List<Interval> arr){

        //sort the interval
        Collections.sort(arr, (a,b) -> a.start-b.start);

        List<Interval> resultIntervals = new ArrayList<>();

        Interval prevInterval = arr.get(0);
        Interval currInterval;

        for(int i=1; i< arr.size(); i++){

            currInterval= arr.get(i);
            if( prevInterval.end >= currInterval.start){
               // mergedIntervals.add ()
                prevInterval = new Interval(prevInterval.start,Math.max(prevInterval.end, currInterval.end) );

            }else{
                //if there is no overlap with the current interval
                resultIntervals.add (prevInterval);
                prevInterval = new Interval(currInterval.start,currInterval.end);

            }
        }
        resultIntervals.add (prevInterval);  //process the  last

        return resultIntervals;
    }



    //not sorted
    // time is epoc seconds
    //24 hr format
    //1 day calender
    //seconds
    public static void main (String [] args){
        double[][] meetings = { {10.0, 11.0},
                {10.50, 11.50},
                {12.00, 1.00},
                {14.50, 17.0},
                {15.00, 15.50},
                {14.00, 14.50},
                {16.00, 17.0},
        };

        Interval int1 = new Interval(2,5);
        Interval int2 = new Interval(2,3);
        Interval int3 = new Interval(6,8);
        Interval int4 = new Interval(7,10);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(int1);
        intervals.add(int2);
        intervals.add(int3);
        intervals.add(int4);
        intervals.add(int1);



        CalenderDemo calenderDemo = new CalenderDemo();

        List<Interval> mergedIntervals = calenderDemo.getMergeInterval(intervals);

        for( int i=0;i<mergedIntervals.size();i++) {
            System.out.println(mergedIntervals.get(i).start+ ","+mergedIntervals.get(i).end);
        }


    }
}
