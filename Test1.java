import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Test1 {
    public static void main(String[] args) {
        /*
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
        such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        Notice that the solution set must not contain duplicate triplets.

        Example 1:
        Input: nums = [-1,0,1,2,-1,-4]

        Output: [[-1,-1,2],[-1,0,1]]

        m-1
            Hashset
            p1 -> 0
            Hashset
            p2 -> p1+1
            Hashset
            p3 -> p2+1

            t: 0(n^3)

       m-2
       nums = [-1,0,1,2,-1,-4]
       sort = [-4, -1, -1, 0, 1, 2]
       p1 -> 0
       p2 -> p1+1;
       p3 -> n-1;

       tar = 0
       sum = -4 + (-1) + 2 = -3 < tar
       t: 0(n^2)
        */

//        int[] nums = {-1,0,1,2,-1,-4};
//        int tar = 0;
//        Arrays.sort(nums);
//
//        List<List<Integer>> ansList = new ArrayList<>();
//
//        int n = nums.length;
//        int p1 = 0;
//
//        // 1, 2, 3, 4
//        while (p1 < n) {
//            int p2 = p1 + 1, p3 = n-1;
//            while(p2 < p3) {
//                int sum = nums[p1] + nums[p2] + nums[p3];
//                if(sum == tar) {
//                    ansList.add(Arrays.asList(nums[p1], nums[p2], nums[p3]));
//                    p2++;
//                    p3--;
//                }
//                else if(sum < tar) p2++;
//                else p3--;
//            }
//
//            if(p1+1 < n && nums[p1] == nums[p1+1]) {
//                while(p1+1 < n && nums[p1] == nums[p1+1] )p1++;
//            }
//            else p1++;
//
//        }
//
//        System.out.println("Triplets are "+ ansList);

        /*
            You are given an array of integers nums, there is a sliding window of
            size k which is moving from the very left of the array to the very right.
            You can only see the k numbers in the window. Each time the sliding window moves
            right by one position.

            Return the max sliding window.
            Example 1:
            Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
            Output: [3,3,5,5,6,7]

            M-1
            2^n
            subarray  = n(n+1)
            i -> 0 to n
             j -> i to n;
             k -> i to j

           0(n^3)

           M-2
           si = 0;
           ei = k-1;
           pq => 3, 6, 7
           ei = 5;
           ans = [3, 3, 5, 5, 6, 7]

           t: (n-k)*(log(k) + log(k))
           2*nlog(k);
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3, n = nums.length;

        for(int i = 0; i < k; i++) {
            pq.add(i);
        }
        // i = 3 - 3
        for(int i = k; i < n; i++) {
            int max = pq.remove(); // logk
            ans.add(nums[max]);

            if(max < i - k)
                pq.remove(max); // logk
        }
// 0(n*(2logk) => nlogk
        System.out.println("Max sliding window "+ ans);

        /*
        *   9
           /   \
          3      8
        /   \    / \
       2     1  7   9
         *
        * */
    }
}
