package Greedy.Medium_and_Hard;

public class Shortest_Job_first {
    static int solve(int bt[] ) {
       int wt=0;
       for (int i=0;i< bt.length;i++){
           wt+=(i*(i+1))/2;
       }
         return wt/ bt.length;
    }
}
