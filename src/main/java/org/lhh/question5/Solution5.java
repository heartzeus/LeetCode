package org.lhh.question5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] ss = s.toCharArray();
        int mid = 0;
        String result = "";
        while (mid != s.length()) {
            if (result.length() == 0) {
                result = String.valueOf(ss[mid]);
            }
            if (mid > 0 && (mid - 1) >= 0 && (mid ) <= s.length() - 1 && ss[mid] == ss[mid - 1]) {//偶数回文字符串
                String tmpResult = String.valueOf(ss[mid - 1]) + String.valueOf(ss[mid]);
                int step = 1;
                while ((mid - 1 - step) >= 0 && (mid + step) <= s.length() - 1 && ss[mid + step] == ss[mid - 1 - step]) {
                    tmpResult = ss[mid - 1 - step] + tmpResult + ss[mid + step];
                    step++;
                }
                if (result.length() < tmpResult.length()) {
                    result = tmpResult;
                }
            }
            if (mid > 0 && (mid - 1) >= 0 && (mid + 1) <= s.length() - 1 && ss[mid + 1] == ss[mid - 1]) {//奇数回文字符串
                String tmpResult = String.valueOf(ss[mid - 1]) + String.valueOf(ss[mid]) + String.valueOf(ss[mid + 1]);
                int step = 1;
                while ((mid - 1 - step) >= 0 && (mid + 1 + step) <= s.length() - 1 && ss[mid + 1 + step] == ss[mid - 1 - step]) {
                    tmpResult = ss[mid - 1 - step] + tmpResult + ss[mid + 1 + step];
                    step++;
                }
                if (result.length() < tmpResult.length()) {
                    result = tmpResult;
                }
            }
            mid ++;

        }
        return result;
    }
}
