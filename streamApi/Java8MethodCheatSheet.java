package streamApi;


import javax.swing.text.html.Option;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8MethodCheatSheet {

    public static void main(String[] args) {


        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        // forEach
//        employees.forEach(e-> System.out.println(e.getName()+" : "+e.getSalary()));

//        employees.stream().forEach(System.out::println);

        //filter
        //.collect

        Map<Integer, String> developmentEmployees = employees.stream()
                .filter(e -> e.getDept().equals("Development") && e.getSalary() > 80000)
                .collect(Collectors.toMap(Employee::getId, Employee::getName));

        // System.out.println(developmentEmployees);

        //map
        //distinct
        List<String> depts = employees.stream()
                .map(Employee::getDept)
                .distinct()
                .collect(Collectors.toList());
        //System.out.println(depts);

        List<Stream<String>> projectNames = employees.stream()
                .map(e -> e.getProjects()
                        .stream().map(p -> p.getName())).collect(Collectors.toList());

        //flatMap

        List<String> projects = employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .map(p -> p.getName()).distinct()
                .collect(Collectors.toList());

        //System.out.println(projects);
        //sorted
        //asc
        List<Employee> ascSortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
//        ascSortedEmployees.get(0);

        //ascSortedEmployees.forEach(System.out::println);

        //desc
        List<Employee> descSortedEmployees = employees.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .collect(Collectors.toList());

//        descSortedEmployees.get(0);

        //descSortedEmployees.forEach(System.out::println);

        //min & max
        Optional<Employee> highestPaidEmployees = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        // System.out.println("Highest paid employee : "+highestPaidEmployees);

        Optional<Employee> lowestPaidEmployees = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));

        //System.out.println("Lowest paid employee : "+lowestPaidEmployees);

        //groupingBy

        Map<String, List<Employee>> employeeGroup = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));

        //System.out.println(employeeGroup);

        //Gender -> [names]
        Map<String, List<String>> employeeGroupNames = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));

        //System.out.println(employeeGroupNames);

        Map<String, Optional<Employee>> employeeGroupMaxSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

        //Gender -> [count]
        Map<String, Long> employeeGroupCountMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//        System.out.println(employeeGroupCountMap);

        //findFirst

        Employee findFirstElement = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Employee not found "));

//        System.out.println(findFirstElement.get());//NPE
//
//        if(findFirstElement.isPresent()){
//            System.out.println(findFirstElement.get());
//        }
//
//        findFirstElement.ifPresent(e-> System.out.println(e.getName()));

//        System.out.println(findFirstElement);

        //findAny

        Employee findAnyElement = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("Employee not found "));

        // System.out.println(findAnyElement);

        //anyMatch(Predicate) , allMatch(Predicate) , noneMatch(Predicate)

        boolean developmentEmpAnyMatch = employees.stream()
                .anyMatch(e -> e.getDept().equals("Development"));
        //System.out.println("is there any employee match from development dept "+developmentEmpAnyMatch);


        boolean developmentEmpAllMatch = employees.stream()
                .allMatch(e -> e.getSalary()>50000);//55000
        //System.out.println(developmentEmpAllMatch); //false


        boolean isNoneMatch = employees.stream()
                .noneMatch(e -> e.getDept().equals("abc"));
        //System.out.println(isNoneMatch);

        //limit(long)

        List<Employee> topPaidEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(4)
                .collect(Collectors.toList());

//        topPaidEmployees.forEach(e-> System.out.println(e.getName()));

        //skip(long)
        List<Employee> skipEmployees = employees.stream().skip(10)
                .collect(Collectors.toList());

        String str = "hello";

        // Step 1: Create a frequency map of characters
        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Step 2: Process the Map using Streams

        // ✅ Convert Map to a List of Strings (formatted as "char=count")
        List<String> charList = charCount.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue()) // Convert entry to a formatted string
                .collect(Collectors.toList());

//        System.out.println("Character Count List: " + charList);

        // ✅ Filter characters appearing more than once
        Map<Character, Long> filteredMap = charCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1) // Keep only characters with count > 1
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

//        System.out.println("Filtered Map (count > 1): " + filteredMap);

        // ✅ Sort the Map by count in descending order
        LinkedHashMap<Character, Long> sortedMap = charCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Sort by value (count) descending
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Merge function (not needed here)
                        LinkedHashMap::new // Maintain order
                ));

        // find second highest paid employee in each department
//        Map<String, String> secondHighestPaidEmpDepartmentwise = employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.collectingAndThen(
//                Collectors.toList(),
//                list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).distinct()
//                        .map(e -> e.getName() + " " + e.getSalary()).skip(1).findFirst().orElse("Not found")
//        )));
//        System.out.println("SecondHighestPaidEmpDepartmentwise paid employee in each department "+ secondHighestPaidEmpDepartmentwise);

        Map<String, Optional<String>> secondHighestPaidEmpDepartmentwise =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                                .skip(1) // Skip the highest-paid employee
                                                .findFirst() // Get the second highest
                                                .map(e -> e.getName() + " " + e.getSalary()) // Convert to String
                                )
                        ));


        // Print results
        secondHighestPaidEmpDepartmentwise.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.orElse("Not found")));
//        System.out.println("Sorted Map (Descending Order by Count): " + sortedMap);
//
//      1. forEach(Consumer)
//      2. filter(Predicate)
//      3. collect(Collector)
//      4. map(Function)
//      5. distinct()
//      6. flatMap(Function)
//      7. sorted(Comparator both ASC and DESC)
//      8. min() & max()
//      9. GroupBy
//      10. findFirst()
//      11. findAny()
//      12. anyMatch(Predicate)
//      13. allMatch(Predicate)
//      14. noneMatch(Predicate)
//      15. limit(long maxSize)
//      16. skip(long n)
    }
}
