package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class Count_Inversions {
    static long inversionCount(long arr[], int n) {
      return merge(arr,0, n-1);
    }
    public static int merge(long []arr,int low ,int high){
        int cnt=0;
        if (low>=high){
            return cnt;

        }

        int mid=(low+high)/2;
       cnt+= merge(arr, low,mid );
        cnt+=merge(arr,mid+1,high);
       cnt+= mergeSort(arr,low,mid,high);
       return cnt;
    }

    public static int mergeSort(long[] arr, int low, int mid,int high) {
        ArrayList<Long>list=new ArrayList<>();
        int left=low;
        int right=mid+1;
        int count=0;
        while (left<=mid&&right<=high){
            if (arr[left]<=arr[right]){
                list.add(arr[left]);
                left++;
            }
            else {
                list.add((long) right);
                count += (mid - left+1);
                right++;
            }
            }
            while (left <= mid) {
                list.add(arr[left]);
                left++;
            }

            //  if elements on the right half are still left //
            while (right <= high) {
                list.add(arr[right]);
                right++;
            }

            // transfering all elements from temporary to arr //
            for (int i = low; i <= high; i++) {
                arr[i] =  list.get(i - low);

        }
            return count;
    }





    public static void main(String[] args) {
        long[] a = {};
        System.out.println(inversionCount(a, a.length));
    }
}
