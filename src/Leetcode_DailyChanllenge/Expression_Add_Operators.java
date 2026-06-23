package Leetcode_DailyChanllenge;

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators {
    public List<String> addOperators(String num, int target) {
        List<String> ans=new ArrayList<>();
        int ind=0;
        while(num.charAt(ind)=='0') {
            ind++;
        }
        solve(ind+1,num,target, String.valueOf(num.charAt(ind)),ans,num.charAt(ind)-'0',num.charAt(ind)-'0' );
        return ans;
    }

    private void solve(int i, String num, int target, String curr,List<String> ans,long res, long preValue) {

        if (i==num.length()){
            if(res==target){
                ans.add(curr);
            }
            return;
        }

        char st=num.charAt(i);
        int no=st-'0';

        solve(i+1,num,target,curr+"+"+st,ans,res+no,no);
        solve(i+1,num,target,curr+"-"+st,ans,res-no,-no);
        solve(i+1,num,target,curr+"*"+st,ans ,res-preValue+(preValue*no), preValue*no);


    }
}
