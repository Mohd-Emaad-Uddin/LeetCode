class Pair {
    String word;
    int dist;

    public Pair(String word, int dist) {
        this.word = word;
        this.dist = dist;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s: wordList) {
            set.add(s);
        }

        if(!set.contains(endWord))
            return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        if(set.contains(beginWord))
            set.remove(beginWord);

        while(!q.isEmpty()) {
            Pair p = q.poll();
            String s = p.word;
            int d = p.dist;

            // StringBuilder sb = new StringBuilder(s);
            if(s.equals(endWord))
                return d;

            for(int i=0; i<s.length(); i++) {
                char[] arr = s.toCharArray();

                for(char ch='a'; ch<='z'; ch++) {
                    if(arr[i] == ch)
                        continue;
                    arr[i] = ch;

                    if(set.contains(new String(arr))) {
                        System.out.println(new String(arr));
                        q.offer(new Pair(new String(arr), d+1));
                        set.remove(new String(arr));
                    }
                }
            }
        }

        return 0;
    }
}