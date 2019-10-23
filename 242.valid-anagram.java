import java.util.Arrays;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (51.55%)
 * Total Accepted:    321.3K
 * Total Submissions: 623K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * 
 */
class Solution {
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.toString(sArr).contentEquals(Arrays.toString(tArr));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
            
        int[] s_tab = new int[26];
        int[] t_tab = new int[26];

        for (int ch : s.toCharArray()) {
            s_tab[ch - 'a']++;  
        }

        for (int ch : t.toCharArray()) {
            t_tab[ch - 'a']++; 
        }

        for (int i = 0; i < s_tab.length; i++) {
            if(s_tab[i] != t_tab[i]){
                return false;
            }
        }
        return true;
    }
}

