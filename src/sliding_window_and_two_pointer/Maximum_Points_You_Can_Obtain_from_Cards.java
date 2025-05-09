package sliding_window_and_two_pointer;

public class Maximum_Points_You_Can_Obtain_from_Cards {

    public static int maxScore(int[] cardPoints, int k) {
        int lSum=0; int rSum=0; int maxSum=0;
        for (int i=0;i<k;i++) lSum+=cardPoints[i];
        maxSum=lSum;
        int n=cardPoints.length;
        for (int i=1;i<=k;i++){
            lSum=lSum-cardPoints[k-i];
            rSum=rSum+cardPoints[n-i];
            maxSum=Math.max(maxSum,lSum+rSum);
        }
            return maxSum;

    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{6,2,3,4,7,2,1,7,1}, 4));
    }
}
