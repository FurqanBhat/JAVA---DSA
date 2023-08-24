package DSA;
public class Stack {
    Node head=null;
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;   
        }
    }
        public boolean isEmpty(){
            return head==null;
        }
        public void push(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        public void pushBottom(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=newNode;
                return;
            }
            Node currNode=head;
            while(currNode.next!=null){
                currNode=currNode.next;
            }
            currNode.next=newNode;
        }
        
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }
    }

class testty{
    public static void reverse(java.util.Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top=stack.pop();
        reverse(stack);
        btm(stack,top);



    }
    public static void main(String[] args){
        java.util.Stack<Integer> s=new java.util.Stack<>();
        s.push(3);
        s.push(4);
        s.push(5);
        btm(s,2);
        btm(s,1);
        

        // s.pushBottom(2);
        // s.pushBottom(1);
        s.push(6);
        reverse(s);
        for(int i=0; i<6; i++){
            System.out.println(s.pop());
        }
        
      
    }
    public static void btm(java.util.Stack<Integer> stack, int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int curr=stack.pop();
        btm(stack, data);
        stack.push(curr);
    }
}