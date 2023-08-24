package DSA;
public class Queue {
    int[] list;
    int rear=-1;
    int front=-1;
    public Queue(int size){
        list=new int[size];
    }
    public boolean isFull(){
        return rear==list.length-1;
    }
    public boolean isEmpty(){
        return rear==-1;
    }
    public void add(int n){
        if(isFull()){
            return;
        }
        front=0;
        rear++;
        list[rear]=n;
    }
    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int front=list[0];
        for(int i=0; i<rear; i++){
            list[i]=list[i+1];
        }
        rear--;
        return front;
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return list[front];
    }
    
}

class ListQueue{
    Node head;
    Node tail;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public boolean isEmpty(){
        return head==null && tail==null;
    }
    public void add(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public int remove(){
        if(isEmpty()){
            return -1;
        }
        if(head==tail){
            tail=null;
        }
        int front=head.data;
        head=head.next;
        return front;
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }





}
class Test{
    public static void main(String[] args){
        ListQueue q=new ListQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(1);
        q.remove();
        
        while(!q.isEmpty()){
            System.out.println(q.remove());
    
        }
    }
}
class CircularQueue{
    int[] list;
    int front=-1;
    int rear=-1;
    int size=0;
    CircularQueue(int size){
        this.size=size;
        list=new int[size];
    }
    public boolean isFull(){
        return (rear+1)%size==front;
    }
    public boolean isEmpty(){
        return (front==-1 && rear==-1);
    }
    public void add(int data){
        if(isFull()){
            return;
        }
        if(front==-1){
            front++;
        }
        rear=(rear+1)%size;
        list[rear]=data;
    }
    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int temp=list[front];
        if(front==rear){
            front=rear=-1;
            return temp;
        }
        front=(front+1)%size;
        return temp;
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return list[front];
    }
}
