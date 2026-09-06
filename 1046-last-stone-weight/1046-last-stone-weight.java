class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: stones) {
            pq.add(num);
        }

        while(pq.size() > 1) {
            int y = pq.remove();
            int x = pq.remove();

            if(x != y)
                pq.add(y-x);
        }

        return (pq.size() == 0) ? 0 : pq.peek();
    }
}