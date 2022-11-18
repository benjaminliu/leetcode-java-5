package com.ben.string;

import com.ben.util.PrintUtil;

public class _0005_m_Longest_Palindromic_Substring {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().longestPalindrome("a"));
    }

    static class Solution {

        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String odd = palindrome(s, i, i);
                String even = palindrome(s, i, i + 1);
                if (odd.length() > res.length()) {
                    res = odd;
                }

                if (even.length() > res.length()) {
                    res = even;
                }
            }
            return res;
        }

        private String palindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
            }

            return s.substring(left + 1, right);
        }
    }
}
