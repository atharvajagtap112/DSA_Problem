package LinkedList.Easy;

public class Odd_Even_Linked_List {
    public static ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null) return head;
       int  cnt=1;
        ListNode crnt=head;
        ListNode cnect=head;
        ListNode evenIndices=head.next;
        while (crnt.next!=null){
            ListNode temp=crnt;
            if (cnt%2==1){
                cnect=crnt;
            }
            cnt++;
            crnt=crnt.next;
            temp.next=temp.next.next;
        }
        if (cnt%2==0) cnect.next=evenIndices;
        else  crnt.next=evenIndices;

        return head;

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.next = null;
        oddEvenList(node1);
    }

}
