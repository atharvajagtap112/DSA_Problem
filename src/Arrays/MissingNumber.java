package Arrays;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int xor1=0;
        int xor2=0;
        int n=nums.length;
        for (int i=0;i<n;i++){
            xor2=xor2^nums[i];
            xor1=xor1^i+1;
        }
        return xor1^xor2;
    }

    public static void main(String[] args) {
        int[]arr={3,0,1};
        System.out.println(missingNumber(arr));
    }
}
