package RecursiveTreeTraversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class NodeT{
    int data;
    NodeT left;
    NodeT right;

    public NodeT(int data){
        data = this.data;
        left = null;
        right = null;
    }
}
public class PreOrderTreeTraversal {
    public static void main(String[] args) {
        System.out.println("Recursive preorder traversal of the tree.");

        NodeT root = createTree();
        preOrderTraversal(root);
    }

    public static NodeT createTree(){

        Queue<NodeT> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter root data: ");
        int val = sc.nextInt();
        NodeT root = new NodeT(val);
        q.add(root);

        while(!q.isEmpty()){

            NodeT temp = q.remove();

            // Ask for left data
            System.out.println("Enter left data of "+temp.data);
            int left_data = sc.nextInt();

            if(left_data != -1){

                NodeT left = new NodeT(left_data);
                temp.left = left;
                q.add(left);
            }

            // Ask for right data
            System.out.println("Enter right data of : "+temp.data);
            int right_data = sc.nextInt();

            if(right_data != -1){

                NodeT right = new NodeT(right_data);
                temp.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void preOrderTraversal(NodeT root){

        // if root is null there is no data to print
        if(root == null){
            return;
        }

        // first print the root data
        System.out.print(root.data+" ");

        // print the left data
        preOrderTraversal(root.left);

        // print right data
        preOrderTraversal(root.right);
    }
}