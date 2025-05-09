package Graph.Easy;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Word_Ladder {
    class pair{
        String first;
        int second;

        public pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Queue<pair> queue=new LinkedList<>();
            Set<String> set= new HashSet<>(wordList);

            queue.add(new pair(beginWord,1));
            set.remove(beginWord);

            while (!queue.isEmpty()){
                String word=queue.peek().first;
                int level=queue.peek().second;
                queue.poll();

                if(word.equals(endWord)) return level;

                for (int i=0;i<word.length();i++){
                    for (char ch='a';ch<='z';ch++){
                        char[] originalWord=word.toCharArray();
                          originalWord[i]=ch;
                          String newWord=new String(originalWord);
                          if(set.contains(newWord)==true){
                              set.remove(newWord);
                              queue.add(new pair(newWord,level+1));
                          }
                    }
                }


            }
            return 0;
    }
}
