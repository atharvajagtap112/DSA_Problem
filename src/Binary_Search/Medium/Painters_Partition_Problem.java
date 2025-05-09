package Binary_Search.Medium;

import java.util.ArrayList;

public class Painters_Partition_Problem {
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int max=0;
        int sum=0;
        for (int i=0;i<boards.size();i++){
            if (max<boards.get(i)) {
                max=boards.get(i);
            }
            sum+=boards.get(i);
        }
        int low=max;
        int high=sum;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (isValid(boards,mid,k)){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }

    private static boolean isValid(ArrayList<Integer> boards, int mid, int k) {
        int sum=0;
        int currK=1;
        for (int i=0;i<boards.size();i++){
            if (sum+boards.get(i)<=mid){
                sum+=boards.get(i);
            }
            else {
                sum=boards.get(i);
                currK++;
            }
        }

        return currK<=k;
    }

}
