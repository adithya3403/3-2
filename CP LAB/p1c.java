// c. Write a JAVA Program to implement Fenwick Tree
// Malika taught a new fun time program practice for Engineering Students.
// As a part of this she has given set of numbers,
// and asked the students to find the gross value of numbers between
// indices S1 and S2(S1<=S2),inclusive. Now it's your task to
// create a method sumRange(S1,S2) which return the sum of numbers
// between the indices S1 and S2, both are inclusive.

// Input Format:
// Line-1: An integer n, size of the array(set of numbers).
// Line-2: n space separated integers.
// Line-3: Two integers s1 and s2, index positions where s1<=s2.
// Output Format:
// An integer, sum of integers between indices(s1,s2).

// Sample Input-1:
// 8
// 1 2 13 4 25 16 17 8
// 2 6
// Sample Output-1:
// 75

// Constraints:
// 1<=nums.length<=3*104
// -100<=nums[i]<=100
// 0<=index<nums.length
// -100<=val<=100
// 0<=left<=right<nums.length
// At most 3*10^4 calls will be made to update and sumRange


import java.util.*;

class FenwickTree {
    int n, nums[];
    static int BIT[];

    FenwickTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        BIT = new int[n + 1];
        for (int i = 0; i < n; i++)
            init(i, nums[i]);
    }

    void init(int i, int val) {
        for (i++; i <= n; i += i & -i)
            BIT[i] += val;
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    static int getSum(int i) {
        int sum = 0;
        for (i++; i > 0; i -= i & -i)
            sum += BIT[i];
        return sum;
    }

    int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}


public class p1c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        FenwickTree ft = new FenwickTree(nums);
        int s1 = sc.nextInt(), s2 = sc.nextInt();
        System.out.println(ft.sumRange(s1, s2));
        sc.close();
    }
}
