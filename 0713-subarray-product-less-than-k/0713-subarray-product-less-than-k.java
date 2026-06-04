class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int ws = 0;
        int prod = 1;
        int count = 0;
        for(int we = 0; we < nums.length; we++) {
            prod *= nums[we];
            while(prod >= k) {
                prod /= nums[ws];
                ws++;
            }
            count += (we - ws + 1);
        }
        return count;
    }
}