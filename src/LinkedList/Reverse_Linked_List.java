package LinkedList;
 class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Reverse_Linked_List {
//    public ListNode reverseList(ListNode head) {
//        if (head==null){
//            return head;
//
//        }
//        ListNode prev=null;
//        ListNode present=head;
//        ListNode next=present.next;
//        while (present!=null){
//        ListNode front=present.next;
//        present.next=prev;
//        prev=present;
//        present=front;
//
//        }
//        return prev;
//    }

    //Recursive Way
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;

        }
       ListNode newHead=reverseList(head.next);
       ListNode front=head.next;
       front.next=head;
       head.next=null;

        return newHead;
    }
}
