package LinkedList.Easy;

public class Palindrome_Linked_List {
    public static ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;

        }
        ListNode newHead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;

        return newHead;
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode secondHead=reverseList(slow.next);
        ListNode tempFirst=head;
        ListNode tempSecond=secondHead;
        while (tempSecond!=null){
            if (tempFirst.val!=tempSecond.val){
                reverseList(secondHead);
                return false;
            }
            tempFirst=tempFirst.next;
            tempSecond=tempSecond.next;
        }
        reverseList(secondHead);
        return true;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        node1.next=node2;
        ListNode node3=new ListNode(3);
        node2.next=node3;
        ListNode node4=new ListNode(3);
        node3.next=node4;
        ListNode node5=new ListNode(2);
        node4.next=node5;
        ListNode node6=new ListNode(1);
        node5.next=node6;
        node6.next=null;
        System.out.println(isPalindrome(node1));
    }

}
