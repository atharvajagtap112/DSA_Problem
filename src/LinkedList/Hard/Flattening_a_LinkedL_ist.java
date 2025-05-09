package LinkedList.Hard;

//class Node{
//    int data;
//    Node next;
//    Node bottom;
//
//    public Node(int data) {
//        this.data = data;
//        this.next=null;
//        this.bottom=null;
//    }
//}
//public class Flattening_a_LinkedL_ist {
//    Node flatten(Node root) {
//      return flatternLinkedList(root);
//
//    }
//
//    private Node flatternLinkedList(Node head) {
//     if (head==null||head.next==null){
//         return head;
//     }
//        Node mergHead=flatternLinkedList(head.next);
//      return merge(head,mergHead);
//
//    }
//    Node merge(Node head1,Node head2){
//        Node dummyHead=new Node(-1);
//        Node res=dummyHead;
//        while (head1!=null&&head2!=null){
//            if (head1.data< head2.data){
//                res.bottom=head1;
//
//                head1=head1.bottom;
//            }
//            else {
//                res.bottom=head2;
//               head2= head2.bottom;
//            }
//            res=res.bottom;
//            res.next=null;
//        }
//
//        if (head1!=null){
//            res.bottom=head1;
//        }
//        else res.bottom=head2;
//        return dummyHead.bottom;
//    }
//}
