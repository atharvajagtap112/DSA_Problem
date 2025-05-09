package Graph.Easy;

import java.util.*;

public class Word_Ladder_II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>(wordList);
        Queue<List<String>> q=new LinkedList<>();
        List<String> usedOnLevel=new ArrayList<>();
        int level=0;
        ArrayList<String> ls=new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);
        usedOnLevel.add(beginWord);
        List<List<String>> ans=new ArrayList<>();

        while (!q.isEmpty()){
            List<String > vec=q.poll();
            if(q.size()>level){
                level++;
                for (String s:usedOnLevel){
                    set.remove(s);
                    usedOnLevel.clear();
                }}
            String originalWord=vec.get(vec.size()-1);

            if(originalWord.equals(endWord)){
                if(ans.size()==0){
                    ans.add(vec);
                }
                else if (ans.get(0).size()==vec.size()){
                    ans.add(vec);
                }
            }

            for (int i=0;i<originalWord.length();i++){
                for (char ch='a';ch<='z';ch++){
                    char [] charArray=originalWord.toCharArray();
                    charArray[i]=ch;
                    String newWord=new String(charArray);
                    if(set.contains(newWord)){
                        vec.add(newWord);
                        ArrayList<String > newList=new ArrayList<>(vec);
                        usedOnLevel.add(newWord);
                        q.add(newList);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
return ans;
    }


}
