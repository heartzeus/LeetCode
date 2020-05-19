package org.lhh;

import org.lhh.question2.ListNode;
import org.lhh.question2.Solution2;
import org.lhh.question3.Solution3;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int res = solution3.lengthOfLongestSubstring("abcdefad");
        System.out.println(res);
    }
}
