package Binary_Search.Medium;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {
  private static int noOfbouquets(int[] bloomDay, int day,int k) {
     int cnt=0;
     int bufe=0;
     for (int i=0;i<bloomDay.length;i++){
         if (bloomDay[i]<=day){
             cnt++;
         }
         else {
             bufe+=cnt/k;
             cnt=0;
         }
     }
     bufe+=cnt/k;
     return bufe;
  }

    public static int minDays(int[] bloomDay, int m, int k) {
      long n=bloomDay.length;
      long c= (long) m *k;
      if (n<c){
          return -1;
      }
        int min=bloomDay[0];
        int max=0;
        for (int i=0;i<bloomDay.length;i++) {
            max = Math.max(max, bloomDay[i]);
            min=Math.min(min,bloomDay[i]);
        }

        int low=min;
        int high=max;
        while (low<=high){
            int mid=low+(high-low)/2;
            int noOfbouquets1=noOfbouquets(bloomDay,mid,k);

            if (noOfbouquets1>=m) {
                high= mid-1;
            }
            else { low=mid+1;}
        }
        return low;
    }

    public static void main(String[] args) {
        int []arr={1,10,3,10,2};
        System.out.println(minDays(arr,3,1));
    }


}
