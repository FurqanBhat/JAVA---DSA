package DSA;
import java.util.LinkedList;
import java.util.Queue;
class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
public class BinaryTree {
    int counter=-1;
    public Node buildTree(int[] nodesData){
        counter++;
        if( counter>=nodesData.length || nodesData[counter]==-1){
            return null;
        }
        Node newNode=new Node(nodesData[counter]);
        newNode.left=buildTree(nodesData);
        newNode.right=buildTree(nodesData);
        return newNode;
    }
    public void preOrder(Node curr){
        if(curr==null){
            return;
        }
        System.out.print(curr.data+" ");
        preOrder(curr.left);
        preOrder(curr.right);
    }
    public void inOrder(Node curr){
        if(curr==null){
            return;
        }
        inOrder(curr.left);
        System.out.print(curr.data+" ");
        inOrder(curr.right);
    }
    public void postOrder(Node curr){
        if(curr==null){
            return;
        }
        postOrder(curr.left);
        postOrder(curr.right);
        System.out.print(curr.data+" ");

    }
    public void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                q.add(curr.left);
                }
                if(curr.right!=null){
                q.add(curr.right);
                }
            }
        }  
    }
    public int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        return root.data+sumOfNodes(root.left)+sumOfNodes(root.right);

    }
}
class TestBinaryTree{
    public static void main(String[] args){
        int list[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int array[]={1,2,5,6,7,-1,2,-1,-1,-1,-1,6,7,-1,-1,9,8,8,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(array);
        tree.levelOrder(root);
        System.out.println();
        System.out.println(tree.sumOfNodes(root));
    }
}
