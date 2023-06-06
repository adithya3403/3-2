// 2. Develop a java program to find the Lexicographically smallest equivalent
// string. Given strings A and B of the same length, we say A[i]and B[i]are
// equivalent characters. For example, if A="abc"and B="cde", then we have'a'=='c',
// 'b'=='d','c'=='e'.

// Example 1:
// Input:A="parker",B="morris",S="parser"
// Output:"makkek"
// Explanation:Based on the equivalency information in A and B,we can group their characters
// as[m,p],[a,o],[k,r,s],[e,i].The characters in each group are equivalent and sorted in
// lexicographical order.So the answer is"makkek".

// Example 2:
// Input:A="hello",B="world",S="hold"
// Output:"hdld"
// Explanation:Based on the equivalency information in A and B,we can group their characters
// as[h,w],[d,e,o],[l,r].So only the second letter'o'in S is changed to'd',the answer is"hdld".

// Example 3:
// Input:A="leetcode",B="programs",S="sourcecode"
// Output:"aauaaaaada"
// Explanation:We group the equivalent characters in A and B
// as[a,o,e,r,s,c],[l,p],[g,t]and[d,m],thus all letters in S except'u'and'd'are transformed
// to'a',the answer is"aauaaaaada".

// Note: String A, B and S consist of lowercase English letters from'a'-'z'.
// String A and B are of the same length.


import java.util.*;

public class exp2 {
    static int[] graph;

    public static String smallestEqString(String A, String B, String S) {
        graph = new int[26];
        for (int i = 0; i < 26; i++)
            graph[i] = i;
        for (int i = 0; i < A.length(); i++) {
            int a = A.charAt(i) - 'a', b = B.charAt(i) - 'a';
            int end1 = find(b), end2 = find(a);
            if (end1 < end2)
                graph[end2] = end1;
            else
                graph[end1] = end2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            sb.append((char) ('a' + find(c - 'a')));
        }
        return sb.toString();
    }

    static int find(int i) {
        if (graph[i] == i)
            return i;
        return graph[i] = find(graph[i]);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String S = sc.next();
        System.out.println(smallestEqString(A, B, S));
        sc.close();
    }
}
