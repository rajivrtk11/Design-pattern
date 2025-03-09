package streamApi.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Find the longest string in a list of strings using Java streams:
//        List<String> strings = Arrays
//                .asList();
//        String s = strings.stream().max(Comparator.comparing(String::length)).get();
//        String s1 = strings.stream()
//                .max(Comparator.comparing(String::length))
//                .orElseThrow(() -> new RuntimeException("Array is empty"));
//
//        System.out.println("Max length substring "+ s1);

//        Calculate the average age of a list of Person objects using Java streams:
//        List<Person> persons = Arrays.asList(
//                new Person("Alice", 25),
//                new Person("Charlie", 35),
//                new Person("Bob", 30)
//        );
//        double averageAge = persons.stream().mapToInt(Person::getAge).average().orElse(0);
//        System.out.println("Average age of person is "+ averageAge);

//        ArrayList<Person> collect = persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toCollection(ArrayList::new));
//        System.out.println("Sorted person age "+collect);

//        Q. Merge two sorted lists into a single sorted list using Java streams:
//        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
//        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
//        List<Integer> collect = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());
//        System.out.println("concatted list "+ collect);

//        Find the intersection of two lists using Java streams:

//        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
//        List<Integer> list = list2.stream().filter(list1::contains).toList();
//        List<Integer> list3 = list1.stream().sorted(Comparator.comparingInt(e -> (int) e).reversed()).toList();
//        System.out.println("intersection of list is "+ list3);

//        Remove duplicates from a list while preserving the order using Java streams:
//        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
//        Collection<Integer> collect = numbersWithDuplicates.stream().distinct().collect(Collectors.toCollection(LinkedList::new));
//        System.out.println("Distinct element in the list "+ collect);

//        Given a list of transactions, find the sum of transaction amounts for each day using Java streams:

//        List<Transaction> transactions = Arrays.asList(
//                new Transaction("2022-01-01", 100),
//                new Transaction("2022-01-01", 200),
//                new Transaction("2022-01-02", 300),
//                new Transaction("2022-01-02", 400),
//                new Transaction("2022-01-03", 500)
//        );
//        Map<String, Integer> collect = transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));

//        Find the kth smallest element in an array using Java streams:
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element
        int asInt = Stream.of(array).flatMapToInt(e -> Arrays.stream(e)).max().getAsInt();

        String str = "abcabcd";
        // find first non repeating character
        LinkedHashMap<String, Long> collect = Stream.of(str.split("")).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));

        List<Integer> collect1 = Arrays.stream(array).skip(3).mapToObj(e -> e).collect(Collectors.toList());
        System.out.println("Frequency of elements "+ collect1);
    }

}
