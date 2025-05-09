package Binary_Search;

import java.util.Arrays;

public class Ceil_The_Floor {
   static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int floor=-1;
        int ceil=-1;
      for (int i=0;i<n;i++){
          if (arr[i]>=x){
              if (ceil<0){
                  ceil=arr[i];
              }
              else {ceil=Math.min(ceil,arr[i]);}
          }
          if (arr[i]<=x){
              if (floor<0){
                  floor=arr[i];
              }
              else {
              floor=Math.max(floor,arr[i]);}
          }
      }
      return new int[]{floor,ceil};
    }

    public static void main(String[] args) {
        int []arr={5, 6, 8, 9, 6, 5, 5, 6};
        System.out.println(Arrays.toString(getFloorAndCeil(arr, arr.length,10)));
    }
}
