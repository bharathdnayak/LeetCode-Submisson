class Solution {
    public int majorityElement(int[] nums) {
     int n=nums.length;
     int val=n/2;
     HashMap<Integer,Integer> map=new HashMap<>();

     for(int i=0;i<n;i++){
        int curval=map.getOrDefault(nums[i],0);
        if(curval>=val){
            return nums[i];
        }
        map.put(nums[i],curval+1);

     }
     return -1;

    }
}