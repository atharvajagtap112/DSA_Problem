package Heaps;

import org.w3c.dom.Node;
import revesion.string;

import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result=new ListNode(-1) ;
        ListNode temp=result;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> Integer.compare(a.val,b.val));
        for (int i=0;i<lists.length;i++){
            pq.add(lists[i]);
        }

        while (!pq.isEmpty()){
            ListNode node=pq.poll();
            temp.next=node;
            temp=node;
            if (node.next!=null){
                pq.add(node.next);
            }
        }
        return result.next;
     }
}
