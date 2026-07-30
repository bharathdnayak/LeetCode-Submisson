class Solution {
    public boolean isPalindrome(int x) {
        int og=x;

        int rev=0;
        if(x==0) return true;

        while(x>0){
            int pop=x%10;

            rev=rev*10+pop;
            x/=10;

        }
        if(rev==og){
            return true;
        }
        else{
            return false;
        }
        
    }
}