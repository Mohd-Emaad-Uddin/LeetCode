class Solution {

    public boolean dfs(int node, boolean[] visited, boolean[] pathVis, List<List<Integer>> adj) {
        visited[node] = true;
        pathVis[node] = true;

        for(int num: adj.get(node)) {
            if(!visited[num]) {
                if(dfs(num, visited, pathVis, adj))
                    return true;
            }

            else if(pathVis[num])
                return true;
        }

        pathVis[node] = false;
        return false;
    }

    public boolean canFinish(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        } 

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVis = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i])
                if(dfs(i, visited, pathVis, adj))
                    return false;
        }

        return true;
    }
}