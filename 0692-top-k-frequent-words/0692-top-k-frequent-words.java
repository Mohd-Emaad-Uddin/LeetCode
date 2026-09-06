class Pair implements Comparable<Pair> {
    String s;
    int freq;

    public Pair(String s, int freq) {
        this.s = s;
        this.freq = freq;
    }

    public int compareTo(Pair p) {
        if(this.freq == p.freq)
            return p.s.compareTo(this.s);
        return Integer.compare(this.freq, p.freq);
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(String s: map.keySet()) {
            int val = map.get(s);
            pq.add(new Pair(s, val));
            if(pq.size() > k)
                pq.remove();
        }

        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            ans.add(p.s);
        }

        Collections.reverse(ans);
        return ans;
    }
}