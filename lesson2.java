

/**
 * lesson2
 */

class List{
    static Node head;

    static class Node{
        int value;
        Node next;
    }
    public void pushFront(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }
    
    public void print(){
        Node node = head;
        while(node != null){
            System.out.printf("%d ", node.value);
            node = node.next;
        }
        System.out.println();
    }
    public Node reverse(){
        Node curr = head;
        Node prev = null;
        Node temp;

        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        head = prev;
        return head;
    }
}


public class lesson2 {

   public static void main(String[] args) {
    List list = new List();
    for(int i = 1; i<=5;i++){
        list.pushFront(i);
    }
    list.print();
    list.reverse();
    list.print();
    
   }
}