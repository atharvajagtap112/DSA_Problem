package Graph.Easy;

import java.util.*;

public class word_ladder_optimal {
    List<List<String>> ans=new ArrayList<>();
    Map<String,Integer> map=new HashMap<>();
    String b;

    private void dfs(String word,List<String> ls ){

        if(word.equals(b)){
            Collections.reverse(ls);
            ans.add(new ArrayList<>(ls));
            Collections.reverse(ls);
            return;
        }

        int step=map.get(word);
        int size=word.length();

        for (int i=0;i<size;i++){
            char[] charArray=word.toCharArray();

            for (char ch='a';ch<='z';ch++) {
             charArray[i]=ch;
             String newWord=new String(charArray);
             if(map.containsKey(newWord)&& map.get(newWord)+1==step){
                 ls.add(newWord);
                 dfs(newWord,ls);
                 ls.remove(newWord);
             }
            }
        }


    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        b=beginWord;

        q.add(beginWord);
        set.remove(beginWord);
        map.put(beginWord,1);

        while (!q.isEmpty()){
            String orignalWord=q.poll();
            int size=orignalWord.length();
            int step=map.get(orignalWord);

            if(orignalWord.equals(endWord)) break;
            for (int i=0;i<size;i++){
                char[] charArray=orignalWord.toCharArray();

                for (char ch='a';ch<='z';ch++) {
                   charArray[i]=ch;
                   String newWord=new String(charArray);
                   if (set.contains(newWord)){
                       set.remove(newWord);
                       map.put(newWord,step+1);
                       q.add(newWord);
                   }

                }
            }
        }

        if (map.containsKey(endWord)){
            ArrayList<String> list=new ArrayList<>();
            list.add(endWord);
            dfs(endWord,list);
        }
   return ans;
    }

}
