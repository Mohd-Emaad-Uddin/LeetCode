class Triplet implements Comparable<Triplet> {
    int x, y, sum;
    public Triplet(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }

    public int compareTo(Triplet t) {
        if(this.sum != t.sum)
            return Integer.compare(this.sum, t.sum);
        
        if(this.x != t.x)
            return Integer.compare(this.x, t.x);
        return Integer.compare(this.y, t.y);
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] arr1, int[] arr2, int k) {
        int n = arr1.length, m = arr2.length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<Math.min(n, k); i++) {
            pq.add(new Triplet(i, 0, arr1[i] + arr2[0]));
        }

        while(k > 0 && !pq.isEmpty()) {
            Triplet t = pq.remove();
            ans.add(Arrays.asList(arr1[t.x], arr2[t.y]));

            if(t.y + 1 < m) {
                pq.add(new Triplet(t.x, t.y+1, arr1[t.x] + arr2[t.y+1]));
            }

            k--;
        }

        return ans;

    }
}