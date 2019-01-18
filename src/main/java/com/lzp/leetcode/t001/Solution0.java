package com.lzp.leetcode.t001;

/**
 * 暴力法
 * <pre>
 *     复杂度分析
 *     时间复杂度 0(n^2)：两层for循环遍历数组元素
 *     空间复杂度 0(1)：原地操作，没有借助其他数据结构
 * </pre>
 */
public class Solution0 {
    public int[] twoSum(int[] nums, int target) {
        // 从0遍历到length-1
        for (int i = 0; i < nums.length; i++) {
            // 遍历剩余元素，如果存在某位置和当前位置值加和为target返回
            for (int j = i + 1; j < nums.length; j++) {
                // 加和判断
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}