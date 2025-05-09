package Binary_Search.Medium;

public class Capacity_To_Ship_Packages_Within_D_Days {
   private static int minCapacity(int []arr,int maxcapci){
     int crntWeight=0;
     int crntDays=1;
     for (int i=0;i<arr.length;i++){
         if (crntWeight+arr[i]<=maxcapci){
             crntWeight+=arr[i];
         }
         else {
             crntWeight=arr[i];
             crntDays+=1;
         }
     }

     return crntDays;
   }
    public static int shipWithinDays(int[] weights, int days) {
        int max=0;
           int sum=0;
        for (int i=0;i<weights.length;i++) {
            max = Math.max(max, weights[i]);
             sum+=weights[i];

        }
        int low=max;
        int high=sum;
        while (low<=high){
            int mid= low+(high-low)/2;
            if (minCapacity(weights,mid)<=days){
                high=mid-1;

            }
            else {
                low=mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int []arr={3,2,2,4,1,4};
        System.out.println(shipWithinDays(arr,3));
    }
}
