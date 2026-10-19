class Triplet {
    int stops, node, dist;
    public Triplet(int stops, int node, int dist) {
        this.stops = stops;
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] flight: flights) {
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];

            adj.get(u).add(new int[]{v, wt});
        }

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(0, src, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;

        while(!q.isEmpty()) {
            Triplet t = q.remove();
            int stops = t.stops;
            int node = t.node;
            int d = t.dist;

            if(stops > k)
                continue;

            for(int[] num: adj.get(node)) {
                int nei = num[0];
                int wt = num[1];

                if(d + wt < dist[nei]) {
                    dist[nei] = d + wt;
                    q.add(new Triplet(stops + 1, nei, dist[nei]));
                }
            }
        }

        return (dist[dst] == (int)(1e9) ? -1 : dist[dst]);
    }
}