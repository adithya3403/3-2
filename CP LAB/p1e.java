
/*

e) Write a JAVA Program to implement TREAP with its operations
Given an integer array nums, return the number of reverse pairs in the array.
A reverse pair is a pair (i,j) where 0<=i<j<nums.length and nums[i]>2*nums[j].

Example 1:
Input: nums=[1,3,2,3,1]
Output: 2

Example 2:
Input: nums=[2,4,3,5,1]
Output:3

Constraints:
1<=nums.length<=5*104
-2^31<=nums[i]<=2^31–1

*/

import java.util.*;

class Pair<U, V> {
    U left;
    V right;

    Pair(U _left, V _right) {
        left = _left;
        right = _right;
    }
}

class Item {
    Double key;
    Double priority;
    long cnt;
    Item left, right;

    Item() {
        left = right = null;
        key = null;
        priority = null;
        cnt = 1L;
    }
}

class Solution {
    long cnt(Item item) {
        if (item == null)
            return 0;
        return item.cnt;
    }

    void updateCnt(Item item) {
        if (item != null)
            item.cnt = 1 + cnt(item.left) + cnt(item.right);
    }

    Item[] split(Item item, double key) {
        Item[] ret = null;
        if (item == null) {
            ret = new Item[] {null, null};
        } else if (item.key < key) {
            ret = split(item.right, key);
            item.right = ret[0];
            ret = new Item[] {item, ret[1]};
        } else {
            ret = split(item.left, key);
            item.left = ret[1];
            ret = new Item[] {ret[0], item};
        }
        updateCnt(item);
        return ret;
    }

    Item merge(Item l, Item r) {
        Item ret = null;
        if (l == null || r == null)
            ret = (l != null) ? l : r;
        else if (l.priority > r.priority) {
            l.right = merge(l.right, r);
            ret = l;
        } else {
            r.left = merge(l, r.left);
            ret = r;
        }
        updateCnt(ret);
        return ret;
    }

    Item insert(Item root, Item item) {
        Item ret = null;
        if (root == null) {
            ret = item;
        } else if (root.priority < item.priority) {
            Item[] res = split(root, item.key);
            item.left = res[0];
            item.right = res[1];
            ret = item;
        } else {
            if (root.key > item.key) {
                ret = insert(root.left, item);
                root.left = ret;
                ret = root;
            } else {
                ret = insert(root.right, item);
                root.right = ret;
                ret = root;
            }
        }
        updateCnt(ret);
        return ret;
    }

    Pair<Item, Long> searchNoGreaterThan(Item root, double key) {
        Item[] res = split(root, key);
        long ret = cnt(res[0]);
        return new Pair<>(merge(res[0], res[1]), ret);
    }

    void printTreap(Item root) {
        System.out.println("total num: " + cnt(root));
        if (root == null)
            return;
        Queue<Item> q = new LinkedList<>();
        q.add(root);
        int blank = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Item node = q.poll();
                System.out.print("<" + node.key + "," + node.priority + ">");
                for (int j = 0; j < blank; j++) {
                    System.out.print(" ");
                }
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            System.out.println();
            blank <<= 1;
        }
        System.out.println("------------------");
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int LEN = nums.length;
        Random rand = new Random();
        Item root = new Item();
        root.priority = rand.nextDouble();
        root.key = nums[LEN - 1] + 0.0;
        int ans = 0;
        for (int i = LEN - 2; i >= 0; i--) {
            Pair<Item, Long> ret = searchNoGreaterThan(root, (nums[i] + 0.0) / 2);
            ans += ret.right;
            root = ret.left;
            Item e = new Item();
            e.priority = rand.nextDouble();
            e.key = nums[i] + 0.0;
            root = insert(root, e);
        }
        return ans;
    }
}

public class p1e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.reversePairs(arr));
        sc.close();
    }
}
