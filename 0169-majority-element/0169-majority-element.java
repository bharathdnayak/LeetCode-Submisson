class Solution {
    public int majorityElement(int[] nums) {
     int vote=0;
     int lead=0;
     for(int num:nums){
        if(vote==0){
            lead=num;
        }
        if(lead==num){
            vote++;
        }else{
            vote--;
        }
     }
     return lead;

    }
}