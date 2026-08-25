class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int curk=k;
      
        while(set.contains(curk)){
            curk+=k;
           
        }
        return curk;
    }
}