package org.lhh.question3;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        String resultStr = "";
        int maxLength = 0;
        for (char c : cs) {
            int index = resultStr.indexOf(c);
            resultStr = resultStr.substring(index > -1 ? (index + 1) : 0) + c;
            if (maxLength < resultStr.length()) {
                maxLength = resultStr.length();
            }
        }
        return maxLength;
    }
}
