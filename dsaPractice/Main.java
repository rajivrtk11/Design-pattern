//package dsaPractice;
//
//import java.util.Arrays;
//import java.util.HashMap;
//
//public class Main {
//    int countPairs(int arr[], int target) {
//        // Your code here
//        int count = 0;
//        HashMap<Integer, Integer> freq = new HashMap<>();
//        for(int ele: arr) {
//            if(freq.containsKey(target - ele)) {
//                count += freq.get(target - ele);
//            }
//
//            freq.put(ele, freq.getOrDefault(ele, 0)+1);
//        }
//        return count;
//    }
//
//    public ListNode middleNode(ListNode head) {
//        /**
//         * 1. make slow and fast pointer
//         * 2. iterate through the list until its fast pointer reaches upto the end
//         * 3. return the slow pointer
//         */
//        ListNode slow = head, fast = head;
//        while(fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return slow;
//    }
//    public static void main(String[] args) {
//
//    }
//}
