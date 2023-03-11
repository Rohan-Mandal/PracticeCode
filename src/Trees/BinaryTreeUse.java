package Trees;

import java.util.Scanner;

public class BinaryTreeUse {

    public static BinaryTree<Integer> takeUserInputBetter(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot){
            System.out.println("Enter Root Data");
        }
        else {
            if(isLeft){
                System.out.println("Enter leftChild of " + parentData);
            }else {
                System.out.println("Enter rightChild of "+ parentData);
            }
        }
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if(rootData == -1){
            return null;
        }
        BinaryTree<Integer> root = new BinaryTree<>(rootData);
        BinaryTree<Integer> leftChild = takeUserInputBetter(false, rootData, true);
        BinaryTree<Integer> rightChild = takeUserInputBetter(false, rootData, false);

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static BinaryTree<Integer> takeUserInput(){
        System.out.println("Enter root data");
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if(rootData == -1){
            return null;
        }
        BinaryTree<Integer> root = new BinaryTree<>(rootData);
        BinaryTree<Integer> leftChild = takeUserInput();
        BinaryTree<Integer> rightChild = takeUserInput();

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void printTree(BinaryTree<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.data + ":");
        if(root.left != null){
            System.out.print("L" + root.left.data + " , ");
        }
        if(root.right != null){
            System.out.print("R" + root.right.data);
        }
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }

    public static int numberOfNodes(BinaryTree<Integer> root){
        if(root == null){
            return 0;
        }
        int leftCount = numberOfNodes(root.left);
        int rightCount = numberOfNodes(root.right);
        return 1 + leftCount + rightCount;
    }

    public static void main(String[] args) {
//        BinaryTree<Integer> root = new BinaryTree<>(1);
//        BinaryTree<Integer> left = new BinaryTree<>(2);
//        BinaryTree<Integer> right = new BinaryTree<>(3);
//
//        root.left = left;
//        root.right = right;
//        BinaryTree<Integer> twoRight = new BinaryTree<>(5);
//        BinaryTree<Integer> threeLeft = new BinaryTree<>(4);
//        left.right = twoRight;
//        right.left = threeLeft;
        BinaryTree<Integer> root = takeUserInputBetter(true, 0, true);

        printTree(root);
        System.out.println("Number of nodes are: " + numberOfNodes(root));
    }
}
