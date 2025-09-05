package Trie;




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
        flag=true;
    }

    boolean isEnd(){
        return false;
    }

}

class Trie{
    Node root;
    public Trie(){
        root=new Node();
    }

    void insert(String word){
        Node node=root;
        for (int i=0;i<word.length();i++){
            if (!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
        }

        node.setEnd();
    }

    boolean contains(String word){
        Node node=root;
        for (int i=0;i<word.length();i++){
            if (!node.containsKey(word.charAt(i))){
               return false;
            }
            node=node.get(word.charAt(i));
        }
        return node.flag;
    }


}



public class Count_of_distinct_substrings {


    public static int countDistinctSubstring(String st) {
        Node root=new Node();


      int cnt=0; 
      for (int i=0;i<st.length();i++){
           Node node=root;
          for (int j=i;j<st.length();j++){
            if (!node.containsKey(st.charAt(j))){
                cnt++;
                node.put(st.charAt(i),new Node());
              }
          }
      }
       return cnt;
    }
}
