package top.dtyy.leetcode.t307;

class NumArray {
    // 存放数据
    int[] data;
    
    // 存放前i个元素的和
    int[] sum;

    public NumArray(int[] nums) {
        int length = nums.length;
        data = new int[length];
        sum = new int[length + 1];
        sum[0] = 0;
        for(int i = 1; i <= length; i++){
            data[i - 1] = nums[i - 1];
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        
    }
    
    public void update(int i, int val) {
        data[i] = val;
        // 只更新i索引以及以后的和
        for(int j = i + 1; j < sum.length; j++){
            sum[j] = sum[j - 1] + data[j - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        // 注意索引
        return sum[j + 1] - sum[i];
    }
}