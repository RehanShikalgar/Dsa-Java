package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;
    }
}

class Pair{
    Node node;
    int level;
    Pair(Node node, int level){
        this.node = node;
        this.level = level;
    }
}
public class binaryTree01 {

    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(80);
        Node c = new Node(12);
        Node d = new Node(1);
        Node e = new Node(19);
        Node f = new Node(21);
        Node g = new Node(11);
        Node h = new Node(89);
        Node i = new Node(123);
        Node j = new Node(100);
        a.left=b; a.right=c;
        b.left=d; b.right = e;
        c.left=f; c.right=g;
        e.right=h;
        h.left=i; h.right=j;
        //       10
        //    /      \
        //   80       12
        //  /   \    /    \
        // 1    19  21     11
        //        \
        //        89
        //       /  \
        //     123  100
        display(a);
        System.out.println();
        System.out.println("Size: "+size(a));
        System.out.println("Sum: "+sum(a));
        System.out.println("Max: "+max(a));
        System.out.println(("Levels: "+levels(a)));
        System.out.println("PreOrder: "); preOrder(a);
        System.out.println();
        System.out.println("PostOrder: "); postOrder(a);
        System.out.println();
        System.out.println("InOrder: "); inorder(a);
        System.out.println();
        System.out.println("LevelOrders: ");
        levelOrders(a);
        System.out.println("Level Order Steps: ");
        levelOrdersSteps(a);
        System.out.println("kTHOrder: ");
        kThOrder(a,0,2);
    }

    private static int sum(Node root) {
        return (root==null)? 0: root.val+sum(root.left)+sum(root.right);
    }

    private static int max(Node root){
        return (root==null)?Integer.MIN_VALUE: Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    private static int size(Node root) {
        return (root==null)? 0: 1+size(root.left)+size(root.right);
    }

    public static void display(Node root){
        if(root==null) return;
        System.out.print(root.val+" ");
        display(root.left); display(root.right);
    }

    public static int levels(Node root){
        return (root==null)?0: 1+Math.max(levels(root.left), levels(root.right));
    }

    public static void levelOrders(Node root){ //BFS->Breadth First Search
        // we print continuously here.. in one line
        Queue<Node> q = new LinkedBlockingDeque<>();
        q.add(root);
        while(q.size()>0){
            Node front = q.remove();
            System.out.print(front.val+" ");
            if(front.left != null) q.add(front.left);
            if(front.right != null) q.add(front.right);
        }
        System.out.println();
    }

    public static void levelOrdersSteps(Node root){ //BFS
        // we print wrt levels here..
        if(root==null) return;
        Queue<Pair> q = new LinkedList<>();
        int currLevel =0;
        q.add(new Pair(root, 0));


        while(q.size()>0){
            Pair front=q.remove();
            if(front.level!=currLevel){
                currLevel++;
                System.out.println();
            }
            if(front.node.left!=null) q.add(new Pair(front.node.left, front.level+1));
            if(front.node.right!=null) q.add(new Pair(front.node.right, front.level+1));

            System.out.print(front.node.val+" ");
        }
        System.out.println();
    }

    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void preOrder(Node root){
        if(root ==null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static void kThOrder(Node root, int level, int k){ //k is the level we want to print
        if(root==null) return;
        if(level==k) System.out.print(root.val+" ");
        kThOrder(root.right, level+1,k);
        kThOrder(root.left, level+1, k);
    }

}
