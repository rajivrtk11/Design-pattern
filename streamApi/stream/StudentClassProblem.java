package streamApi.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StudentClassProblem {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1, "Ankan", 28, "M", "CS", Arrays.asList("1234", "5678")),
                new Student(2, "Bishal", 25, "M", "ME", Arrays.asList("6734", "9845")),
                new Student(3, "Abhishree", 22, "F", "CS", Arrays.asList("9087", "6745")),
                new Student(4, "Deepak", 29, "M", "CE", Arrays.asList("3451", "5673")),
                new Student(5, "Arpita", 25, "F", "CE", Arrays.asList("7865", "8906")),
                new Student(5, "Ram", 25, "M", "ME", Arrays.asList("6748", "2093"))
        );

        //Find the student whose age in between 20 and 27 :
        List<String> strings = students.stream()
                .filter(x -> x.getAge() >= 20 && x.getAge() < 27)
                .map(x -> x.getName())
                .collect(Collectors.toList());
        //System.out.println(strings); // Bishal, Abhishree, Arpita

        //Sort the students according to their name whose gender is "M" :
        List<Student> studentList = students.stream()
                .filter(x -> x.getGender().equals("M"))
                .sorted(Comparator.comparing(Student::getName).reversed())
                .collect(Collectors.toList());
        List<Student> studentList2 = students.stream()
                .filter(x -> x.getGender().equals("M"))
                .sorted(Comparator.comparing(Student::getName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        //System.out.println(studentList);


        //Find all the dept names :
        List<String> depts = students.stream().map(x -> x.getDept()).distinct().collect(Collectors.toList());
        List<String> depts2 = students.stream().map(Student::getDept).distinct().collect(Collectors.toList());
        //System.out.println(depts);

        //Find all numbers
		/*OneToOne-> map, OneToMany-> flatmap (Basically, if we need to use map function on collection of object)
		like List<>,set<>, Array[] etc then we use flatmap function */
        List<String> numbers = students.stream()
                .flatMap(x -> x.getNumbers().stream())
                .collect(Collectors.toList());
        //System.out.println(numbers);

        //Group the students by dept name
        Map<String, List<Student>> map = students.stream()
                .collect(Collectors.groupingBy(Student::getDept));
        //System.out.println(map);

        //List of all Students in each Dept
        Map<String, List<String>> allStudentsInEachDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(allStudentsInEachDept);

        //Now we need to sort the above array on the basis of age.
        List<Entry<String, List<String>>> list = allStudentsInEachDept.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());

        //System.out.println(list);
    }
}

