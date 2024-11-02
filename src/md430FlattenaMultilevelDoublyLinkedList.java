public class md430FlattenaMultilevelDoublyLinkedList {

    // Return the head of the Node
    public Node flatten(Node head) {
        while (head.next != null || head.child != null){
            if(head.child != null){
                Node next = head.next;
                Node fc = flatten(head.child);
                Node fcTail = fc;
                while(fcTail.next != null){
                    fcTail = fcTail.next;
                }
                head.next = fc;
                fc.prev = head;
                fcTail.next = next;
                next.prev = fcTail;
                head.child = null;
            }else{
                head = head.next;
            }
        }
        while(head.prev != null){
            head = head.prev;
        }
        return head;
    }
}


class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};