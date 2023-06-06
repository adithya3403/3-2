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

class PermutationPalindrome {
    public boolean canPermutePalindrome(String s) {
        Integer bitMask = 0;
        for (int i = 0; i < s.length(); i++)
            bitMask ^= 1 << (s.charAt(i) - 'a' + 1);
        return Integer.bitCount(bitMask) <= 1;
    }
}


public class p1h {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        PermutationPalindrome pp = new PermutationPalindrome();
        System.out.println(pp.canPermutePalindrome(str));
        sc.close();
    }
}
