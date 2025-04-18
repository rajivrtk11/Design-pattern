package streamApi.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayProblem {

    public static void main(String[] args) {
        int[] arr = {10, 12, 50, 25, 43, 76, 13, 12, 43, 76};  //12,43,76
        int[] arr2 = {100, 300, 450, 123, 432, 987, 456, 908};
        String str = "Ankan Dhar";
        String str2 = " Terrapay";


        //find all the even numbers
        Object[] even = Arrays.stream(arr).boxed().filter(x -> x % 2 == 0).toArray();
        //System.out.println("Even numbers of the array : "+Arrays.toString(even));

        //Numbers starting with one
        List<String> nums = Arrays.stream(arr).boxed().map(x -> x + "").filter(x -> x.startsWith("1")).collect(Collectors.toList());
        Object[] mStrings = Arrays.stream(arr).boxed().map(String::valueOf).filter(x -> x.startsWith("1")).toArray();
        //System.out.println("Numbers starting with 1 in the array : "+nums);
        //System.out.println("numbers starts with 1 : "+Arrays.toString(mStrings));

        //Find duplicate element in the array
        List<Integer> duplicates = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1).map(Entry::getKey).collect(Collectors.toList());
        //System.out.println("Duplicate elements of the array : "+duplicates);

        //Remove duplicate element from an array
        List<Integer> unique = Arrays.stream(arr).boxed().distinct().collect(Collectors.toList());
        Object[] ans = Arrays.stream(arr).boxed().distinct().toArray();
        Set<Integer> uniques = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        //System.out.println("Array after removing duplicate elements : "+Arrays.toString(ans));

        // Find second highest and lowest number of an array
        Integer secondHighest = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().get();
        //System.out.println("Second Highest element of the array : "+secondHighest);

        Integer secondLowest = Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder()).distinct().skip(1).findFirst().get();
        //System.out.println("Second Lowest element of the array : "+secondLowest);

        //Find the total number of elements of an array
        long count = Arrays.stream(arr).count();
        //System.out.println("total number of elements in the array : "+count);

        //Maximum element of the array:
        int highestElement = Arrays.stream(arr).max().getAsInt();
        //System.out.println("Highest element of the array : "+highestElement);
        int minimumElement = Arrays.stream(arr).min().getAsInt();
        //System.out.println("Minimum element of the array : "+minimumElement);

        //perform cube on list elements and filter numbers greater than 5000
        List<Integer> cubes = Arrays.stream(arr).boxed().map(x -> x * x * x).filter(x -> x > 5000).collect(Collectors.toList());
        //System.out.println("Cubes which are grater than 5000: "+cubes);

        //Concate two array and sort it and print distinct element :
        //List<Integer> list = IntStream.concat(Arrays.stream(arr),Arrays.stream(arr2)).boxed().sorted(Comparator.naturalOrder()).distinct().collect(Collectors.toList());
        List<Integer> margedList = Stream.concat(Arrays.stream(arr).boxed(), Arrays.stream(arr2).boxed()).sorted(Comparator.naturalOrder()).distinct().collect(Collectors.toList());
        //System.out.println("Concatinated list is : "+margedList);
        String combineWord = Stream.concat(Arrays.stream(str.split("")), Arrays.stream(str2.split(""))).collect(Collectors.joining(""));
        System.out.println("Combine Word : " + combineWord);

        //Separate even and odd number from an array:
        Map<Boolean, List<Integer>> map = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        Set<Boolean> keys = map.keySet();
			/*for(Boolean key : keys) {
				if(key)
					System.out.println("Even numbers are : "+map.get(key));
				else
					System.out.println("Odd numbers are : "+map.get(key));
			}*/
        Map<Boolean, List<Integer>> map1 = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        //System.out.println(map1);


        //Find min 3 numbers :
        Object[] min = Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder()).distinct().limit(3).toArray();
        //System.out.println(Arrays.toString(min));

        double avg = Arrays.stream(arr).average().getAsDouble();

        //System.out.println(avg);

        int[] arr3 = {10, 20, 30};
        Integer sum = Arrays.stream(arr3).boxed().reduce((a, b) -> a + b).get();
        Arrays.stream(arr3).boxed().collect(Collectors.summingInt(x -> x));
        Arrays.stream(arr3).sum();
        //System.out.println(sum);
        Integer mul = Arrays.stream(arr3).boxed().reduce((a, b) -> a * b).get();
        //System.out.println(mul);


        // Longest sub string
        String[] b = {"tall", "taller", "tallest"};
        Optional<String> longestSubString = Arrays.stream(b).reduce((s1, s2) -> {
            int length = Math.min(s1.length(), s2.length());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    result.append(s1.charAt(i));
                } else {
                    break;
                }
            }
            return result.toString();
        });

        System.out.println("Longest Sub String : " + longestSubString.get());

        Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}

