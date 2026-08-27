class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int r=n-2;
        while(r>=0 && nums[r]>=nums[r+1]){
            r--;
        }
         if (r >= 0){
        int l=n-1;
        while(nums[r]>=nums[l]){
            l--;
        }
         swap(nums,r,l);
        
         }
       
           
        
        rev(nums,r+1,n-1);
    }
    void swap(int[] nums,int r,int l){
        int temp=nums[r];
        nums[r]=nums[l];
        nums[l]=temp;
    }
    void rev(int[] nums,int strt,int end){
        while(strt<end){
        int temp=nums[strt];
        nums[strt]=nums[end];
        nums[end]=temp;
        strt++;
        end--;
        }
    }
}
