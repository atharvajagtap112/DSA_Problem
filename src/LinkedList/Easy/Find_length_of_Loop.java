package LinkedList.Easy;
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
public class Find_length_of_Loop {
    public int countNodesinLoop(Node head) {
        int count=0;
        Node fast=head;
        Node slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                do {
                    slow=slow.next;
                    count++;
                }
                while (slow!=fast);
                return count;
            }
        }
        return 0;
    }
}
