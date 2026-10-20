class Pair implements Comparable<Pair>{
    long dist;
    int node;
    public Pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }

    public int compareTo(Pair p) {
        return Long.compare(this.dist, p.dist);
    }
}

class Solution {

    private long mod = (long)(1e9) + 7;

    public int countPaths(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            long d = p.dist;
            int node = p.node;

            if(d > dist[node])
                continue;

            for(int[] num: adj.get(node)) {
                int nei = num[0];
                int wt = num[1];

                if(d + wt < dist[nei]) {
                    dist[nei] = d + wt;
                    pq.add(new Pair(dist[nei], nei));
                    ways[nei] = ways[node];
                }
                else if(d + wt == dist[nei])
                    ways[nei] = (int)(((long)ways[node] + ways[nei]) % mod);
                    
            }
        }

        return ways[n-1];
    }
}