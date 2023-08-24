package DSA;
public class BST {
    Node root;
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public Node insert(int data){
        return root=insertHelper(root, data);
    }
    public Node insertHelper(Node root, int data){
        if(root==null){
            return new Node(data);
        }

        if(data<root.data){
            root.left=insertHelper(root.left, data);
        }else{
            root.right=insertHelper(root.right, data);
        }
        return root;

    }
    public void inOrderTraversal(){
        inOrderTraversalHelper(root);
    }
    public void inOrderTraversalHelper(Node root){
        if(root==null){
            return;
        }
        inOrderTraversalHelper(root.left);
        System.out.print(root.data+" ");
        inOrderTraversalHelper(root.right);
    }
    public boolean contains(int data){
        return containsHelper(data, root);
        
    }
    public boolean containsHelper(int data, Node curr){
        if(curr==null){
            return false;
        }
        if(data==curr.data){
            return true;
        }
        if(data<curr.data){
            return containsHelper(data, curr.left);
        }
        return containsHelper(data, curr.right);
    }
    public Node delete(int data){
        return deleteHelper(data, root);
    }
    public Node deleteHelper(int data, Node curr){
        if(curr==null){
            return null;
        }
        if(data==curr.data){
            //case 1
            if(curr.left==null && curr.right==null){
                return null;
            }
            //case 2
            if(curr.left==null){
                return curr.right;
            }
            if(curr.right==null){
                return curr.left;
            }
            //case 3
            Node inOrderSuccessor=inOrderSuccessor(curr.right);
            curr.data=inOrderSuccessor.data;
            curr.right=deleteHelper(inOrderSuccessor.data, curr.right);
            return curr;

        }
        if(data<curr.data){
            curr.left=deleteHelper(data, curr.left);
        }else{
            curr.right=deleteHelper(data,curr.right);
        }
        return curr;

    }
    public Node inOrderSuccessor(Node curr){
        //here we don't need this case(curr==null) because in above, root.right
        // can't be null because then, it'd be case 2
        if(curr==null){
            return curr;
        }
        while(curr.left!=null){
            curr=curr.left;
        }
        return curr;
        
    }


}


