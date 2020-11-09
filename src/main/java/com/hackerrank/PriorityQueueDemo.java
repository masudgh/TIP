package com.hackerrank;

import java.util.*;



public class PriorityQueueDemo {

    static class Student {
        int id;
        String name;
        double cgpa;

        public Student( String name, double cgpa, int id) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCGPA() {
            return cgpa;
        }

    }

    static class Priorities {


        PriorityQueue<Student> students;

        Priorities() {
           /* students = new PriorityQueue<Student>(new Comparator<Student>(){

                // Overriding compare()method of Comparator
                // for descending order of cgpa
                public int compare(Student s1, Student s2) {
                    if (s1.cgpa < s2.cgpa)
                        return 1;
                    else if (s1.cgpa > s2.cgpa)
                        return -1;
                    else{ //Compare name
                        int res = String.CASE_INSENSITIVE_ORDER.compare(s1.name, s2.name);
                        if (res == 0) {
                            res = s1.name.compareTo(s2.name);
                            if ( res ==0 ){
                                //Compare ID

                                if( s1.id < s1.id ) return 1;
                                else return -1;
                            }
                            return res;
                        }
                        return res;
                    }
                   // return 0;
                }

            });


            */

           students =  new PriorityQueue(Comparator.comparing
                   (Student::getCGPA).reversed()
                   .thenComparing(Student::getName)
                   .thenComparing(Student::getId));
        }

        List<Student> getStudents(List<String> events){

            List<Student> unservedStudent = new ArrayList<>();

            for(int i=0; i< events.size();i++){
                String[] str = events.get(i).split(" ");
                if(str == null) return null;
                if(str[0].equalsIgnoreCase("ENTER")){
                    Student student = new Student( str[1],Double.parseDouble(str[2]),Integer.parseInt(str[3]));
                    students.add(student);
                }else if (str[0].equalsIgnoreCase("SERVED")){
                    students.poll();
                }
            }

            int unservedCount = students.size();
            for(int i =0 ; i <unservedCount; i++){
                unservedStudent.add(students.poll());
            }

            return unservedStudent;
        }

    }



    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }

}
