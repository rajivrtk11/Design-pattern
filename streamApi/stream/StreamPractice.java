package streamApi.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        Map<String, Integer> salaryMap2 = new HashMap<>();
        salaryMap2.put("Ankan", 1000);
        salaryMap2.put("Bishal", 1200);
        salaryMap2.put("Robin", 1200);
        salaryMap2.put("Vinod", 600);
        salaryMap2.put("Pradeep", 1500);
        salaryMap2.put("Abhishek", 600);

        int[] arr = {10, 12, 50, 25, 43, 76, 13, 12, 43, 76, 50};  //12,43
        int[] arr2 = {100, 300, 450, 123, 432, 987, 456, 908};
        String str = "My name is Ankan Dhar";

        //second highest Salary
        Map<Integer, List<String>> newMap = salaryMap2.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        List<Entry<Integer, List<String>>> sortedMapList = newMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());
        //System.out.println(sortedMapList);

        //Merge two List and print occurrence of each character in sorted order :
        List<Entry<Integer, Long>> newlist = Stream.concat(Arrays.stream(arr).boxed(), Arrays.stream(arr2).boxed())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        System.out.println(newlist);

        //Seperate odds and evens :
    }
}
