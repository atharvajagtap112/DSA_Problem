package Leetcode_DailyChanllenge;

import java.util.HashMap;
import java.util.Map;

public class Maximize_the_Number_of_Partitions_After_Operations {


    public int solve(int i, long unique_Char, int canChange, String s, int k, Map<Long,Integer> dp){


        long key= ((i<<27) | (unique_Char<<1) | (canChange) );
        if(dp.containsKey(key)) return  dp.get(key);

        if (i>=s.length()) return 0;
        int ind=s.charAt(i)-'a';

        long updUniqueChar=unique_Char|(1<<ind);
        long bitCount=Long.bitCount(updUniqueChar);

        int result=0;
        if (bitCount>k){
            result=1+solve(i+1,1<<ind,canChange,s,k,dp);
        }
        else {
            result=solve(i+1,updUniqueChar,canChange,s,k,dp);

        }

        if (canChange==1){
            for (int ch=0;ch<26;ch++){
                long chgChar=unique_Char|(1<<ch);
                if (Long.bitCount(chgChar)>k){
                    result=Math.max(result,1+solve(i+1,1<<ch,0,s,k,dp));
                }
                else result=Math.max(result,solve(i+1,chgChar,0,s,k,dp));
            }
        }

        dp.put(key,result );
        return dp.get(key) ;
    }
    public int maxPartitionsAfterOperations(String s, int k) {
        Map<Long,Integer> dp=new HashMap<>();
        return solve(0,0,1,s,k,dp)+1;
    }
}
