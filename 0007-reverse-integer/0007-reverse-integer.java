class Solution {
    public int reverse(int x) {
        long n=0;
        int cur=1;
        if(x<0){
            cur=-1;
           x= Math.abs(x);
        }
        while(x>0){
            n=n*10;
            int val=x%10;
            n+=val;
            x=x/10;
        }
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) n*cur;
    }
}