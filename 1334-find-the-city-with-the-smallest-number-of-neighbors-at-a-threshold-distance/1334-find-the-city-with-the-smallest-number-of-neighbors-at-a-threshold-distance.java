class Solution {
    public int findTheCity(int n, int[][] edges, int thre) {
        int[][] cost = new int[n][n];

        int inf = (int)(1e9);

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
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
            cost[v][u] = wt;
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(cost[i][k] != inf && cost[k][j] != inf) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }

        int minCount = Integer.MAX_VALUE;
        int ans = 0;

        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(cost[i][j] != 0 && cost[i][j] <= thre)
                    count++;
            }

            if(count <= minCount) {
                minCount = count;
                ans = i;
            }
        }

        return ans;
    }
}