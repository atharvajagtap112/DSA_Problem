package Leetcode_DailyChanllenge;

public class Minimum_Operations_to_Make_the_Integer_Zero {

    public int makeTheIntegerZero(int num1, int num2) {

        for(int k=0;k<=60;k++){
            long target=num1-k*1L*num2;
            if(target<=0) return -1;

            if(k<=target&&k>=Long.bitCount(target)) return k;
        }
        return -1;
    }
}
