package Greedy.Medium_and_Hard;

import java.util.HashMap;
import java.util.Map;

public class Page_Faults_in_LRU {


    class Node {
        int value;
        int key;

        Node next;
        Node prev;
        public Node(int key, int value ){
            this.key=key;
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    };


    class LRUCache {
        Map<Integer, Node> map;
        Node head;
      Node tail;
        int capacity;

        int fault;
        public void insertAfterHead(Node node1){
               Node nextHead=head.next;
            head.next= node1;
            node1.next=nextHead;
            nextHead.prev= node1;
            node1.prev=head;
            this.fault=0;
        }

        public void deleteNode(Node node1){
            Node prevNode = node1.prev;
           Node nextNode = node1.next;
            prevNode.next= nextNode;
            nextNode.prev= prevNode;
        }

        public LRUCache(int capacity) {
            this.map=new HashMap<>();
            this.head=new Node(-1,-1);
            this.tail=new Node(-1,-1);
            this.capacity=capacity;

        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;

            Node node1 =map.get(key);
            deleteNode(node1);
            insertAfterHead(node1);
            return node1.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                Node node =map.get(key);
                node.value=value;
                deleteNode(node);
                insertAfterHead(node);
            }
            else {
                if (map.size()==capacity){
                  Node node1 =tail.prev;
                    map.remove(node1.key);
                    deleteNode(node1);
                }
                fault++;
                Node node1 =new Node(key,value);
                map.put(key, node1);
                insertAfterHead(node1);
            }


        }
        public int getFault(){
            return this.fault;
        }
    }

     int pageFaults(int N, int C, int pages[]){
        LRUCache lruCache=new LRUCache(C);
        for (int i=0;i<pages.length;i++) lruCache.put(i, pages[i]);
        return lruCache.getFault();
    }
}
