/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */
class Solution {

    /**
     * 1、原值x对10求余和除法运算(x/10，x%10);
     * 2、反转值rev = rev * 10 + x%10;
     * 3、原值x= x/10;
     */
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            // 在新值升位反转过程中判断是否已经溢出
            if(rev != rev*10/10){
                return 0;
            }
            rev = rev * 10 + x % 10;
            x /= 10; 
        }

        return rev;
    }
}

