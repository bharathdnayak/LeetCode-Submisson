class Solution {
    public int missingNumber(int[] nums) {
       int n=nums.length;
       int total=0;
       for(int i=0;i<n;i++){
        total^=nums[i];
       }
       for(int i=0;i<=n;i++){
        total^=i;
       }
     
       return total; 
    }
}