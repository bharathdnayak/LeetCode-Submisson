class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;

        int r=n-2;
        while(r>=0 &&nums[r] >= nums[r + 1]){
            r--;
        }
        if(r>=0){
            int j = n - 1;

            while (nums[j] <= nums[r]) {
                j--;
            }

            swap( r, j,nums);
        }
         rev( r + 1, n - 1,nums);
    }
    void swap(int i, int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void rev(int i, int j,int[] nums){
        while(i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
}
