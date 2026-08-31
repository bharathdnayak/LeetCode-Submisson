class Solution {
    public int numIslands(char[][] grid) {
        int cnt=0;
        int n=grid.length;
        int m=grid[0].length;
        int[] dx={0,0,-1,1};
        int[] dy={-1,1,0,0};
        boolean[][] vis=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    q.offer(new int[]{i,j});
                     vis[i][j] = true;
                    cnt++;
                
                while(!q.isEmpty()){
                    int[] cur=q.poll();

                    int x=cur[0];
                    int y=cur[1];
                   
                    
                    for(int d=0;d<4;d++){
                        int curx=x+dx[d];
                        int cury=y+dy[d];
                    if (curx >= 0 && curx < n && cury >= 0 && cury < m &&grid[curx][cury] == '1' &&!vis[curx][cury]) {
                            q.offer(new int[]{curx,cury});
                            vis[curx][cury] = true;
                        }
                    }
                }
                }
            }
        }
        return cnt;
        
    }
}