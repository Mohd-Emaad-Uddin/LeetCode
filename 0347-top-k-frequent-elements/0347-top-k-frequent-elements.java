class Pair implements Comparable<Pair> {
    int ele;
    int freq;
    public Pair(int ele, int freq) {
        this.ele = ele;
        this.freq = freq;
    }

    public int compareTo(Pair p) {
        if(this.freq == p.freq)
            return this.ele - p.ele;
        return this.freq - p.freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int ele: map.keySet()) {
            int freq = map.get(ele);
            pq.add(new Pair(ele, freq));
            if(pq.size() > k)
                pq.remove();
        }

        int[] ans = new int[k];
        int idx = 0;
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            ans[idx++] = p.ele;
        }

        return ans;
    }
}