package Binary_Search.Easy;

import java.util.Arrays;

public class Ceil_The_Floor {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
    int ceil=-1;
    int floor=-1;
    int low=0;
    int  high=a.length-1;
    while (low<=high){
        int mid=(low+high)/2;
        if (x==a[mid]){
           return new int[]{a[mid],a[mid]};
        }
        if (a[mid]>x){
            high=mid-1;

        }
        else {
            low=mid+1;
        }
    }
    if (high<0) return new int[]{-1,a[low]};
    if (low>=n) return new int[]{a[high],-1};
    return new int[]{a[high],a[low]};
    }

    public static void main(String[] args) {
        int[]arr={3, 4, 7, 8, 8, 10};
        System.out.println(Arrays.toString(getFloorAndCeil(arr,arr.length,5)));
    }
}
