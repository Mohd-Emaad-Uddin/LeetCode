class Solution {

    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        int[] indegree = new int[n];
        for(int i=0; i<adj.size(); i++) {
            for(int j=0; j<adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        int[] ans = new int[n];
        int j = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            ans[j++] = node;

            for(int num: adj.get(node)) {
                indegree[num]--;
                if(indegree[num] == 0)
                    q.offer(num);
            }
        }

        if(j != n)
            return new int[0];

        return ans;
    }
}