package Leetcode_DailyChanllenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Minimum_Cost_to_Convert_String_II {
    class TrieNode{
        int id;
        TrieNode[] nodeArray=new TrieNode[26];

        public TrieNode(int id) {
            this.id = id;
        }
    }

    public void insert(TrieNode root,String str,int id){
        TrieNode temp=root;
        for (char ch:str.toCharArray()){
            int idx=ch-'a';
            if (root.nodeArray[idx]==null){
                root.nodeArray[idx]=new TrieNode(-1);
              temp=root.nodeArray[idx];
            }

        }
        temp.id=id;
    }
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
     int n=source.length();
     TrieNode root=new TrieNode(-1);
        Map<String,Integer> map=new HashMap<>();
        int strCounter=0;
        for (String str:original){
            if (!map.containsKey(str)){
                map.put(str,strCounter);
                insert(root,str,strCounter);
             strCounter++;
            }

        }
        for (String str:changed){
            if (!map.containsKey(str)){
                map.put(str,strCounter);
                insert(root,str,strCounter);
                strCounter++;
            }

        }
        long INF=Long.MAX_VALUE;

        long[][] adjMatrix=new long[strCounter][strCounter];
        for (int i=0;i<strCounter;i++){
            for (int j=0;j<strCounter;j++){
                if (i==j)continue;
                adjMatrix[i][j]=INF;
            }
        }

        for (int k=0;k<n;k++){
            int i=map.get(original[k]);
            int j=map.get(changed[k]);
            adjMatrix[i][j]=Math.min(adjMatrix[i][j],cost[k]);
        }

        for (int k=0;k<strCounter;k++){
            for (int i=0;i<strCounter;i++){
                if (adjMatrix[i][k]==INF) continue;
                for (int j=0;j<strCounter;j++){
                    if (adjMatrix[k][j]==INF)continue;

                    adjMatrix[i][j]=Math.min(adjMatrix[i][j],adjMatrix[i][k]+adjMatrix[k][j]);
                }
            }
        }


        long[] dp=new long[n+1];
        Arrays.fill(dp,INF);
        dp[0]=0;
        char[] sourceArray=source.toCharArray();
        char[] targetArray=target.toCharArray();

        for (int i=0;i<n;i++){
            if (dp[i]==INF)continue;
            if (sourceArray[i]==targetArray[i]) dp[i+1]=Math.min(dp[i],dp[i+1]);

            TrieNode targetNode=root;
            Map<Integer,Integer> lengthToInd=new HashMap<>();
            for (int j=i;j<n;j++){
                int idx=targetArray[j]-'a';
                if (root.nodeArray[idx]==null)break;
                 targetNode=root.nodeArray[idx];
                 if (targetNode.id!=-1) lengthToInd.put(j-i+1, targetNode.id);

            }

            TrieNode srcNode=root;
            for (int j=i;j<n;j++){
                int idx=sourceArray[j]-'a';
                if (root.nodeArray[idx]==null)break;
                srcNode=root.nodeArray[idx];
                if (srcNode.id!=-1){
                    int len=j-i+1;
                    int srcId= srcNode.id;
                    if (lengthToInd.containsKey(len)){
                        int tarId=lengthToInd.get(len);
                        if (adjMatrix[srcId][tarId]!=INF){
                            dp[len+1]=Math.min(dp[len+1],dp[i]+adjMatrix[srcId][tarId]);
                        }
                    }
                }
            }
        }
        return dp[strCounter]==INF?-1:dp[strCounter];
    }
}
