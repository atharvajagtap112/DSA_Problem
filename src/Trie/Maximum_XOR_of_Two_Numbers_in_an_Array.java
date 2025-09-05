package Trie;

public class Maximum_XOR_of_Two_Numbers_in_an_Array {

    class Node{
       private Node[] links=new Node[2];

       public boolean containsKey(int bit){
            return links[bit]!=null;
        }

      public void put(int bit,Node node){
            links[bit]=node;
        }

       public Node get(int bit){
            return links[bit];
        }

    }

    class Trie{
        private Node root;
        public Trie(){
            root=new Node();
        }

       public void insert(int num){
            Node node=root;
            for (int i=31;i>=0;i--){
                int bit=(num >>i)&1;
                if (!node.containsKey(bit)){
                    node.put(bit,new Node());
                }
                node=node.get(bit);
            }
        }

       public int getMax(int num){
            int maxNum=0;
            Node node=root;
            for (int i=31;i>=0;i--){
                int bit=(num >>i)&1;
                if (node.containsKey(1-bit)){
                    maxNum=maxNum | i<<1;
                    node=node.get(1-bit);
                }
                else {
                    node=node.get(bit);
                }
            }
            return maxNum;
       }
    }
    public int findMaximumXOR(int[] nums) {
      Trie trie=new Trie();
      for (int num:nums) trie.insert(num);

      int max=0;
      for (int num:nums)max=Math.max(max,trie.getMax(num));

      return max;
    }
}
