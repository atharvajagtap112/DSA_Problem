package Greedy.Medium_and_Hard;

public class Jump_Game {
    public static boolean canJump(int[] nums) {
     int maxInd=0;
        for (int i=0;i<nums.length;i++){
            if (maxInd<i) return false;
            if (maxInd<nums[i]+i) maxInd=nums[i]+i;
        }
     return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));

    }
}
