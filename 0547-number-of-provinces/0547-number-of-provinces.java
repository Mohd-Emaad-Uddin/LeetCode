class Solution {

    public void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for(int num: adj.get(node)) {
            if(!visited[num])
                dfs(num, visited, adj);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        int n = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) { 
                if(isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n+1];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                cnt++;
                dfs(i, visited, adj);
            }
        }

        return cnt;
    }
}