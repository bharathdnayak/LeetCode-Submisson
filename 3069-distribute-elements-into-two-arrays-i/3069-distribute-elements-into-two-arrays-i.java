class Solution {
    public int[] resultArray(int[] nums) {
        int i=1;
        int j=1;
        int n=nums.length;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        arr1[0]=nums[0];
        arr2[0]=nums[1];

        for(int k=2;k<n;k++){
            if(arr1[i-1]>arr2[j-1]){
                arr1[i++]=nums[k];

            }else{
                arr2[j++]=nums[k];
            }

        }
         int[] ans = new int[n];

        System.arraycopy(arr1, 0, ans, 0, i);
        System.arraycopy(arr2, 0, ans, i, j);

        return ans;
        
    }
}