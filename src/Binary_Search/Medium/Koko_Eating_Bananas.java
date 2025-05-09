package Binary_Search.Medium;

public class Koko_Eating_Bananas {
   private static int  max(int []arr){
        int max=0;
        for (int i=0;i<arr.length;i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    private static int calculateTotalHours(int[]arr,int n){
      int totalH=0;
        for (int i=0;i<arr.length;i++){
      totalH+=Math.ceil((double)(arr[i])/(double)(n));
        }
        return totalH;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=max(piles);
        while (low<=high){
            int mid=low+(high-low)/2;
            int totalH=calculateTotalHours(piles,mid);
            if (totalH<=h){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int []arr={3,6,7,11};
        System.out.println(minEatingSpeed(arr,8));

    }
}
