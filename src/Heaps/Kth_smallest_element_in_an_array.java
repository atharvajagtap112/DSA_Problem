package Heaps;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_smallest_element_in_an_array {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for (int i=k;i< arr.length;i++){
            if (pq.peek()>arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
}
