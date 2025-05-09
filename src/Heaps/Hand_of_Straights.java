package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Hand_of_Straights {
    class Pair implements Comparable<Pair>{
      int value;
      int freq;

        public Pair(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }


        @Override
        public int compareTo(Pair p) {
            return Integer.compare(value,p.value)  ;
        }
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int e:hand){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }


        while (!pq.isEmpty()){

            if(pq.size()<groupSize) {
                break; }
            int temp=0;
            ArrayList<Pair> list=new ArrayList<>();
            for (int i=1;i<=groupSize;i++) {
                if (!pq.isEmpty()) {
                    Pair pair = pq.poll();
                    if (temp!=0&&temp!=pair.value-1) return false;
                     temp=pair.value;
                    pair.freq--;
                    list.add(pair);
                }
            }

            for (Pair p:list) {
                if(p.freq>0)
                pq.add(p);
            }

        }

        return pq.isEmpty();
    }
}
