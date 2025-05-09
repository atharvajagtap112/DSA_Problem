package Stack_And_Queues.Implementation_Problem;

import java.util.HashMap;
import java.util.Map;

class Node1 {
    int value;
    int key;
    Node1 next;
    Node1 prev;
    public Node1(int key, int value ){
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
};


class LRUCache {
    Map<Integer, Node1> map;
    Node1 head;
    Node1 tail;
    int capacity;
    public void insertAfterHead(Node1 node1){
      Node1 nextHead=head.next;
      head.next= node1;
      node1.next=nextHead;
      nextHead.prev= node1;
      node1.prev=head;
    }

    public void deleteNode(Node1 node1){
        Node1 prevNode1 = node1.prev;
        Node1 nextNode1 = node1.next;
        prevNode1.next= nextNode1;
        nextNode1.prev= prevNode1;
    }

    public LRUCache(int capacity) {
      this.map=new HashMap<>();
      this.head=new Node1(-1,-1);
      this.tail=new Node1(-1,-1);
      this.capacity=capacity;

    }

    public int get(int key) {
     if (!map.containsKey(key)) return -1;

         Node1 node1 =map.get(key);
        deleteNode(node1);
        insertAfterHead(node1);
     return node1.value;
    }

    public void put(int key, int value) {
     if (map.containsKey(key)){
         Node1 node1 =map.get(key);
         node1.value=value;
         deleteNode(node1);
         insertAfterHead(node1);
     }
     else {
         if (map.size()==capacity){
             Node1 node1 =tail.prev;
             map.remove(node1.key);
             deleteNode(node1);
         }
         Node1 node1 =new Node1(key,value);
         map.put(key, node1);
         insertAfterHead(node1);
     }
    }
}