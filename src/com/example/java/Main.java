package com.example.java;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
            This program is a solution to the HackerRank problem for Tree Top View.

            You are given a pointer to the root of a binary tree. Print the top view
            of the binary tree. Top view means when you look the tree from the top the
            nodes you will see what will be called the top view of the tree.

            Example:
               1
                \
                 2
                  \
                   5
                  /  \
                 3    6
                  \
                   4

                   Top View : 1 -> 2 -> 5 -> 6

         */
/*
        input:
        6
        1 2 5 3 6 4
                output : 1 2 5 6
*/


        //Define variables for input from console
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        Node root = null;

        //t is defined as the number of nodes to be expected.
        while (t-- > 0){

            //get node value from console and invoke the insert method to create node and chain
            int data = input.nextInt();
            root = insert(root, data);

        }

        //invoke the topView method to get the results of only top view node values only.
        topView(root);

    }

    //The insert method will check the data and compare to root.data to see which direction to branch/traverse
    //and recursively call the insert method to create a new node when root is null, and assign to node current
    // and then assign the traversal direction of the root to the node current.
    public static Node insert(Node root, int data){

        if (root == null){
            return new Node(data);
        }else{
            Node curr;

            if (data < root.data){
                curr = insert(root.left,data);
                root.left = curr;

            }else {
                curr = insert(root.right,data);
                root.right = curr;

            }
            return root;
        }

    }

    /*
        The topView method will invoke first the topViewLeft method to traverse through the tree on the
        left side only. then the topView method will invoke the topViewRight method which will traverse
        only the right side of the tree.
     */
    public static void topView(Node root){

        topViewLeft(root.left);
        System.out.print(root.data + " ");
        topViewRight(root.right);

    }

    //Recursively invoke topViewLeft method and traverse on the left side
    // of tree only and print the node data
    public static void topViewLeft(Node root){
        if (root == null){
            return;
        }else {
            topViewLeft(root.left);
            System.out.print(root.data + " ");
        }
    }

    //Recursively invoke topViewRight method and traverse on the right side
    // of the tree only and print the node data
    public static void topViewRight(Node root){
        if (root == null){
            return;
        }else {
            System.out.print(root.data + " ");
            topViewRight(root.right);
        }

    }

}
