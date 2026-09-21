class Pair implements Comparable<Pair>{
    int num1, num2;
    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int compareTo(Pair p) {
        return Integer.compare(this.num1, p.num1);
    }
}

class Solution {
    public long maxScore(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        int[][] mat = new int[n][2];

        for(int i=0; i<n; i++) {
            mat[i][0] = arr1[i];
            mat[i][1] = arr2[i];
        }

        Arrays.sort(mat, (a, b)->Integer.compare(b[1], a[1]));

        long sum = 0, ans = Long.MIN_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            pq.add(new Pair(mat[i][0], mat[i][1]));
            sum += mat[i][0];

            if(pq.size() > k) {
                Pair p = pq.remove();
                sum -= p.num1;
            }
            if(pq.size() == k)
                ans = Math.max(ans, sum*mat[i][1]);
        }

        return ans;
    }
}