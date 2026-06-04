class Solution {
    public int longestSubarray(int[] nums) {
        int max=0,rep=0,ws=0,k=1;
        for(int we=0;we<nums.length;we++)
        {
            if(nums[we]==0)
            {
                rep++;
            }
            while(rep>k)
            {
                if(nums[ws]==0)
                {
                    rep--;
                }
                ws++;
            }
            max=Math.max(max,we-ws);
        }
        return max;
    }
}