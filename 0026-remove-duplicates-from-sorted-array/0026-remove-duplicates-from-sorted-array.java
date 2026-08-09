class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int cur=nums[0];
        int idx=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=cur){
                nums[idx]=nums[i];
                cur=nums[i];
                k++;
                idx++;
            }

        }
        return k;
        
        
    }
}