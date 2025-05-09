package Binary_Search.Medium;

import java.util.Arrays;

public class Aggressive_Cows {
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

      int low=stalls[0];
      int high=stalls[stalls.length-1];
      while (low<=high){
          int mid=(low+high)/2;
          int noCows=noOfCowsPlaced(stalls,mid);
          if (noCows>=k){
              low=mid+1;
          }
          else high=mid-1;
      }
      return high;
    }

    private static int noOfCowsPlaced(int[] stalls, int minDist) {
        int nocow=1;
        int nostall=stalls[0];
        for (int i=1;i<stalls.length;i++){
            int dist=stalls[i]-nostall;
            if (minDist<=dist){
                nocow++;
                nostall=stalls[i];
            }
        }
        return nocow;
    }

    public static void main(String[] args) {
        int [] arr={0,3,4,7,10,9};
        System.out.println(aggressiveCows(arr,4));
    }
}
