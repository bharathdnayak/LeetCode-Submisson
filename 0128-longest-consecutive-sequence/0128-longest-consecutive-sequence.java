class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans=0;
        for(int i:set){
            if(!set.contains(i-1)){
                int cur=i;
                int cnt=1;
                while(set.contains(cur+1)){
                    cnt++;
                    cur++;
                }
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }
}
