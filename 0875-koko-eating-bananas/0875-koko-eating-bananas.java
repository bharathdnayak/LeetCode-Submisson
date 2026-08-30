class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=Integer.MIN_VALUE;
        int n=piles.length;
        for(int i=0;i<n;i++){
            r=Math.max(piles[i],r);
        }
        int res=0;
       while(l<=r){
        int mid=(l+r)/2;
        boolean ans=howmanyHr(piles,mid,h);
        if(ans==true){
            r=mid-1;
            res=mid;
        }else{
            l=mid+1;
        }
       }
       return res;


    }
    boolean howmanyHr(int[] arr,int cur,int h){
                long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            ans += arr[i] / cur;

            if (arr[i] % cur != 0) {
                ans++;
            }
        }

        return ans <= h;
    }
}