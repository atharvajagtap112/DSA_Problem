package Heaps;

import java.util.PriorityQueue;

public class Replace_elements_by_its_rank_in_the_array {

    class Pair  implements Comparable<Pair>{
        int index;
        int value;
        Pair(int value , int index){
            this.index=index;
            this.value=value;
        }

        @Override
        public int compareTo(Pair p) {
           return Integer.compare(value,p.value);
        }
    }


     int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for (int i=0;i<arr.length;i++){
            pq.add(new Pair(arr[i],i));
        }
        int cnt=0;
        while (!pq.isEmpty()){
            cnt++;
            Pair pair=pq.poll();
            arr[pair.index]=cnt;
            while (pair.value==pq.peek().value){
                arr[pq.poll().index]=cnt;
            }
        }
        return arr;
    }
}
