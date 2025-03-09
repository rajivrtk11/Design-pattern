package streamApi.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringProblem {
    public static void main(String[] args) {
        String str = "I am Ankan Dhar";
        String s1 = "RaceCar";
        String s2 = "CarRace";
        String s5 = "we are python developers";
        String s6 = "I love java code java do java code";

        //find the first non-repeated character
        String firstNonRepetedChar = Arrays.stream(str.toLowerCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1 && !x.getKey().equals(" ")).map(x -> x.getKey()).findFirst().get();
        System.out.println("First Non repeted char : " + firstNonRepetedChar);

        //find First repeated Character
        String firstRepeatedChar = Arrays.stream(str.toLowerCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1 && !x.getKey().equals(" ")).map(x -> x.getKey()).findFirst().get();
        //System.out.println("First repeated Character : "+firstRepeatedChar);

        //find only duplicate elements with its count from the String
        Arrays.stream(str.toLowerCase().split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1 && !x.getKey().equals(" ")).forEach(x -> System.out.println(x.getKey() + " : " + x.getValue()));

        //check if two strings are anagrams or not :
        String s3 = Arrays.stream(s1.toUpperCase().split("")).sorted().collect(Collectors.joining());
        String s4 = Arrays.stream(s2.toUpperCase().split("")).sorted().collect(Collectors.joining());
        String result = (s3.equals(s4)) ? "String are anagrams" : "String are not anagrams";
        System.out.println(result);

        String reverse = Arrays.stream(s5.trim().split(" ")).map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        String reverseString = Stream.of(reverse).map(rword -> new StringBuilder(rword).reverse().toString()).collect(Collectors.joining());
        System.out.println("Oreginal String : " + s5);
        System.out.println("Reverse String  : " + reverse);
        System.out.println("After reversing whole String : " + reverseString);
        //IntStream.range(s1.length()-1, 0).map(i ->"".concat(s1.charAt(i))).

        //remove duplicate word from a string :
        Set<String> set = Arrays.stream(s6.trim().split(" ")).collect(Collectors.toCollection(LinkedHashSet::new));
        String strv = set.stream().collect(Collectors.joining(" "));
        System.out.println(strv);

        //Find longest common subString
        String[] arr = {"tall", "taller", "tallest"};
        Arrays.stream(arr).reduce((w1, w2) -> {
            int length = Math.min(w1.length(), w2.length());
            String commonSubString = "";
            for (int i = 0; i < length; i++) {
                if (w1.charAt(i) == w1.charAt(i)) {
                    commonSubString = commonSubString.concat(String.valueOf(w1.charAt(i)));
                } else {
                    break;
                }
            }
            return commonSubString;
        }).ifPresent(System.out::println);

        Arrays.stream(arr).reduce((w1, w2) -> {
            int length = Math.min(w1.length(), w2.length());
            String ss = "";
            for (int i = 0; i < length; i++) {
                if (w1.charAt(i) == w2.charAt(i)) {
                    ss = ss.concat(String.valueOf(w1.charAt(i)));
                } else {
                    break;
                }
            }
            return ss;

        }).ifPresent(System.out::println);
    }
}
