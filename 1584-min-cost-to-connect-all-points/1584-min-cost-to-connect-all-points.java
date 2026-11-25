class Pair implements Comparable<Pair>{
    int wt, node;
    public Pair(int wt, int node) {
        this.wt = wt;
        this.node = node;
    }

    public int compareTo(Pair p) {
        return Integer.compare(this.wt, p.wt);
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                adj.get(i).add(Arrays.asList(j, wt));
                adj.get(j).add(Arrays.asList(i, wt));
            }
        }

        int cost = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            int wt = p.wt;
            int node = p.node;

            if(visited[node])
                continue;
            
            // Add into MST
            visited[node] = true;
            cost += wt;

            for(List<Integer> list: adj.get(node)) {
                int nei = list.get(0);
                int wei = list.get(1);

                if(!visited[nei])
                    pq.add(new Pair(wei, nei));
            }
        }

        return cost;
    }
}