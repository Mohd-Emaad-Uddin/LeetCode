class Triplet implements Comparable<Triplet>{
    int x, y;
    long dist;
    public Triplet(int x, int y, long dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public int compareTo(Triplet t) {
        return Long.compare(this.dist, t.dist);
    }
}

class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] point: points) {
            int x = point[0], y = point[1];
            long dist = x*x + y*y;
            pq.add(new Triplet(x, y, dist));
            if(pq.size() > k) 
                pq.remove();
        }

        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++) {
            Triplet t = pq.remove();
            int x = t.x, y= t.y;
            ans[i][0] = x;
            ans[i][1] = y;
        }

        return ans;
    }
}