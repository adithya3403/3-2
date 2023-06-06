// i. Write a JAVA Program to return all index pairs[i,j] given a text string and words(a list), so
// that the substring text[i]...text[j] is in the list of words

// Given a text string and words(a list of strings), return all index pairs[i,j]
// so that the substring text[i]...text[j]is in the list of words.
// Note: All strings contains only lowercase English letters. It's guaranteed
// that all strings in words are different. Return the pairs[i,j] in sorted order
// (i.e.sort them by their first coordinate in case of ties sort them by their
// second coordinate).

// Example 1:
// Input:text="thestoryofleetcodeandme",words=["story","fleet","leetcode"]
// Output:[[3,7],[9,13],[10,17]]

// Example 2:
// Input:text="ababa",words=["aba","ab"]
// Output:[[0,1],[0,2],[2,3],[2,4]]
// Explanation:Notice that matches can overlap,see"aba"is found in [0,2]and[2,4].

import java.util.*;

class Trie {
    Trie[] children;
    boolean isEnd;

    Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    void insert(String word) {
        Trie cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new Trie();
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
}


public class p1i {
    public static List<List<Integer>> findIndexPairs(String text, String[] words) {
        Trie root = new Trie();
        for (String word : words)
            root.insert(word);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            Trie cur = root;
            for (int j = i; j < text.length(); j++) {
                cur = cur.children[text.charAt(j) - 'a'];
                if (cur == null)
                    break;
                if (cur.isEnd) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    res.add(pair);
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = sc.nextLine().split(" ");
        List<List<Integer>> indexpairs = findIndexPairs(text, words);
        System.out.println(indexpairs);
        sc.close();
    }
}
