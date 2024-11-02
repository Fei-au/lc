import java.util.ArrayList;
import node.random.Node;
public class md138CopyListwithRandomPointer {

    public static void main(String[] args) {
        md138CopyListwithRandomPointer ts = new md138CopyListwithRandomPointer();

//       [[7,null],[13,0],[11,4],[10,2],[1,0]]

//        Node n1 = new Node(7);
//        Node n2 = new Node(13);
//        Node n3 = new Node(11);
//        Node n4 = new Node(10);
//        Node n5 = new Node(1);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = null;
//        n1.random = null;
//        n2.random = n1;
//        n3.random = n5;
//        n4.random = n3;
//        n5.random = n1;
//
//        Node n = ts.copyRandomList(n1);


//        [[1,1],[2,1]]

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;
        Node n = ts.copyRandomList(n1);

        while(n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }


    public Node copyRandomList(Node head) {
//        if(head == null){
//            return null;
//        }
//        ArrayList<Node> ar1 = new ArrayList<Node>();
//        ArrayList<Node> ar2 = new ArrayList<Node>();
//        Node nHead = new Node(head.val);
//        Node n1 = head;
//        Node n2 = nHead;
//        Node n3 = nHead;
//        while(head.next != null){
//            nHead.next = new Node(head.next.val);
//            ar1.add(head);
//            ar2.add(nHead);
//            head = head.next;
//            nHead = nHead.next;
//        }
//        ar1.add(head);
//        ar2.add(nHead);
//
//        while(n1 != null){
//            if(n1.random == null){
//                n2.random = null;
//                n1 = n1.next;
//                n2 = n2.next;
//                continue;
//            }
//            for(int i = 0; i < ar1.size(); i ++ ){
//                if(ar1.get(i) == n1.random){
//                    n2.random = ar2.get(i);
//                    n1 = n1.next;
//                    n2 = n2.next;
//                    break;
//                }
//            }
//
//        }
//        return n3;

        if(head == null){
            return null;
        }
        Node h = head;
        Node h1 = head;
        while(head != null){
            Node next = head.next;
            Node temp = new Node(head.val);
            head.next = temp;
            temp.next = next;
            head = next;
        }
        while(h != null){
            h.next.random = h.random.next;
            h = h.next.next;
        }
        Node copiedHead = h1.next;
        while(copiedHead.next != null){
            copiedHead.next = copiedHead.next.next;
            copiedHead = copiedHead.next;
        }
        return h1.next;
    }
}

