package LinkedList.Medium;
 class ListNode {
     int val;
     ListNode next;
      ListNode() {}
   ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Reverse_Nodes_in_k_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevNode=null;
        while (temp!=null){
            ListNode kthnode=kthnode(temp,k);
            if (kthnode==null){
                if (prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }

            ListNode nextNode=kthnode.next;
            kthnode.next=null;
            reverse(temp);
            if (temp==head) head=kthnode;
            else {
                prevNode.next=kthnode;
            }
            prevNode=temp;
            temp=nextNode;

        }


        return head;
    }

    private ListNode kthnode(ListNode temp, int k) {
        k-=1;
        while (temp!=null&&k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }

    private ListNode reverse(ListNode temp) {
        if (temp==null||temp.next==null) return temp;
        ListNode newnode=reverse(temp.next);
        ListNode front =temp.next;
        front.next=temp;
        temp.next=null;

        return newnode;
    }
}
