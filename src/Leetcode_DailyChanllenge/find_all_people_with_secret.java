package Leetcode_DailyChanllenge;

import java.util.*;

public class find_all_people_with_secret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        ArrayList<ArrayList<int[]>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int [] meeting:meetings){
            int a=meeting[0];
            int b=meeting[1];
            int t=meeting[2];

            adjList.get(a).add(new int[]{b,t});
            adjList.get(b).add(new int[]{a,t});
        }



        int[] time=new int[n];
          Arrays.fill(time,Integer.MAX_VALUE);
     time[0]=0;
     time[firstPerson]=0;

        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{0,0});
        pq.add(new int[]{firstPerson,0});

        while(!pq.isEmpty()){
            int p1=pq.peek()[0];
            int t=pq.peek()[1];
            pq.poll();

            for(int[] adjValue:adjList.get(p1) ){
                int p2=adjValue[0];
                int curTime=adjValue[1];

                if(t<=curTime&&curTime<time[p2]){
                    time[p2]=curTime;
                    pq.add(new int[]{p2,curTime});
                }
            }
        }
        ArrayList<Integer> result=new ArrayList<>();

        for (int t:time){
            if(t!=Integer.MAX_VALUE) result.add(t);
        }
        return result;
    }
}
