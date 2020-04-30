// Given two strings s and t which consist of only lowercase letters.

// String t is generated by random shuffling string s and then add one more letter at a random position.

// Find the letter that was added in t.

// Example:

// Input:
// s = "abcd"
// t = "abcde"

// Output:
// e

// Explanation:
// 'e' is the letter that was added.
public class FindTheDifference {
    class Solution {
        public char findTheDifference(String s, String t) {
            char c = t.charAt(t.length()-1);
            
            for(int i = 0; i < s.length(); i++){
                c ^= s.charAt(i);
                c ^= t.charAt(i);
            }
            return c;
        }
    }

}