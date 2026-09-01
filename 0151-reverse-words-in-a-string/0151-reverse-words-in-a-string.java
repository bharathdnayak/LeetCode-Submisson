class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder(s);
        StringBuilder ans=new StringBuilder();
        sb.reverse();
        int n=s.length();
        int i=0;
        

        
         while(i<n){
            while(i<n && sb.charAt(i)==' ') i++;
            if(i>=n)break;

            int j=i;
            StringBuilder word= new StringBuilder();
            while(j<n && sb.charAt(j)!=' '){
                
                word.append(sb.charAt(j));
                j++;

            }
            word.reverse();
            if(ans.length()>0){
                ans.append(" ");
            }
            ans.append(word);


            i=j;
         }
         return ans.toString()        ;

    }
}