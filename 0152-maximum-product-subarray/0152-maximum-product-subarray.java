class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int curMax = Math.max(nums[i],
                    Math.max(max * nums[i], min * nums[i]));

            int curMin = Math.min(nums[i],
                    Math.min(max * nums[i], min * nums[i]));

            max = curMax;
            min = curMin;

            ans = Math.max(ans, max);
        }

        return ans;
    }
}