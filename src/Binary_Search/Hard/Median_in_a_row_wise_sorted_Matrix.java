package Binary_Search.Hard;

public class Median_in_a_row_wise_sorted_Matrix {
     int median(int[][] matrix, int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        // point low and high to right elements
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(matrix, m, n, mid);
            if (smallEqual <= req) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    private int countSmallEqual(int[][] matrix,int m,int n,int mid) {
            int cnt=0;
            for (int i=0;i<m;i++){
                cnt+=upperBound(matrix[i],mid,n);
            }
            return cnt;

    }

    private int upperBound(int[] matrix, int target,int n) {
        int low=0;
        int high=matrix.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if (matrix[mid]<=target){
                low=mid+1;
            }
            else high=mid-1;
        }
        return high+1;
}}
