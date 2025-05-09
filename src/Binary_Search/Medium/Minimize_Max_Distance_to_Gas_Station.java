package Binary_Search.Medium;

public class Minimize_Max_Distance_to_Gas_Station {
    public static double numberOfGasStationsRequired(double dist, int[] arr) {
      int maxAvgDist=0;
      int maxdist=0;
      for (int i=1;i<arr.length;i++){
          if (maxAvgDist<(arr[i]-arr[i-1])){
              maxAvgDist=arr[i]-arr[i-1];

          }
          maxdist+=(arr[i]-arr[i-1]);
      }
        double low=0.1;
        double high=maxAvgDist;
        while (low<=high){
            double mid=low+(high-low)/2;
            if (isMaxdist(arr,mid,arr.length+dist,maxdist)){
                high=mid-0.1;
            }
            else {
             low=mid+0.1;
            }
        }
        return low;
    }

    private static boolean isMaxdist(int[] arr, double dist, double noOfGS,int maxdist) {
        int currntNoGS=1;
        double currntdist=0;
        while (currntdist<=maxdist){
            currntdist+=dist;
            currntNoGS++;
        }
        return currntNoGS<=noOfGS;
    }

    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        System.out.println(numberOfGasStationsRequired(4,arr));

    }

}
