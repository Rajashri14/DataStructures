package Tree.CreationOfTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node1{
    int data;
    Node1 left;
    Node1 right;

    public Node1(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class LevelWiseCreationOfTree {
    public static void main(String[] args) {
        System.out.println("Creation of tree using BFS:");

        Node1 root = createTree();
        inOrderTraversal(root);
    }

    public static Node1 createTree(){

        Queue<Node1> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter root data: ");
        int val = sc.nextInt();
        Node1 root = new Node1(val);
        q.add(root);

        while(!q.isEmpty()){

            // Removing the node from the front of the queue for which we have to create left and right node
            Node1 temp = q.remove();

            // Ask for left data
            System.out.println("Enter left data of "+temp.data);
            int left_data = sc.nextInt();

            // if left_data == -1 i.e no node present there. We don't have to do anything
            if(left_data != -1){
                Node1 left = new Node1(left_data);
                temp.left = left;
                q.add(left);
            }

            // Ask for right data
            System.out.println("Enter right data of : "+temp.data);
            int right_data = sc.nextInt();

            // if right_data == -1 i.e no node present there. We don't have to do anything
            if(right_data != -1){

                Node1 right = new Node1(right_data);
                temp.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void inOrderTraversal(Node1 root){

        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }
}
