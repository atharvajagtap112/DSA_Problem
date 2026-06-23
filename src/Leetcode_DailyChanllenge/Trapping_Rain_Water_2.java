package Leetcode_DailyChanllenge;

public class Trapping_Rain_Water_2 {
    static int  fun(int[] arr,int day,int k){
        int b=0;
        int i=0;
        int n=arr.length;
        while(i<n){
            int no=0;
            while(i<n&&arr[i]<=day){
                no++;
                i++;
            }
            b+=no/k;
            i++;
        }
        return b;
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int day:bloomDay){
            max=Math.max(max,day);
            min=Math.min(min,day);
        }

        int low=min;
        int high=max;
        while(low<=high){
            int mid=(low+high)/2;
            int b=fun(bloomDay,mid,k);
            if(b>=m) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1,10,3,10,2},3,1));
    }

}
