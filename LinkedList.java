public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node (int data ){
            this.data = data;
            this.next = null;

        }
    }
    public static Node  head ;
    public static Node tail;
    public static  void addfirst (int data) {//step1 = create new node 
     Node newNode = new Node (data);
     //step2  -newNode  next = head 
     if (head == null){
        head = tail = newNode;
        return;
     }
     newNode.next = head;
     //step3 - head = newNode 
     head = newNode;

    }
public static void main (String args[]){
     LinkedList ll = new LinkedList();
  ll.addfirst(4);
  ll.addfirst(3);
}

    
}
