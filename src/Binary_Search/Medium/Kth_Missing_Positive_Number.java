package Binary_Search.Medium;

public class Kth_Missing_Positive_Number {
    public int findKthPositive(int[] arr, int k) {
      int low=0;
      int high=arr.length;

      while (low<=high){
          int mid=(low+high)/2;
          int missing=(arr[mid]-mid)-1;
          if (missing>k){
              high=mid-1;
          }
          else {
              low=mid+1;
          }
      }
      return k+high+1;

    }
}
