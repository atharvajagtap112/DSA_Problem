package Stack_And_Queues.monotonic_Stack_and_Queues;

import java.util.ArrayList;
import java.util.List;

public class Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
       List<Integer> st=new ArrayList<>();
       for (int i=0;i<asteroids.length;i++){
           int n=asteroids[i];
           if (n>0) st.add(n);
           else {
               while (!st.isEmpty()&&st.get(st.size()-1)>0&&Math.abs(n)>st.get(st.size()-1)) {
                   st.remove(st.size()-1);
               }
               if (!st.isEmpty()&&st.get(st.size()-1)==n) st.remove(st.size()-1);
               else if (st.isEmpty()||st.get(st.size()-1)<0) st.add(n);

           }

       }
       int []arr= new int[st.size()];
       for (int i=0;i<arr.length;i++){
           arr[i]=st.get(i);
       }
       return arr;
    }
}
