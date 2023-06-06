// b. Write a JAVA Program to find shortest sub array with sum at least K
// Return the length of the shortest, non-empty, contiguous subarray of A with
// sum at least K. If there is no non-empty subarray with sum at least K,
// return -1.

// Example 1:
// Input:
// A=[1],K=1
// Output:1

// Example 2:
// Input:A=[1,2],K=4
// Output:-1

// Example 3:
// Input:A=[2,-1,2],K=3
// Output:3

// Note:
// 1<=A.length<=50000
// -10^5<=A[i]<=10^5
// 1<=K<=10^9

import java.util.*;

public class p1b {
    public static int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + (long) A[i];
        int ans = N + 1;
        Deque<Integer> monoq = new LinkedList<>();
        for (int y = 0; y < P.length; ++y) {
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());
            monoq.addLast(y);
        }
        return ans < N + 1 ? ans : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(shortestSubarray(arr, k));
        sc.close();
    }
}
