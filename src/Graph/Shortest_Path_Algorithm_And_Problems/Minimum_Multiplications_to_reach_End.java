package Graph.Shortest_Path_Algorithm_And_Problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Minimum_Multiplications_to_reach_End {
    int minimumMultiplications(int[] arr, int start, int end) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start, 0});

        int[] dist=new int[end+1];
        Arrays.fill(dist,(int)1e9);
        dist[start]=0;
        while (!pq.isEmpty()) {
            int mul = pq.peek()[0];
            int stp = pq.peek()[1];
               pq.poll();

            for (int ele : arr) {
                int nextMul=(ele * mul)%100000;
                int nxt=stp+1;
                if(dist[nextMul]>nxt){
                pq.add(new int[]{nextMul, nxt});
            }
        }

    }
        return dist[end]==(int)1e9?-1:dist[end];
}
}
