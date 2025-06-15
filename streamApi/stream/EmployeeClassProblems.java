package streamApi.stream;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

// important thing => multiple Collector.groupingby, group on x and then on y
// counting and then, collecting and then
public class EmployeeClassProblems {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 25, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //How many male and female employees are there in the organization
        Map<String, Long> emp1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        Long maleEmployees = employeeList.stream().filter(e -> e.getGender().equals("Male")).count();
        //System.out.println(emp1);

        //Print the name of all departments in the organization
        List<String> deptList = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        //System.out.println(deptList);

        //What is the average age of male and female employees :
        Map<String, Double> emp2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        //System.out.println("Average age of male and female employees : "+emp2);

        //Get the details of highest paid employee in the organization
        Employee highestPaidEmp = employeeList.parallelStream().max(Comparator.comparing(Employee::getSalary)).get();
        Employee highestPaidEmp2 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
        Map<String, Optional<Employee>> higestPaidEmpInEachDept = employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        ));
        //System.out.println("Highest paid Employee in the organization is : "+highestPaidEmp2);
        System.out.println("highest paid employee in each Dept =  " + higestPaidEmpInEachDept);

        //Count the number of employees in each department :
        Map<String, Long> numberOfEmpsInEachDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        //System.out.println(numberOfEmpInEachDept);

        //What is the average salary of each department
        List<Entry<String, Double>> avgSalaryEachDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());
        //System.out.println("Average salary of each Dept in reverse order : "+higestSalaryMap);

        //List down the names of all employees in each department :
        Map<String, List<String>> allEmpsInADept = employeeList.parallelStream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        //System.out.println(allEmpsInADept);

        //first grouping by gender, then grouping by dept.
        Map<String, Map<String, List<String>>> map5 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList()))));
        //map5.entrySet().stream().forEach(e-> System.out.println(e.getKey()+" : "+e.getValue()));

        //second senior most employee in each dept.
        Map<String, Object> secondSeniorMostEmpInEachDept = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),
                                //list-> list.stream().sorted(Comparator.comparing(Employee::getAge, Comparator.reverseOrder())).map(e->e.getName()+" : "+Integer.toString(e.getAge())).collect(Collectors.toList())
                                list -> list.stream().sorted(Comparator.comparing(Employee::getAge, Comparator.reverseOrder())).distinct().map(e -> e.getName() + " : " + Integer.toString(e.getAge())).skip(1).findFirst().get()
                        ))
        );
        //System.out.println(secondSeniorMostEmpInEachDept);

        //Sort the employees first based on years of joining in Desc, then based on age in asc
        List<String> emplist = employeeList.stream().sorted(Comparator
                .comparing(Employee::getYearOfJoining, Comparator.reverseOrder())
                .thenComparing(Employee::getAge, Comparator.naturalOrder())
        ).map(e -> e.getYearOfJoining() + " : " + e.getAge()).collect(Collectors.toList());
        //System.out.println(emplist);

        Map<String, Object> secondHighestSalaryInEachDept = employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())).map(e -> e.getName() + " : " + e.getSalary()).collect(Collectors.toList()).get(2 - 1)
                )
        ));

        System.out.println("Second Highest salary in each Dept : " + secondHighestSalaryInEachDept);

        employeeList.stream().collect(Collectors.toMap(Employee::getId, e -> true));

        //emp.stream().collect(Collectors.toMap(Employee::getId, e ->true));

        //change the name to upper case of the employees of Product Development dept
        List<Employee> empsOfnameChanged = employeeList.stream().filter(e -> e.getDepartment().equals("Product Development")).map(e -> {
            e.setName(e.getName().toUpperCase());
            return e;
        }).collect(Collectors.toList());

        //System.out.println(empsOfnameChanged);
    }
}