class Pair implements Comparable<Pair> {
    char ch;
    int freq;

    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public int compareTo(Pair p) {
        if(this.freq == p.freq)
            return Integer.compare(this.ch, p.ch);
        return Integer.compare(this.freq, p.freq);
    }
}

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char ch: map.keySet()) {
            pq.add(new Pair(ch, map.get(ch)));
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = null;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            sb.append(curr.ch);
            curr.freq--;

            if(prev != null && prev.freq > 0) {
                pq.add(prev);
            }

            prev = curr;
        }
        if(prev != null && prev.freq > 0) {
            return "";
        }

        return sb.toString();
    }   
}