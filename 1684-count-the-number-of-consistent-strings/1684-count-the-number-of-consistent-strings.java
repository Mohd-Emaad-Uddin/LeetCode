class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;

        for(String s: words) {
            boolean cons = true;
            for(char ch: s.toCharArray()) {
                if(allowed.indexOf(ch) == -1) {
                    cons = false;
                    break;
                }
            }

            if(cons)
                cnt++;
        }

        return cnt;
    }
}