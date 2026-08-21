class Solution {
    public int longestSubarray(int[] nums) {
        int zerocnt=0;
        int ans=0;
        int l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zerocnt++;
            }
            while (zerocnt > 1) {
          if (nums[l] == 0)
             zerocnt--;

        l++;
        }
        ans = Math.max(ans, i - l);
        }
        return ans;
    }
}