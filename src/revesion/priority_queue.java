package revesion;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class priority_queue {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int n:nums){
            pq.add(n);
            while (pq.size()>k) pq.poll();}
        return pq.peek();
    }

    class KthLargest {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size;

        public KthLargest(int k, int[] nums) {
            this.size = k;
            for (int n : nums) {
                pq.add(n);
                while (pq.size() > size) pq.poll();
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > size) pq.poll();


            return pq.peek();
        }
    }



    class Pair implements Comparable<Pair>{
        int value;
        int freq;

        public Pair(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair obj) {
            return this.freq-obj.freq;
        }


    }
    public int[] topKFrequent(int[] nums, int k) {
        int [] result=new int [k];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry :map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }

       

        for (int i=0;i<k;i++){
            result[i]=pq.poll().value;
        }
        return result;
    }


    class MedianFinder {
       PriorityQueue<Integer> maxHeap;
       PriorityQueue<Integer> minHeap;
        public MedianFinder() {
      this.maxHeap=new PriorityQueue<>(Collections.reverseOrder());
      this.minHeap=new PriorityQueue<>();
        }

        public void addNum(int num) {
          if(maxHeap.isEmpty()||maxHeap.peek()<num) maxHeap.add(num);
          else minHeap.add(num);

          if(maxHeap.size()>minHeap.size()) {
              minHeap.add(maxHeap.poll());
          }
          else if (minHeap.size()>maxHeap.size()){
              maxHeap.add(minHeap.poll());
          }
        }

        public double findMedian() {
         if(maxHeap.size()==minHeap.size()) return maxHeap.peek()/2.0+minHeap.peek()/2.0;

         else return maxHeap.peek();
        }
    }
}
