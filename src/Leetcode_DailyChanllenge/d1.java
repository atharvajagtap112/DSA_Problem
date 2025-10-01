package Leetcode_DailyChanllenge;

public class d1 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        while(numBottles>0){
            int div=numBottles/numExchange;
            ans+=div;
            numBottles=(numBottles-numExchange* div)+div;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9,3));
    }
}
