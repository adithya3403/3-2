// h. Write a JAVA Program to check whether the permutation of a string forms a palindrome
// Given a string s, return true if a permutation of the string could form a palindrome.

// Example 1:
// Input: s = "code"
// Output: false

// Example 2:
// Input: s = "aab"
// Output: true

// Example 3:
// Input: s = "carerac"
// Output: true

import java.util.*;

public class p1h {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(canPermutePalindrome(str));
        sc.close();
    }

    public static boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        int odd = 0;
        for (int cnt : count)
            if (cnt % 2 == 1)
                odd++;
        return odd <= 1;
    }
}
