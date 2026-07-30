class Solution {
    public int countDigits(int num) {
        int cnt=0;
        int val=num;
        while(val>0){
            int cur=val%10;
            if(num%cur==0){
                cnt++;
            }
            val=val/10;
        }
        return cnt;
    }
}