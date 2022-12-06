package com.ben.string;


import com.ben.util.PrintUtil;

public class _0151_m_Reverse_Words_in_a_String {

    public static void main(String[] args) {
        String s = "  hello     world  ";

        PrintUtil.printLn(new Solution().reverseWords(s));
    }

    static class Solution {
        private static final char blank = ' ';

        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder(s.length());
            int idx = s.length() - 1;
            while (idx >= 0) {
                //trim end blank
                while (idx >= 0 && s.charAt(idx) == blank) {
                    idx--;
                }

                while (idx >= 0 && s.charAt(idx) != blank) {
                    sb.append(s.charAt(idx));
                    idx--;
                }

                while (idx >= 0 && s.charAt(idx) == blank) {
                    idx--;
                }
                if (idx >= 0) {
                    sb.append(blank);
                }
            }

            char[] chars = sb.toString().toCharArray();

            int left = 0;
            int right = 0;
            while (right < chars.length) {
                while (right < chars.length && chars[right] != blank) {
                    right++;
                }

                swap(chars, left, right - 1);
                while (right < chars.length && chars[right] == blank) {
                    right++;
                }
                left = right;
            }

            return new String(chars);
        }

        private void swap(char[] chars, int left, int right) {
            while (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;

                left++;
                right--;
            }
        }
    }

    static class Solution2 {
        private static final char blank = ' ';

        public String reverseWords(String s) {
            int idx = s.length() - 1;

            StringBuilder sb = new StringBuilder(s.length());

            while (idx >= 0) {
                //Skip leading blank
                while (idx >= 0 && s.charAt(idx) == blank) {
                    idx--;
                }

                int end = idx;

                while (idx >= 0 && s.charAt(idx) != blank) {
                    idx--;
                }

                for (int i = idx + 1; i <= end; i++) {
                    sb.append(s.charAt(i));
                }

                //check if need a blank between words,
                //if we meet another non blank char, then there is another word
                while (idx >= 0 && s.charAt(idx) == blank) {
                    idx--;
                }
                //not reach the end, so there is another word
                if (idx >= 0) {
                    sb.append(blank);
                }
            }
            return sb.toString();
        }
    }
}
