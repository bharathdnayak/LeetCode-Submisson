class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rev.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            indegree[i] = graph[i].length; 

            for (int neigh : graph[i]) {
                rev.get(neigh).add(i);    
            }
        }
      Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();
            ans.add(node);

            for (int prev : rev.get(node)) {

                indegree[prev]--;

                if (indegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}