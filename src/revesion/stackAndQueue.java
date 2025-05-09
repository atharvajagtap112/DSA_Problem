package revesion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class stackAndQueue {
    public int trap(int[] height) {
     int lMax=0; int rMax=0;
     int l=0; int r= height.length-1;
     int total=0;
     while (l<=r){
         if (height[l]<=height[r]){
             if (height[l]<=lMax){
                 total+=lMax=height[l];
             }
             else{
                 lMax=height[l];
             }
             l++;
         }
         else {
             if (height[r]<=rMax){
                 total+=rMax=height[r];
             }
             else {
                 rMax=height[r];
             }
             r++;
         }
     }
    return total;
    }

    public static int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> stack=new ArrayList<>();
        int n=asteroids.length-1;
        for (int i=0;i<asteroids.length;i++){
            if (asteroids[i]>0) stack.add(asteroids[i]);
            else{
                if( stack.get(n-1)>0) {
                    while (!stack.isEmpty()&&stack.get(stack.size()-1)>0&&stack.get(stack.size()-1)<Math.abs(asteroids[i])) stack.remove(n-1);
                }
                if(stack.get(stack.size()-1)==Math.abs(asteroids[i]))  stack.remove(stack.size()-1);
                else if (stack.isEmpty()||stack.get(stack.size()-1)<0) stack.add(asteroids[i]);

            }

        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
 class Pair{
        int value;
        int index;
       public Pair( int vale, int index) {
            this.value=vale;
            this.index=index;
        }

 }
    class StockSpanner {
      Stack<Pair> stack;
      int index;

        public StockSpanner() {
              this.stack=new Stack<>();
         this.index=-1;
        }

        public int next(int price) {
          index++;
          while (!stack.empty()&&stack.peek().value<=price) {
              stack.pop();
          }
          int snap=stack.peek().index;
          stack.push( new Pair(price,index));
          return index-snap;
        }
    }

    class Node{
        int value;
        int key;
        int freq=-1;
        Node next=null;
        Node prev=null;
        public Node(){
            this.value=-1;
            this.key=-1;
        }
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }


    }



    class DoublyLinkedList{
        Node head;
        Node tail;
        int size;
        DoublyLinkedList(){
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            head.next=tail;
            tail.prev=head;
        }

        void addNode(Node node){
            Node headNext=head.next;
            head.next=node;
            node.next=headNext;
            headNext.prev=node;
            node.prev=head;
            size++;
        }

        void remove(Node node){
            Node nextNode=node.next;
            Node prevNode=node.prev;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            size--;
        }
    }

    class LFUCache {
        Map<Integer,Node> cache;

        Map<Integer, DoublyLinkedList> frequencyMap;
     int crntSize;
     int minFrequency;
     int capacity;
         public LFUCache(int capacity) {
            this.cache=new HashMap<>();
             this.frequencyMap=new HashMap<>();
             this.crntSize=0;
             this.minFrequency=0;
             this.capacity=capacity;
        }

        public int get(int key) {
         Node node =cache.get(key);
         if (node==null) return -1;

         updateNode(node);

         return node.value;
        }

        public void put(int key, int value) {
          if (cache.containsKey(key)){
              Node node =cache.get(key);
              node.value=value;
              updateNode(node);
          }
          else {
              crntSize++;
              if (crntSize>capacity){
                  DoublyLinkedList minFreqList=frequencyMap.get(minFrequency);
                  cache.remove(minFreqList.tail.prev.key);
                  minFreqList.remove(minFreqList.tail.prev);
                  crntSize--;
              }

                  minFrequency=1;
                  DoublyLinkedList minFreqList=frequencyMap.getOrDefault(minFrequency, new DoublyLinkedList());
                   Node newNode=new Node(key,value);
                   minFreqList.addNode(newNode);
                   cache.put(key,newNode);
                   frequencyMap.put(1,minFreqList);

          }

        }

        public void updateNode(Node node){
             int nodeFrequency=node.freq;
            DoublyLinkedList currentDLL =frequencyMap.get(nodeFrequency);
            currentDLL.remove(node);

            if (minFrequency==nodeFrequency&&currentDLL.size==0) {
                minFrequency++;
            }
            node.freq++;

            DoublyLinkedList newList=frequencyMap.getOrDefault(node.freq, new DoublyLinkedList());
            newList.addNode(node);
            frequencyMap.put(node.freq, newList);

        }
    }


    public static void main(String[] args) {
        System.out.println(asteroidCollision(new int[]{8,-8}).toString() );
    }










}
