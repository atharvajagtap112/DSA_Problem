package Trie;

import org.jetbrains.annotations.NotNull;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Maximum_XOR_With_an_Element_From_Array {

    class Node{
        Node[] links=new Node[2];

        boolean containsKey(int bit){
            return links[bit]!=null;
        }

        void put(int bit,Node node){
            links[bit]=node;
        }

        Node get(int bit ){
            return links[bit];
        }
    }

    class  Trie{
        Node root;
            public Trie(){
                this.root=new Node();
            }

            void insert(int num){
                Node node=root;
                for (int i=31;i>=0;i--){
                    int bit=(num>>i)&1;
                    if (!node.containsKey(bit)){
                        node.put(bit,new Node());
                    }
                    node=node.get(bit);
                }
            }

            int getMax(int num){
                Node node=root;
                int max=0;
                for (int i=31;i>=0;i--){
                    int bit=(num>>i)&1;
                  if (node.containsKey(1-bit)){
                      node=node.get(1-bit);
                      max=max | 1<<i;
                  }
                  else {
                       if(node.get(bit)==null)return -1;
                      node=node.get(bit);
                  }
                }
                return max;
            }
    }

    class tuple implements Comparable<tuple>{
        int x;
        int a;
        int i;

        public tuple(int x, int a, int i) {
            this.x = x;
            this.a = a;
            this.i = i;
        }

        @Override
        public int compareTo(@NotNull tuple other) {
           return Integer.compare(this.a,other.a);
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        Trie trie=new Trie();

        int n=queries.length;
        List<tuple> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(new tuple(queries[i][0],queries[i][1],i));
        }
        Collections.sort(list);
        int[] result=new int[n];

        int ind=0;
        for (tuple query:list){
            int x=query.x;
            int a= query.a;
            int i= query.i;

            while (ind<nums.length&&nums[ind]<=a){
                trie.insert(nums[ind]);
                ind++;
            }

            result[i]=trie.getMax(x);

        }
                return result;
    }

}
