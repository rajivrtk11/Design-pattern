import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreadPractice {

    public static void main(String[] args) {
        int[] arr = {10, 12, 50, 25, 43, 76, 13, 12, 43, 76};  //12,43,76
        int[] arr2 = {100, 300, 450, 123, 432, 987, 456, 908};
        String str = "Ankan Dhar";
        String str2 = " Terrapay";

        //find all the even numbers
        List<Integer> evenNumbers = Arrays.stream(arr).boxed()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
//        System.out.println("even numbers are "+ evenNumbers);

        //Numbers starting with one
        List<Integer> numbersStartingWithOne = Arrays.stream(arr).boxed()
                .filter(e -> (e + "").startsWith("1")).collect(Collectors.toList());
//        System.out.println("Numbers starting with one "+ numbersStartingWithOne);

        //Find duplicate element in the array
        Map<Integer, Long> freqMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

//        System.out.println("freq map is "+ freqMap);
        List<Integer> duplicateElement = freqMap.entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e -> e.getKey()).collect(Collectors.toList());
//        System.out.println("duplicate elements "+ duplicateElement);

        //Remove duplicate element from an array
        List<Integer> uniqueElements = Arrays.stream(arr).boxed()
                .distinct().collect(Collectors.toList());
//        System.out.println("unique elements are "+ uniqueElements);


        // Find second highest and lowest number of an array
        List<Integer> sortedList = Arrays.stream(arr).boxed()
                .sorted(Comparator.naturalOrder()).toList();
//        System.out.println("sorted list is "+sortedList);

//        second highest element
        int size = sortedList.size();
        Integer secondHighestElement = sortedList.get(size - 2);
//        System.out.println("Second highest element is "+ secondHighestElement);

//        lowest number of an array
        Integer lowestElement = sortedList.get(0);
//        System.out.println("lowest element is "+ lowestElement);

        //perform cube on list elements and filter numbers greater than 5000
        List<Integer> filterElementAfterCubeOp = Arrays.stream(arr).boxed()
                .map(e -> e * e * e).filter(e -> e > 5000).collect(Collectors.toList());
//        System.out.println("filterElementAfterCubeOp "+ filterElementAfterCubeOp);

        //Concate two array and sort it and print distinct element :
        List<Integer> concatAndSort = Stream.concat(Arrays.stream(arr).boxed(), Arrays.stream(arr2).boxed())
                .sorted().collect(Collectors.toList());
//        System.out.println("concat and sort list "+ concatAndSort);

        // concat two string
        List<String> concatString = Stream.concat(Arrays.stream(str.split("")), Arrays.stream(str2.split("")))
                .collect(Collectors.toList());

//        System.out.println("concatedString "+ concatString);

        //Separate even and odd number from an array:
        Map<Integer, List<Integer>> evenAndOddList = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(e -> e % 2, Collectors.toList()));
//        System.out.println("Even and odd list "+ evenAndOddList);


        // string problems
        String strr = "I am Ankan Dhar";
        String s1 = "RaceCar";
        String s2 = "CarRace";
        String s5 = "we are python developers";
        String s6 = "I love java code java do java code";

        // find first non repeated character
        char[] charArray = strr.toCharArray();
        for(char ch: charArray) {
            System.out.println(ch);
        }

        System.out.println("character list ");

    }

}
