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
        
        int[][] dp = new int[len][len];

        int start=0, end=0, maxLen = 0;
        
        // s[i,j] = dp[i+1][j-1] & s[i] == s[j] 
        for(int i = len -1; i >=0; i--){
            for(int j = i; j < len; j++){
                // 单个字符
                if(j == i){
                    dp[i][j] = 1;
                    continue;
                }

                if(s.charAt(i) == s.charAt(j)){
                    if(j - i == 1 || dp[i+1][j-1] == 1 ){
                        dp[i][j] = 1;
                        if(j -i >= maxLen){
                            maxLen = j -i;
                            start = i;
                            end = j;
                        }
                        continue;
                    }
                }   
            }
        }

        return s.substring(start, end + 1);
    }
}
// @lc code=end

