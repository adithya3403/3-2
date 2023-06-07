// d. Write a JAVA Program to implement a segment tree with its operations
// In Hyderabad after a long pandemic gap, the Telangana Youth festival Is Organized at HITEX.
// In HITEX, there are a lot of programs planned. During the festival in order to maintain the rules
// of Pandemic, they put a constraint that one person can only attend any one of the programs in
// one day according to planned days. Now it"s your aim to implement the "SegmentTree" class in such
// a way that you need to return the maximum number of programs you can attend according to
// given constraints.

// Explanation:
// You have a list of programs "p" and days "d", where you can attend only one program on one day.
// Programs [p] = [first day, last day], p is the program's first day and the last day.

// Input Format:
// Line-1: An integer N, number of programs.
// Line-2: N comma separated pairs, each pair(f_day, l_day) is separated by space.
// Output Format:
// An integer, the maximum number of programs you can attend.

// Sample Input-1:
// 4
// 1 2,2 4,2 3,2 2
// Sample Output-1:
// 4

// Sample Input-2:
// 6
// 1 5,2 3,2 4,2 2,3 4,3 5
// Sample Output-2:
// 5


import java.util.*;

class SegmentTree {
    int[] tree;

    SegmentTree(int[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i][1]);
        tree = new int[max + 1];
        for (int i = 0; i < arr.length; i++)
            update(arr[i][0], arr[i][1]);
    }

    void update(int start, int end) {
        for (int i = start; i <= end; i++)
            tree[i] = 1;
    }

    int query(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++)
            if (tree[i] == 1)
                count++;
        return count;
    }
}


public class p1d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(maxPrograms(arr));
        sc.close();
    }

    static int maxPrograms(int[][] arr) {
        SegmentTree tree = new SegmentTree(arr);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int query = tree.query(arr[i][0], arr[i][1]);
            max = Math.max(max, query);
        }
        return max;
    }
}
