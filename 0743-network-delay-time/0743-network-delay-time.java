class Solution {
    public int networkDelayTime(int[][] edges, int n, int x) {
        int[][] cost = new int[n + 1][n + 1];

        int inf = (int)(1e9);

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == j)
                    cost[i][j] = 0;
                else
                    cost[i][j] = inf;
            }
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            cost[u][v] = wt;
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(cost[i][k] != inf && cost[k][j] != inf) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                    }
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=n; i++) {
            if(cost[x][i] == inf)
                return -1;

            ans = Math.max(ans, cost[x][i]); 
        }

        return ans;
    }
}