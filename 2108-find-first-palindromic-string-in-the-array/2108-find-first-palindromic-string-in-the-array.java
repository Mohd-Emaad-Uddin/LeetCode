class Solution {
    public String firstPalindrome(String[] words) {
        for(String s: words) {
            int low = 0;
            int high = s.length() - 1;
            boolean isPal = true;

            while(low < high) {
                if(s.charAt(low) != s.charAt(high)) {
                    isPal = false;
                    break;
                }

                low++;
                high--;
            }

            if(isPal)
                return s;
        }

        return "";
    }
}