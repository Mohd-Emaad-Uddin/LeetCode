class DisjointSet {
    public int[] parent;
    public int[] rank;
    int n;

    public DisjointSet(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(parent[x] == x)
            return x;
        
        return parent[x] = find(parent[x]);
    }

    public void unionByRank(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(parA == parB)
            return;
        
        if(rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        }
        else if(rank[parA] > rank[parB]) {
            parent[parB] = parA;
        }
        else {
            parent[parA] = parB;
        }

        
    }
}

class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int cnt = 0;


        // boolean[] visited = new boolean[n];

        // for(int i=0; i<n; i++) {
        //     if(!visited[i]) {
        //         cnt++;
        //         dfs(i, visited, isConnected);
        //     }
        // }
        DisjointSet dsu = new DisjointSet(n);
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(isConnected[i][j] == 1) {
                    dsu.unionByRank(i, j);
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(dsu.parent[i] == i)
                cnt++;
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