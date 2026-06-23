package Leetcode_DailyChanllenge;

import java.util.*;

public class d1 {



    public static void main(String[] args) {



      int[] At={0,1,2,4,};
      int[] Bt={5,3,4,1};


      Map<Integer,Integer> map=Map.of(0,0,
              1,1,
              2,2,
              4,3);

     PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]==b[1]?Integer.compare(At[a[0]],At[b[0]]):Integer.compare(a[1],b[1]));
     pq.add(new int[]{0,5});

        int cnt=1;
     while (!pq.isEmpty()){

        int[] temp =pq.poll();
        if (temp[1]-1!=0)
         pq.add(new int[]{temp[0],temp[1]-1});


        if (map.containsKey(cnt)){
            pq.add(new int[]{map.get(cnt), Bt[map.get(cnt)] });
        }
        if (!pq.isEmpty())
           System.out.print(pq.peek()[0]+1+"   ");
        cnt++;
     }




//        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->p[a]==p[b]?Integer.compare(At[a],At[b]):Integer.compare(p[a],p[b]));
//        pq.add(0);
//     int[] visi=new int[7];
//      visi[0]=1;
//         int brust=0;
//        while (!pq.isEmpty()){
//            int ind=pq.poll();
//            System.out.print(ind+1+"    ");
//            System.out.print(" \n"+1+"      "+1);
//            brust+=Bt[ind];
//            for (int i=0;i<7;i++){
//                if (brust>=At[i]&&visi[i]!=1){
//                    pq.add(i);
//                    visi[i]=1;
//                }
//            }
//
//        }



    }





}
