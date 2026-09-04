class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] mini=new int[n];
        int premini=nums[n-1];
        mini[n-1]=premini;
        
        int premax=nums[0];
        for(int i=n-2;i>=0;i--){
            if(nums[i]<premini){
                premini=nums[i];
            }
            mini[i]=premini;
        }

         for(int i=0;i<n;i++){
            if(nums[i]>premax){
                premax=nums[i];
            }
            if(premax-mini[i]<=k){
                return i;
            }
        }
        
        return -1;

    }
}