package Tree.CreationOfTree;
import java.util.Scanner;

/*
   1) if val == -1 return null;
   2) Create Node
   3) Create left side of the node first
   4) then Create right side of the node
   5) At last return the address of the node

 */

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class CreationOfTreeUsingDFS{
    public static void main(String[] args) {
        System.out.println("Depth wise creation of tree.......");

        Node root = createTree();

        System.out.println("Inorder traversal of tree :");
        inOrderTraversal(root);

    }

    public static Node createTree(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter data :");
        int val = sc.nextInt();

        if(val == -1){
            return null;
        }

        Node new_node = new Node(val);

        System.out.println("Enter left data:");
        new_node.left = createTree();

        System.out.println("Enter right data :");
        new_node.right = createTree();

        return new_node;
    }

    public static void inOrderTraversal(Node root){

        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }
}
