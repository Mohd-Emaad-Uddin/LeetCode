class Pair implements Comparable<Pair>{
    char ch;
    int freq;

    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    public int compareTo(Pair p) {
        if(this.freq == p.freq)
            return Character.compare(this.ch, p.ch);
        return Integer.compare(p.freq, this.freq);
    } 
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int[] free = new int[26];

        for(char ch: tasks) {
            freq[ch-'A']++;
            free[ch-'A'] = 1;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<26; i++) {
            if(freq[i] > 0)
                pq.add(new Pair((char)(i + 'A'), freq[i]));
        }

        int seats = 1;
        while(!pq.isEmpty()) {
            List<Pair> temp = new ArrayList<>();
            while(!pq.isEmpty()) {
                Pair p = pq.remove();
                char c = p.ch;
                int fr = p.freq;

                if(free[c - 'A'] <= seats) {
                    if(fr > 1)
                        pq.add(new Pair(c, fr-1));
                    
                    free[c - 'A'] = seats + n + 1;
                    break;
                }

                temp.add(p);
            }
            
            for(Pair p: temp) {
                pq.add(p);
            }
           
            seats++;
        }

        return seats - 1;
    }

}