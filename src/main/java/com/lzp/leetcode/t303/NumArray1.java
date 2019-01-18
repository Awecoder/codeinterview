package com.lzp.leetcode.t303;

public class NumArray1 {
    
    // sum[i]存储前i个元素之和
    // sum[0]=0, sum[i]存储nums[0...i-1]的和
    private int[] sum;
    
    // 0(n)
    public NumArray1(int[] nums) {
        // 因为sum[0]放置的是0个元素的和
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */