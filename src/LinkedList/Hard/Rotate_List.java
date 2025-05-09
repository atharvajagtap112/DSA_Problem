package LinkedList.Hard;

 class ListNode {
    int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {
      int len=1;
        ListNode tail=head;
    while (tail.next!=null){
     len++;
     tail=tail.next;
    }
      if (k%len==0) return head;
      if (len<k){
      k=k%len;}
    tail=tail.next;
    ListNode lastNode=findKthNode(head,len-k);
    head=lastNode.next;
    lastNode.next=null;
    return head;



}

    private ListNode findKthNode(ListNode head, int i) {
    i-=1;

        while (head!=null){
            i--;
            head=head.next;

        }
       return head;
    }
}
