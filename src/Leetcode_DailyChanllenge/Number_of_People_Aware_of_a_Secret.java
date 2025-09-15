package Leetcode_DailyChanllenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Number_of_People_Aware_of_a_Secret {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        Set<Integer> set=new HashSet<>();
        for (int [] edge:friendships){
            int [] arr1=languages[edge[0]];
            int [] arr2=languages[edge[1]];

            boolean flag=false;
            for (int a:arr1){
                for (int b:arr2){
                    if (a==b) {
                        flag=true;
                       break;
                    }
                }
            }
            if (!flag){
                set.add(edge[0]);
                set.add(edge[1]);
            }
        }

        int cnt=0;
        int[] freq=new int[501];
        for (Integer ele:set){
            for (int lang:languages[ele]){
                freq[lang]++;
                cnt=Math.max(cnt,freq[lang]);
            }
        }

      return   set.size()-cnt;
    }
}
