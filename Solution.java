import java.util.*;

class Result {
    public static int maxCollectibleArtifacts(List<Integer> artifacts) {
        int maxCollected = 0;
        int left = 0;
        Map<Integer, Integer> artifactCount = new HashMap<>();

        for (int right = 0; right < artifacts.size(); right++) {
            artifactCount.put(artifacts.get(right), artifactCount.getOrDefault(artifacts.get(right), 0) + 1);

            while (artifactCount.size() > 2) {
                artifactCount.put(artifacts.get(left), artifactCount.get(artifacts.get(left)) - 1);
                if (artifactCount.get(artifacts.get(left)) == 0) {
                    artifactCount.remove(artifacts.get(left));
                }
                left++;
            }

            maxCollected = Math.max(maxCollected, right - left + 1);
        }

        return maxCollected;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Sample test cases
        List<Integer> test1 = Arrays.asList(1, 2, 1);
        System.out.println(Result.maxCollectibleArtifacts(test1)); // Output: 3

        List<Integer> test2 = Arrays.asList(0, 1, 2, 2);
        System.out.println(Result.maxCollectibleArtifacts(test2)); // Output: 3

        List<Integer> test3 = Arrays.asList(1, 2, 3, 2, 2);
        System.out.println(Result.maxCollectibleArtifacts(test3)); // Output: 4
    }
}
