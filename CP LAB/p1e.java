// e. Write a JAVA Program to implement TREAP with its operations
// Given an integer array nums, return the number of reverse pairs in the array.
// A reverse pair is a pair (i,j) where 0<=i<j<nums.length and nums[i]>2*nums[j].

// Example 1:
// Input: nums=[1,3,2,3,1]
// Output: 2

// Example 2:
// Input: nums=[2,4,3,5,1]
// Output:3

// Constraints:
// 1<=nums.length<=5*104
// -2^31<=nums[i]<=2^31–1

import java.util.*;

public class p1e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findNoOfRevPairs(arr));
        sc.close();
    }

    static int findNoOfRevPairs(int[] arr) {
        Treap treap = new Treap();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += treap.query(arr[i] * 2 + 1, Integer.MAX_VALUE);
            treap.insert(arr[i]);
        }
        return count;
    }
}


class Node {
    int key, priority;
    Node left, right;

    Node(int key) {
        this.key = key;
        priority = new Random().nextInt();
    }
}


class Treap {
    Node root = null;

    void insert(int key) {
        root = insert(root, key);
    }

    Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (key < root.key) {
            root.left = insert(root.left, key);
            if (root.left.priority > root.priority)
                root = rightRotate(root);
        } else {
            root.right = insert(root.right, key);
            if (root.right.priority > root.priority)
                root = leftRotate(root);
        }
        return root;
    }

    private Node rightRotate(Node root2) {
        Node left = root2.left;
        Node right = left.right;
        left.right = root2;
        root2.left = right;
        return left;
    }

    Node leftRotate(Node root2) {
        Node right = root2.right;
        Node left = right.left;
        right.left = root2;
        root2.right = left;
        return right;
    }

    int query(int start, int end) {
        return query(root, start, end);
    }

    int query(Node root, int start, int end) {
        if (root == null)
            return 0;
        if (root.key >= start && root.key <= end)
            return 1 + query(root.left, start, end) + query(root.right, start, end);
        else if (root.key < start)
            return query(root.right, start, end);
        else
            return query(root.left, start, end);
    }
}
