class DisjointSet {
    int n;
    int[] parent;
    int[] rank;

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
        else if(rank[parA] > rank[parB]) 
            parent[parB] = parA;

        else 
            parent[parA] = parB;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        Map<String, Integer> map = new HashMap<>();
        DisjointSet dsu = new DisjointSet(n);

        for(int i=0; i<n; i++) {
            List<String> list = accounts.get(i);

            for(int j=1; j<list.size(); j++) {
                String s = list.get(j);
                if(map.containsKey(s)) {
                    dsu.unionByRank(map.get(s), i);
                }
                map.put(s, i);
            }
        }

        List<List<String>> merge = new ArrayList<>();
        for(int i=0; i<n; i++) {
            merge.add(new ArrayList<>());
        }
        map.forEach((email, index) -> {
            int root = dsu.find(index);
            merge.get(root).add(email);
        });

        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(merge.get(i).isEmpty())
                continue;
            
            Collections.sort(merge.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merge.get(i));

            ans.add(temp);
        }

        return ans;
    }
}