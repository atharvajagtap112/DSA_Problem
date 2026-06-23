package Leetcode_DailyChanllenge;

import java.util.HashMap;
import java.util.Map;

public class Longest_Balanced_Substring_II {

    public int funAB(String s){
        int cnt1=0;
        int cnt2=0;
        int maxL=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == 'c') {
                cnt1 = 0;
                cnt2 = 0;
                map = new HashMap<>();
                continue;
            }
            char ch = s.charAt(i);
            if (ch == 'a') cnt1++;
            else cnt2++;

            if (cnt2 == cnt1) maxL = Math.max(maxL, cnt2 + cnt1);
            int diff = cnt1 - cnt2;
            if (map.containsKey(diff)) {
                maxL = Math.max(maxL,i- map.get(diff)  + 1);
            } else map.put(diff, i);
        }
            return maxL;
    }


    public int funAC(String s){
        int cnt1=0;
        int cnt2=0;
        int maxL=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == 'b') {
                cnt1 = 0;
                cnt2 = 0;
                map = new HashMap<>();
                continue;
            }
            char ch = s.charAt(i);
            if (ch == 'a') cnt1++;
            else cnt2++;

            if (cnt2 == cnt1) maxL = Math.max(maxL, cnt2 + cnt1);
            int diff = cnt1 - cnt2;
            if (map.containsKey(diff)) {
                maxL = Math.max(maxL,i- map.get(diff)  + 1);
            } else map.put(diff, i);
        }
        return maxL;
    }

    public int funBC(String s){
        int cnt1=0;
        int cnt2=0;
        int maxL=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == 'a') {
                cnt1 = 0;
                cnt2 = 0;
                map = new HashMap<>();
                continue;
            }
            char ch = s.charAt(i);
            if (ch == 'b') cnt1++;
            else cnt2++;

            if (cnt2 == cnt1) maxL = Math.max(maxL, cnt2 + cnt1);
            int diff = cnt1 - cnt2;
            if (map.containsKey(diff)) {
                maxL = Math.max(maxL,i- map.get(diff)  + 1);
            } else map.put(diff, i);
        }
        return maxL;
    }

    public int funABC(String s){
        int cntA=0;
        int cntB=0;
        int cntC=0;

        int maxL=0;

        Map<String,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (ch=='a') cntA++;
            else if (ch=='b') cntB++;
            else cntC++;

            if (cntA==cntB&& cntA==cntC) maxL=Math.max(maxL,cntA+cntB+cntC);

            int diff1=cntA-cntB;
            int diff2=cntA-cntC;
            String str=diff1+","+diff2;
            if (map.containsKey(str)){
                maxL=Math.max(maxL,map.get(str)-i+1);
            }
            else map.put(str,i);
        }
        return maxL;
    }
    public int longestBalanced(String s) {
     int n=s.length();
     int maxL=0;
     int cnt=1;
     for (int i=0;i<n-1;i++){
         if(s.charAt(i)==s.charAt(i+1)){
             cnt++;
         }
         else {
             maxL=Math.max(maxL,cnt);
             cnt=1;
         }
     }

     maxL=Math.max(maxL,cnt);
     maxL=Math.max(maxL,Math.max(funAB(s),Math.max(funAC(s),funBC(s))));
     maxL=Math.max(maxL,funABC(s));

      return maxL;
    }
}
