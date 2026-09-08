class Pair implements Comparable<Pair> {
    char ch;
    int freq;

    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public int compareTo(Pair p) {
        if(this.freq == p.freq)
            return Character.compare(this.ch, p.ch);
        return Integer.compare(this.freq, p.freq);
    }
}

class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for(char ch: s.toCharArray()) {
            hash[ch-'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<26; i++) {
            if(hash[i] > 0)
                pq.add(new Pair((char)(i + 'a'), hash[i]));
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = null;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            sb.append(curr.ch);

            curr.freq--;
            if(prev != null && prev.freq > 0)
                pq.add(prev);
            
            prev = curr;
        }

        if(s.length() != sb.length())
            return "";
        return sb.toString();
    }
}