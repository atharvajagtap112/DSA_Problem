package Bit_Manipulation;

public class Minimum_Bit_Flips_to_Convert_Number {

    public static int minBitFlips(int start, int goal) {
      int cnt=0;
      for (int i=0;i<31;i++){
          if (start==goal) return cnt;
          int rsStart=start>>i;
          int rsGoal=goal>>i;
          if ((rsStart&1)!=(rsGoal&1)){
             start= start^1<<i;
             cnt++;
          }
      }
      return cnt;
    }
    public static void main(String[] args) {
        int n=2;
        System.out.println(n<<0);
        System.out.println(minBitFlips(11,15));
    }
}
