package LinkedList.Easy;

public class Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle=findMid(head);
        ListNode leftHead=head;
        ListNode rightHead=middle.next;
        leftHead=sortList(leftHead);
        rightHead=sortList(rightHead);
        return merge(leftHead,rightHead);
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode dummyNode=new ListNode(-1);
        ListNode temp=dummyNode;
        while (leftHead!=null&&rightHead!=null){
            if (leftHead.val<= rightHead.val){
                temp.next=leftHead;
                leftHead=leftHead.next;
            }
            else {
                temp.next=rightHead;
                rightHead=rightHead.next;
            }
            temp=temp.next;
        }
        while (leftHead!=null){
            temp.next=leftHead;
        }
        while (rightHead!=null){
            temp.next=rightHead;
        }
        return dummyNode.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
