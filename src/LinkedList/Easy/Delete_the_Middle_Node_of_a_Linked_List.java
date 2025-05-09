package LinkedList.Easy;

public class Delete_the_Middle_Node_of_a_Linked_List {
    public ListNode deleteMiddle(ListNode head) {
        if (head==null||head.next==null) return null;
       ListNode fast=head;
       fast=head.next.next;

       ListNode slow=head;
       while (fast!=null&&fast.next!=null){

           slow=slow.next;
           fast=fast.next.next;

       }



        slow.next = slow.next.next;
       return head;
    }
}
