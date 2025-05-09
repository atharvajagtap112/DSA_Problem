package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int [] map=new int[26];
        for (char ch:tasks) map[ch-'A']++;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int i:map) if (i!=0) pq.add(i);
        int time=0;
        while (!pq.isEmpty()){
            ArrayList<Integer> temp=new ArrayList<>();
            for (int i=1;i<=n+1;i++){
               int freq= pq.poll();
               temp.add(freq--);
            }
            for (int e: temp) if (e!=0) pq.add(e);
           time+= pq.isEmpty()? temp.size():n+1;
        }
        return time;
    }
}
