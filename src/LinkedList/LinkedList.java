package LinkedList;


//    class Node{
//        int value;
//        Node nextNode;
//
//        public Node(int value) {
//            this.value = value;
//            this.nextNode=null;
//        }
//
//        public Node(int value, Node nextNode) {
//            this.value = value;
//            this.nextNode = nextNode;
//        }
//    }
//     public class LinkedList {
//         static Node head;
//
//         private static Node insert(int[] arr) {
//             head = new Node(arr[0]);
//             Node move = head;
//             for (int i = 1; i < arr.length; i++) {
//                 Node temp = new Node(arr[i]);
//                 move.nextNode = temp;
//                 move = temp;
//             }
//             return head;
//         }
//
//         private static void Print(Node head) {
//             Node temp = head;
//             while (temp != null) {
//                 System.out.print(temp.value);
//                 temp = temp.nextNode;
//             }
//         }
//         private static Node  removeHead(Node head){
//             if (head.nextNode==null) return head;
//             head=head.nextNode;
//             return head;
//       }
//           private static Node removeTail(Node head){
//             if (head==null||head.nextNode==null) return null;
//             Node temp=head;
//             while (temp.nextNode.nextNode!=null){
//                 temp=temp.nextNode;
//             }
//             temp.nextNode=null;
//             return head;
//
//           }
//           public static Node removek(Node head,int k){
//             if (head==null) return head;
//             if (k==1){
//                 head=head.nextNode;
//
//             }
//             int cnt=0; Node temp=head; Node prevNode=null;
//             while (temp!=null){
//                 cnt++;
//                 if (k==cnt){
//                     prevNode.nextNode=prevNode.nextNode.nextNode;
//                       break;
//                 }
//                 prevNode=temp;
//                 temp=temp.nextNode;
//             }
//             return head;
//           }
//           static Node insertPsoitionK(Node head,int ele,int k){
//             if (head==null){
//                 if (k==1){
//                     return new Node(ele);
//                 }
//             }
//             if (k==1){
//                 Node temp=new Node(ele);
//                 temp.nextNode=head;
//                 return head;
//             }
//             int cnt=0; Node temp=head;
//             while (temp!=null){
//                 cnt++;
//                 if (cnt==k-1){
//                     Node x=new Node(ele,temp.nextNode);
//                     temp.nextNode=x;
//                     break;
//                 }
//                 temp=temp.nextNode;
//             }
// return head;
//           }
//         public static void main(String[] args) {
//             int[] arr = {2, 3, 7, 5, 8};
//            Node head=insert(arr);
//             //head =removeHead(head);
//             //head=removeTail(head);
//           //  head=removek(head,3);
//             head=insertPsoitionK(head,10,3);
//             Print(head);
//
//
//
//         }
//
//     }