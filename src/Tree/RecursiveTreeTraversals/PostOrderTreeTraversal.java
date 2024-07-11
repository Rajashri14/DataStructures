package Tree.RecursiveTreeTraversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class NodeP{
    int data;
    NodeP left;
    NodeP right;

    public NodeP(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class PostOrderTreeTraversal {
    public static void main(String[] args) {
        System.out.println("Recursive Post Order Tree Traversal.");
        NodeP root = createTree();
        postOrderTraversal(root);
    }

    public static NodeP createTree(){

        Queue<NodeP> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter root data: ");
        int val = sc.nextInt();
        NodeP root = new NodeP(val);
        q.add(root);

        while(!q.isEmpty()){

            NodeP temp = q.remove();

            // Ask for left data
            System.out.println("Enter left data of "+temp.data);
            int left_data = sc.nextInt();

            if(left_data != -1){

                NodeP left = new NodeP(left_data);
                temp.left = left;
                q.add(left);
            }

            // Ask for right data
            System.out.println("Enter right data of : "+temp.data);
            int right_data = sc.nextInt();

            if(right_data != -1){

                NodeP right = new NodeP(right_data);
                temp.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void postOrderTraversal(NodeP root){

        // if root is null there is no data to print
        if(root == null){
            return;
        }

        // first print the left data
        postOrderTraversal(root.left);

        // print right data
        postOrderTraversal(root.right);

        // print the root data
        System.out.print(root.data+" ");
    }
}
