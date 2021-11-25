/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if(s == null && s.isEmpty()){
            return null;
        }

        int len = s.length();
        
        String longest = ""; 

        for(int i = 0; i < len; i++){
            // 如果是奇数，只有一个中心
            String longestOne = palindrome(s, i, i);
            
            // 如果是偶数，有两个中心
            String longestTwo = palindrome(s, i, i + 1);

            // 比较长度
            longest = longestOne.length() > longest.length() ? longestOne : longest;
            longest = longestTwo.length() > longest.length() ? longestTwo : longest;
        }

        return longest;
    }

    // left和right都是中心
    public String palindrome(String s, int left, int right){
       
        while(left >= 0 && right < s.length() &&
            s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
// @lc code=end

