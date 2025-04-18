import hello.Hello;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Student {
    public int id;
    public String name;
    public List<String> courses;

    public Student(int id, String name, List<String> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Rajiv", Arrays.asList("course1", "course2")));
        studentList.add(new Student(2, "Sachin", Arrays.asList("course1")));
        studentList.add(new Student(3, "Modin", Arrays.asList("course2")));

        Map<String, List<String>> collect = studentList.stream().flatMap(s -> s.courses.stream().map(s1 -> new AbstractMap.SimpleEntry<>(s1, s.name)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        List<String[]> list = studentList.stream().flatMap(s -> s.courses.stream().map(s1 -> new String[]{s1, s.getName()})).toList();

        Map<String, List<String>> collect1 = list.stream().collect(Collectors.groupingBy(e -> e[0], Collectors.mapping(e -> e[1], Collectors.toList())));
//      System.out.println("Course vs student mapping "+ collect);
        System.out.println("mapping "+ collect1);

    }
}
