package com.lzp.leetcode.t001;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历法
 * <pre>
 *     复杂度分析
 *     时间复杂度0(n): 一次for循环遍历数组元素，哈希查找复杂度为0(1)
 *     空间复杂度0(n): 借助了map数据结构，取决于存入map元素的个数
 * </pre>
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 借助于HashMap,数组元素为key,元素索引为value
        Map<Integer, Integer> map = new HashMap<>();
        // 输出容器，初始化为{0,0}
        int[] res = new int[2];
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 若map已经包含与当前元素匹配元素
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                // 此时，当前元素还没有放入到map中，直接返回当前元素索引即可
                // res[1] = map.get(nums[i]); 【不正确!!!】
                res[1] = i;
                return res;
            }
            // 若无匹配，将元素放入map中
            map.put(nums[i], i);
        }
        return res;
    }
}