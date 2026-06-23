package Leetcode_DailyChanllenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Cost_to_Convert_String_I {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n=source.length();
        int[][]adjMatrix=new int[26][26];
        int m=original.length;

        for (int i=0;i<26;i++){
            for (int j=0;j<26;j++){
                adjMatrix[i][j]=(int)1e9;
            }
        }
        for (int i=0;i<m;i++){
            adjMatrix[(int)original[i]-'a'][(int)changed[i]-'a']=cost[i];
        }

        for (int k=0;k<26;k++){
            for (int i=0;i<26;i++){
                for (int j=0;j<26;j++){
                    adjMatrix[i][j]=Math.min(adjMatrix[i][j],adjMatrix[i][k]+adjMatrix[k][j]);
                }
            }
        }

        int cst=0;
        for (int i=0;i<n;i++){
            if (source.charAt(i)==target.charAt(i)) continue;
            if (adjMatrix[source.charAt(i)-'a'][target.charAt(i)-'a']>=1e9) return -1;
            cst+=adjMatrix[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }

    return cst ;
    }
}
