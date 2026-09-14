class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        pq.add(1L);
        set.add(1L);

        long ugly = 1;
        for(int i=0; i<n; i++) {
            ugly = pq.remove();
            long a = ugly * 2, b = ugly * 3, c = ugly * 5;

            if(!set.contains(a)) {
                set.add(a);
                pq.add(a);
            }
            if(!set.contains(b)) {
                set.add(b);
                pq.add(b);
            }
            if(!set.contains(c)) {
                set.add(c);
                pq.add(c);
            }
        }

        return (int)ugly;
    }
}