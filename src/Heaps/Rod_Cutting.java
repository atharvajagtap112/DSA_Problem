package Heaps;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Rod_Cutting {
    public int minCost(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for (int e:arr) pq.add(e);
        int minCost=0;
        while (!pq.isEmpty()){
            if (pq.size()==1){
                minCost+=pq.poll();
                break;
            }

            int first=pq.poll();
            int second=pq.poll();
            int cost=first+second;
            minCost+=cost;
            pq.add(cost);
        }

        return minCost;
    }
}
