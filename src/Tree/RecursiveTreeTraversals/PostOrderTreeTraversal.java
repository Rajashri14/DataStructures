package RecursiveTreeTraversals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PostOrderTreeTraversal {
    public static void main(String[] args) {
        System.out.println("Recursive Post Order Tree Traversal.");
        Node1 root = createTree();
        postOrderTraversal(root);
    }

    public static Node1 createTree(){

        Queue<Node1> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter root data: ");
        int val = sc.nextInt();
        Node1 root = new Node1(val);
        q.add(root);

        while(!q.isEmpty()){

            Node1 temp = q.remove();

            // Ask for left data
            System.out.println("Enter left data of "+temp.data);
            int left_data = sc.nextInt();

            if(left_data != -1){

                Node1 left = new Node1(left_data);
                temp.left = left;
                q.add(left);
            }

            // Ask for right data
            System.out.println("Enter right data of : "+temp.data);
            int right_data = sc.nextInt();

            if(right_data != -1){

                Node1 right = new Node1(right_data);
                temp.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void postOrderTraversal(Node1 root){

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
