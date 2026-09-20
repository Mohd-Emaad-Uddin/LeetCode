class Solution {

    public boolean helper(String s, int idx, int cnt) {
        if(cnt < 0)
            return false;
        
        if(idx == s.length())
            return (cnt == 0);

        if(s.charAt(idx) == '(')
            return helper(s, idx+1, cnt+1);
        
        else if(s.charAt(idx) == ')')
            return helper(s, idx+1, cnt-1);
        
        return helper(s, idx+1, cnt+1) || helper(s, idx+1, cnt-1) || helper(s, idx+1, cnt);
    }

    public boolean checkValidString(String s) {
        // Brute Force 
        // return helper(s, 0, 0);
        int min = 0, max = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                min = min + 1;
                max = max + 1;
            }
            else if(s.charAt(i) == ')') {
                min = min - 1;
                max = max - 1;
            }

            else {
                min = min - 1;
                max = max + 1;
            }

            if(min < 0)
                min = 0;
            if(max < 0)
                return false;
        }

        return (min == 0);
    }
}