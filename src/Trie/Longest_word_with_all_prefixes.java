package Trie;

import java.util.List;

public class Longest_word_with_all_prefixes {

    class Node{
        Node[] links=new Node[26];
        boolean flag=false;

        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        void put(char ch,Node node){
            links[ch-'a']=node;
        }
          Node get(char ch){
            return links[ch-'a'];
        }
        void setEnd(){
            this.flag=true;
        }

        boolean isEnd(){
            return flag;
        }
    }

    class Trie{
        Node root;
          public Trie(){
              root=new Node();
          }

        public void insert(String word) {
              Node node =root;
              for (int i=0;i<word.length();i++){
                  if (!node.containsKey(word.charAt(i))){
                      node.put(word.charAt(i),new Node());
                  }
                  node=node.get(word.charAt(i));
              }
              node.setEnd();
        }

        public boolean search(String word){
              Node node=root;
              for (int i=0;i<word.length();i++){
                  if (!node.containsKey(word.charAt(i))||!node.get(word.charAt(i)).flag) return false;
                  node=node.get(word.charAt(i));
              }
              return node.flag;
        }
    }
    public String completeString(List<String> nums) {
       Trie trie=new Trie();
       for (String s:nums){
           trie.insert(s);
       }

       String ans="";
       for (String s:nums){
           if (trie.search(s))
            if( ans.length()<s.length()){
               ans=s;
           }
           else if (ans.length()==s.length()&&s.compareTo(ans)<0) ans=s;
       }
       return ans;
    }
}
