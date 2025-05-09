package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class Expression_Add_Operators {
    public List<String> addOperators(String num, int target) {
     List<String> ans=new ArrayList<>();
        solve(0,num,target,"",ans,0,0);
     return ans;
    }

    private void solve(int index, String num, int target, String curr,List<String> ans,int prev, int res) {

        if (index==num.length()){
            if(res==target){
                ans.add(curr);
            }
            return;
        }

         String st="";
        int currRes=0;
        for (int i=index;i<num.length();i++){
            if (i>index&&num.charAt(index)=='0') return;
        st+=num.charAt(i);
        currRes=currRes*10+num.charAt(i)-'0';
        if (index==0)
            solve(index+1,num,target,st,ans,currRes,currRes);
        else{
            solve(index+1,num,target,curr+"+"+st,ans,currRes,res+currRes);
            solve(index+1,num,target,curr+"-"+st,ans,currRes,res-currRes);
            solve(index+1,num,target,curr+"*"+st,ans,prev*currRes,res-prev+prev*currRes);
        }

        }

    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf("2"));
    }
}
