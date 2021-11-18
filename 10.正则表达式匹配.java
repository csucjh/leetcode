/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        // dp[i][j] = dp[i-1][j-1] && (p[j] == '.' || p[j] == s[i])
        // dp[i][j-2] && p[j] == '*'
        // (dp[i-1][j-2] && (s[i] == p[j-1] || p[j-1] == '.'))  && p[j] == '*'
        // (dp[i-1][j] && (s[i] == p[j-1] || p[j-1] == '.'))  && p[j] == '*'

        if(s == null || p == null){
            return false;
        }

        if(s == null && p ==null){
            return true;
        }
        
        int s_len = s.length();
        int p_len = p.length();
        boolean[][] dp = new boolean[s_len][p_len];
        for(int i = 0; i < s_len; i++){
            for(int j = 0; j < p_len; j++){
                if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){
                    if(i -1 >= 0 && j - 1 >= 0){
                        dp[i][j] = dp[i-1][j-1];
                        continue;
                    }

                    
                }
            }
        }
    }
}
// @lc code=end

