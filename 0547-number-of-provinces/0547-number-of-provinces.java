class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                cnt++;
                dfs(i, visited, isConnected);
            }
        }

        return cnt;
    }

    private void dfs(int node, boolean[] visited, int[][] adj) {
        visited[node] = true;
        for(int i=0; i<adj.length; i++) {
            if(!visited[i] && adj[node][i] == 1)
                dfs(i, visited, adj);
        }
    }
}