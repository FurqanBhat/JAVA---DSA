package DSA;
public class DoubleLinkedList {
    Node head;
    Node tail;
    int size;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    DoubleLinkedList(){
        this.size=0;
    }
    public boolean isEmpty(){
        return head==null && tail==null;
    }
    public void addFirst(int x){
        Node newNode=new Node(x);
        size++;
        if(isEmpty()){
            head=newNode;
            tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void addLast(int x){
        Node newNode=new Node(x);
        size++;
        if(isEmpty()){
            head=newNode;
            tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    public int removeFirst(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Empty list");
        }
        size--;
        int removed=head.data;
        if(head==tail){
            head=tail=null;
        }else{
            head=head.next;
            head.prev=null;
        }
        return removed;  
    }
    public int removeLast(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Empty list");
        }
        size--;
        int removed=tail.data;
        if(head==tail){
            head=tail=null;
        }else{
            tail=tail.prev;
            tail.next=null;
        }
        return removed;

    }
    public int get(int idx){
        if(idx<0 || idx>=size){
            throw new IndexOutOfBoundsException(idx);
        }
        Node currNode=head;
        for(int i=0; i<idx; i++){
            currNode=currNode.next;
        }
        return currNode.data;

    }

    
}

class TestDoubleLinkedList{
    public static void main(String[] args){
        DoubleLinkedList list=new DoubleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(0);
        while(!list.isEmpty()){
            System.out.println(list.removeFirst());
        }
        
    }
}
