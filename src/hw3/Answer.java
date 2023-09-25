package hw3;

public class Answer {
    Node head;
    public void reverse() {
        Node tempNode = null;
        Node originNode = head;
        if(head != null && originNode.next != null){
            while(originNode.next != null){
                Node next = originNode.next;
                originNode.next = tempNode;
                tempNode = originNode;
                originNode = next;
            }
            originNode.next = tempNode;
            head = originNode;
        }
    }
}
