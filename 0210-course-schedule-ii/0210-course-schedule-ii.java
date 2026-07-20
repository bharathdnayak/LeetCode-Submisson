class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int[] state;
    int[] ans;
    int idx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        state = new int[numCourses];
        ans = new int[numCourses];
        idx = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i))
                    return new int[0];
            }
        }

        return ans;
    }

    boolean dfs(int node) {

        state[node] = 1; 
        for (int nei : adj.get(node)) {

            if (state[nei] == 1)
                return false; 

            if (state[nei] == 0) {
                if (!dfs(nei))
                    return false;
            }
        }

        state[node] = 2;      
        ans[idx--] = node;   
        return true;
    }
}