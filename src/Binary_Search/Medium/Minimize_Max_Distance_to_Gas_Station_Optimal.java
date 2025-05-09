package Binary_Search.Medium;

public class Minimize_Max_Distance_to_Gas_Station_Optimal {
    public static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length; // size of the array
        double low = 0;
        double high = 0;

        //Find the maximum distance:
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }

        //Apply Binary search:
        double diff = 1e-6; ;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationsRequired(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private static int numberOfGasStationsRequired(double dist, int[] arr) {
        int cnt=0;
        for (int i=1;i<arr.length;i++){
            int numInBet=(int)((arr[i]-arr[i-1])/dist);
            if (arr[i]-arr[i-1]==numInBet*dist){
                numInBet--;
            }
            cnt+=numInBet;
        }
        return cnt;
    }

   
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        double ans = minimiseMaxDistance(arr, k);
        System.out.println("The answer is: " + ans);
    }
}
