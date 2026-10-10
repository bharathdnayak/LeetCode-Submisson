class Solution {
    public int singleNumber(int[] nums) {
        
        int ans=0;
        for(int i=0;i<=32;i++){
            int cnt=0;
            for(int j=0;j<nums.length;j++){
            if ((nums[j] & (1 << i)) != 0){
                cnt++;
            }
            }
            cnt=cnt%3;
             if (cnt != 0) {
                ans |= (1 << i);
            }

        }
        return ans;
    }
}