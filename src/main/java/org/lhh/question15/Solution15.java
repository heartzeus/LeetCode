package org.lhh.question15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<String> resultSet = new HashSet<>();
        int[] sortNums = sort(nums);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Integer first = null;
        Integer second = null;
        for (int x = 0; x < sortNums.length; x++) {
            int end = sortNums.length - 1;
            for (int y = x + 1; y < end; y++) {
//                System.out.println(x + "-" + y);
//                if (sortNums[x] == -1 && sortNums[y] == -1) {
//                    System.out.printf("");
//                }
                String sign = sortNums[x] + "" + sortNums[y];
                if (!(first != null && second != null && sortNums[x] == first && sortNums[y] == second) && !(resultSet.contains(sign))) {
//                    System.out.println(y + 1 + "" + end);
                    int result = search(nums, 0 - (sortNums[x] + sortNums[y]), y + 1, end + 1);
                    if (result > 0) {
                        first = sortNums[x];
                        second = sortNums[y];
                        List<Integer> tmpList = new ArrayList<Integer>();
                        tmpList.add(sortNums[x]);
                        tmpList.add(sortNums[y]);
                        tmpList.add(0 - (sortNums[x] + sortNums[y]));
                        resultList.add(tmpList);
                        end = result;
                        resultSet.add(sign);
                    }
                }
            }
        }
        return resultList;
    }

    //排序
    public int[] sort(int[] nums) {
        int size = nums.length;
        while (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    //交换位置
                    int tmp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tmp;
                }
            }
            size--;
        }

        return nums;
    }

    public int search(int nums[], int target, int begin, int end) {
        while (true) {
            int index = (begin + end) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (index == begin) {
                return -1;
            }
            if (nums[index] > target) {
                end = index;
            }
            if (nums[index] < target) {
                begin = index;
            }

        }
    }
}
