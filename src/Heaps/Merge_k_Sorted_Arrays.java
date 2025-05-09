package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Arrays {

    class Pair implements Comparable<Pair> {
        int value;
        int row;
        int col;

        Pair(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col= col;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }
    public  ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        ArrayList<Integer> result=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();

       for(int i=0;i<K;i++){
           pq.add( new Pair(arr[i][0],i,0 ));
       }

       while (!pq.isEmpty()){
           Pair pair=pq.poll();
           result.add(pair.value);
           if (pair.col<K){
               int row=pair.row;
               int col=pair.col+1;
               int value=arr[row][col];
               pq.add(new Pair(value, row, col));
           }
       }
return result;
    }

}
