package Trie;

public class Trie_Implementation_and_Advanced_Operations {

    class Node{
        Node[] links=new Node[26];
        int cntEndWith;
        int cntPrefix;

        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        void put(char ch,Node node){
            links[ch-'a']=node;
        }

        void increaseEnd(){
            cntPrefix++;
        }

        void increasePrefix(){
            cntPrefix++;
        }

        void deleteEnd(){
            cntEndWith--;
        }

        void reducePrefix(){
            cntPrefix--;
        }
    }
    class Trie {

        Node root;
        public Trie() {
            root=new Node();
        }

        public void insert(String word) {
         Node node=root;
         for (int i=0;i<word.length();i++){
             if (!node.containsKey(word.charAt(i)))
                   node.put(word.charAt(i),new Node());

             node=node.get(word.charAt(i));
             node.increasePrefix();
         }
         node.increaseEnd();
        }

        public int countWordsEqualTo(String word) {
            Node node=root;
            for (int i=0;i<word.length();i++){
                if (!node.containsKey(word.charAt(i))) return 0;
                node=node.get(word.charAt(i));
            }
            return node.cntEndWith;
        }

        public int countWordsStartingWith(String prefix) {
            Node node=root;
            for (int i=0;i<prefix.length();i++){
                if (!node.containsKey(prefix.charAt(i))) return 0;
                node=node.get(prefix.charAt(i));
            }
            return node.cntPrefix;
        }

        public void erase(String word) {
          Node node =root;
          for (int i=0;i<word.length();i++){
              if(!node.containsKey(word.charAt(i)))return;
              node=node.get(word.charAt(i));
              node.reducePrefix();
          }
          node.deleteEnd();
        }
    }

}
