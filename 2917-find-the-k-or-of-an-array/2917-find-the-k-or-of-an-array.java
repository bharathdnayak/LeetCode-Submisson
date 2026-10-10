class Solution {
    public int findKOr(int[] nums, int k) {
        int[] count = new int[32];

        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < 32; i++) {
                if ((nums[j] & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if (count[i] >= k) {
                ans |= (1 << i);
            }
        }

        return ans;
    }
}