class Solution {
   

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] ans=new int[numCourses];
        int idx=0;
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];

        for(int[] i:prerequisites){
            int course=i[0];
            int pre=i[1];
            adj.get(pre).add(course);
            indegree[course]++;

        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
           
            int cur=q.poll();
            ans[idx++]=cur;
            for(int neig:adj.get(cur)){

                indegree[neig]--;
                if(indegree[neig]==0){
                    q.offer(neig);
                }
            }
        }
                if (idx != numCourses) {
            return new int[0];
        }
        return ans;
    }
}