package org.lhh.question6;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows < 2) {
            return s;
        }
        char[] ss = s.toCharArray();
        int xLength = ((ss.length / (2 * numRows - 2)) + 1) * (numRows - 1);
        char[][] res = new char[xLength][numRows];
        int y = 0;
        int x = 0;
        int direction = -1;
        for (int i = 0; i < ss.length; i++) {

            res[x][y] = ss[i];
            if (i % (numRows - 1) == 0) {
                direction = 0 - direction;
            }
            y+= direction;
            if (direction < 0) {
                x++;
            }
        }
        String resultStr = "";
        for (int a = 0; a < numRows; a++) {
            for (int b = 0; b < xLength;b++) {
                if (res[b][a] != 0) {
                    String tmpStr = String.valueOf(res[b][a]);
                    resultStr += tmpStr;
                }
            }
        }
        return resultStr;
    }
}
