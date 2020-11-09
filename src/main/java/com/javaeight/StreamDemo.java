package com.javaeight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    private static class Employee{
        public int id;
        public String name;
        public int salary;


        public Employee(int id,String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }
        public void salaryIncrement(int inc){
            this.salary +=inc;
        }
    }

    private static List<Employee> employeeList = new ArrayList<>();
    private static void createEmployees(){
        employeeList.add(new Employee(1," jeff", 100000));
        employeeList.add(new Employee(2," bill", 80000));
        employeeList.add(new Employee(3," mark", 50000));
    }

    private static void printEmployees(List<Employee>employeeList){
        employeeList.stream().forEach(e-> System.out.println(e.toString()));
    }

    private static Employee fidById(Integer id){
       Employee emp = employeeList.stream()
                                    .filter(e-> e.getId() == id)
                                    .findFirst()
                                    .orElse(null);
        return emp;
    }


    private static void updateSalary(Integer id, int newSalary){
        //List<Employee> emp =
                employeeList.stream()
                .filter(e-> e.getId() == id)
                .forEach( e -> e.setSalary(newSalary));
    }
    public static void main (String [] args){
        createEmployees();
        System.out.println("Initial Employee Load ------");
        printEmployees(employeeList);


        employeeList.stream().filter(e-> e.getId() == 1)
                .forEach(e1 -> e1.setSalary(200));

        employeeList.stream()
                .peek(e -> e.salaryIncrement(10))
                .peek(System.out::println)
                .collect(Collectors.toList());


        Integer [] empIds = { 1, 3 };
        List<Employee> selectedEmployees = Stream.of(empIds)
                .map(StreamDemo::fidById)
                .collect(Collectors.toList())
                .stream().peek(System.out::println)
                .collect(Collectors.toList());


      //  printEmployees(selectedEmployees);

        System.out.println("Minimum  ID ------");
        employeeList.stream()
                .min( (e1, e2) -> e1.getId() - e2.getId())
                .stream().peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("Max paid ------");
        employeeList.stream()
                .max( (e1, e2) -> e1.getSalary() - e2.getSalary())
                .stream().peek(System.out::println)
                .collect(Collectors.toList());

        Map<Integer, List<Integer>> map =new HashMap<>();

        map.computeIfAbsent( 5, k -> new ArrayList<>())
                .add(56);
        System.out.println( map.get(5).toArray().toString());
    }


}
