package LinkedList.Easy;
class ListNode {
    int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
       ListNode f=head;
       ListNode s=head;
       while (f.next.next!=null){
           f=f.next.next;
           s=s.next;
           if (f==s){
               return true;
           }
       }
        return false;
    }
}
