package LinkedList.Hard;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        Node temp=head;
        while (temp!=null){
            Node node=new Node(temp.val);
            Node next=temp.next;
            temp.next=node;
            node.next=next;
            temp=temp.next.next;
        }
        temp=head;
        while (temp!=null){
            Node clone=temp.next;
            if(temp.random!=null)clone.random=temp.random.next;
            else clone.random=null;
            temp=temp.next.next;
        }
        Node dummyNode=new Node(-1);
        Node res=dummyNode;
        temp=head;
        while (temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            temp=temp.next.next;
            res=res.next;
        }
        return dummyNode.next;
    }
}
