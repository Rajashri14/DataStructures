package Tree.IterativeTreeTraversals;

import java.util.*;

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

public class LevelOrderTraversalOfTree {
    public static void main(String[] args) {
        System.out.println("Print tree level wise.");
        List<List<Integer>> ansList = new ArrayList<>();

        Node root = createTree();
        levelWiseTraversal(root,ansList);

        System.out.println(ansList);
    }

    public static Node createTree(){

        Queue<Node> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter root data: ");
        int val = sc.nextInt();
        Node root = new Node(val);
        q.add(root);

        while(!q.isEmpty()){

            // Removing the node from the front of the queue for which we have to create left and right node
            Node temp = q.remove();

            // Ask for left data
            System.out.println("Enter left data of "+temp.data);
            int left_data = sc.nextInt();

            // if left_data == -1 i.e no node present there. We don't have to do anything
            if(left_data != -1){
                Node left = new Node(left_data);
                temp.left = left;
                q.add(left);
            }

            // Ask for right data
            System.out.println("Enter right data of : "+temp.data);
            int right_data = sc.nextInt();

            // if right_data == -1 i.e no node present there. We don't have to do anything
            if(right_data != -1){

                Node right = new Node(right_data);
                temp.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void levelWiseTraversal(Node root , List<List<Integer>> ansList){
        Queue<Node> q = new LinkedList<>();

        // add root element into the queue
        q.add(root);

        while(!q.isEmpty()){

            int n = q.size();
            List<Integer> list = new ArrayList<>();

            // looping over the current level
            for(int i = 0 ; i < n ; i++){

                // remove front ele of the queue
                Node temp = q.remove();

                // adding ele into list
                if(temp != null){
                    list.add(temp.data);
                }

                // add left child into the queue
                if(temp != null && temp.left != null){
                    q.add(temp.left);
                }

                // add right chile into the queue
                if(temp != null && temp.right != null){
                    q.add(temp.right);
                }
            }
           ansList.add(list);
        }
    }
}
