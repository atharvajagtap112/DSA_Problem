package Graph.Topological_sort_and_problem;

import java.util.*;

public class Alien_Dictionary {

  public void topoSort(ArrayList<ArrayList<Integer>> adjList,StringBuilder result, int n){
        int[] inDegree=new int[n];
        for(int i=0;i<adjList.size();i++){
            for (int node:adjList.get(i)){
                inDegree[node]++;
            }}

        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<n;i++){
            if(inDegree[i]==0) {
                q.add(i);}
        }

        while (!q.isEmpty()){

            int node=q.poll();
           result.append((char) node+'a');
            for (int a:adjList.get(node)){
                inDegree[a]--;
                if(inDegree[a]==0) q.add(a);
            }
        }
    }
    public String findOrder(String[] words) {
        Set<Character> set=new HashSet<>();
        for (int i=0;i<words.length;i++){
            for (int j=0;j<words[i].length();j++){
                set.add(words[i].charAt(j));

            }}

        int n=set.size();

        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
         for (int k=0;k<n;k++) adjList.add(new ArrayList<>());

        for (int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            int len=Math.min(s1.length(),s2.length());

            for (int j=0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adjList.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }}
            StringBuilder result=new StringBuilder();

        topoSort(adjList,result,n);

         return result.toString();

    }
}
