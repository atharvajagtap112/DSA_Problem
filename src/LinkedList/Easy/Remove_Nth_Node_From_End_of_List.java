package LinkedList.Easy;

public class Remove_Nth_Node_From_End_of_List {
    public static ListNode removeNthFromEnd(ListNode head, int n){

        ListNode fastp = head;
        ListNode slowp = head;

        // Move the fastp pointer N nodes ahead
        for (int i = 0; i < n; i++)
            fastp = fastp.next;

        // If fastp becomes null, the Nth node from the end is the head
        if (fastp == null)
            return head.next;

        // Move both pointers until fastp reaches the end
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

        // Delete the Nth node from the end
        ListNode delNode = slowp.next;
        slowp.next = slowp.next.next;
        delNode = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
          node1.next=node2;
          node2.next=null;
        System.out.println(removeNthFromEnd(node1,1));
    }

}
