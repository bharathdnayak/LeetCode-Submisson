class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int cnt=0;
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
            cnt++;
            int cur=q.poll();
            for(int neig:adj.get(cur)){

                indegree[neig]--;
                if(indegree[neig]==0){
                    q.offer(neig);
                }
            }
        }
        return cnt==numCourses;
    }
}