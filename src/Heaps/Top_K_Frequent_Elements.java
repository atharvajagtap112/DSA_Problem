package Heaps;

import java.lang.reflect.Array;
import java.util.*;

public class Top_K_Frequent_Elements {
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
        int[] result=new int[k];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }
        for (Map.Entry<Integer,Integer> ele:map.entrySet()){
            pq.add(new Pair(ele.getKey(), ele.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }

        for (int i=0;i<k;i++){
            result[i]=pq.poll().freq;
        }

        return result;
    }
}
