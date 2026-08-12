class Solution {
    public int missingNumber(int[] nums) {
       int n=nums.length;
       int total=0;
       for(int i=0;i<n;i++){
        total+=nums[i];
       }
       int ans=0;
       ans = (n * (n + 1) / 2) - total;
       return ans;
    }
}