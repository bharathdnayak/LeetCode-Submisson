class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      List<int[]> ans = new ArrayList<>();
      for(int i=1;i<intervals.length;i++){
        int prevstrt=intervals[i-1][0];
        int prevend=intervals[i-1][1];
       
        int start=intervals[i][0];
        int end=intervals[i][1];

        if(prevend>=start){
            intervals[i][0] = prevstrt;
          intervals[i][1] = Math.max(prevend, end);
        }else{
            ans.add(intervals[i - 1]);
        
        }

      }
      ans.add(intervals[intervals.length - 1]);
      return ans.toArray(new int[ans.size()][]);

    }
}