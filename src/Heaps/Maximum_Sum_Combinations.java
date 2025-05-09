package Heaps;

import java.util.*;

public class Maximum_Sum_Combinations {
    class Pair<K ,V> {
        K first;
        V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {

            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int n=A.size();
        Collections.sort(A);
        Collections.sort(B);
        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>> pq=new PriorityQueue<>((a,b)->b.first-a.first);
        Set<Pair<Integer,Integer>> set= new HashSet<>();
         ArrayList<Integer> result=new ArrayList<>();
        pq.add(new Pair<>(A.get(n-1)+B.get(n-1),new Pair<>(n-1,n-1) ));
        set.add(new Pair<>(n-1,n-1));

        while (C>0){
            Pair<Integer,Pair<Integer,Integer>> pair=pq.poll();
            int value=pair.first;
            int i =pair.second.first;
            int j=pair.second.second;
            result.add(value);

            if(j>0 &&!set.contains(new Pair<>(i,j-1))){
                pq.add(new Pair<>(A.get(i)+B.get(j-1),new Pair<>(i,j-1) ));
                set.add(new Pair<>(i,j-1));
            }
            if(i>0&&!set.contains(new Pair<>(i-1,j))){
                pq.add(new Pair<>(A.get(i-1)+B.get(j),new Pair<>(i-1,j) ));
                set.add(new Pair<>(i-1,j));
            }
            C--;


        }

return result;
    }
}
