class Solution {
    public int smallestIndex(int[] nums) {
    for(int i=0;i<nums.length;i++){
        int sum=0;
        int digit=nums[i];
        while(digit>0){
            sum+=digit%10;
            digit/=10;
        }
        if(sum==i){
            return i;
        }
    }
    return -1;
    }
}