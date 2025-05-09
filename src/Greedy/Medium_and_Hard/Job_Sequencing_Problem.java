package Greedy.Medium_and_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Job_Sequencing_Problem {

    public class job implements Comparable<job> {
       int deadLine;
       int profit;

        public job(int deadLine, int profit) {
            this.deadLine = deadLine;
            this.profit = profit;
        }
        @Override
        public int compareTo(job other){
            if (this.profit<other.profit) return 1;
            if (this.profit> other.profit) return -1;
            return 0;
        }

    }
    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int n=deadline.length;
        int maxDeadLine=0;
        for (int e:deadline) maxDeadLine=Math.max(maxDeadLine,e);

        int [] markDeadLine=new int[maxDeadLine+1];



         int cnt=0;
         int maxProfit=0;
        job[] jobArray=new job[n];
        for (int i=0;i<n;i++){
            jobArray[i]=new job(deadline[i],profit[i]);
        }

        Arrays.sort(jobArray);


        for (int i=0;i<n;i++){
            int crntDeadLine =jobArray[i].deadLine;
            for (int j= crntDeadLine ;j>0;j--){
                if (markDeadLine[j]==0) {
                    markDeadLine[j]=1;
                    cnt++;
                    maxProfit+=jobArray[i].profit;
                }
            }
        }



        return new ArrayList<>( Arrays.asList(cnt, maxProfit)) ;
    }

    public static void main(String[] args) {

    }
}
