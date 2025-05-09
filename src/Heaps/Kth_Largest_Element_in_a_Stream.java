package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream {

 
    class KthLargest {
        private PriorityQueue<Integer> pq; // Min-heap
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>(k); // Min-heap to store k largest elements
            for (int num : nums) {
                add(num); // Use add method to ensure heap size is maintained
            }
        }

        public int add(int val) {
            pq.add(val); // Add new element
            if (pq.size() > k) {
                pq.poll(); // Remove smallest element if heap size exceeds k
            }
            return pq.peek(); // Root of the heap is the kth largest element
        }
    }



}
