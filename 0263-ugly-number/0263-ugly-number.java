class Solution {
    public boolean isUgly(int n) {
        if(n <= 0)
            return false;
        int[] arr = {2, 3, 5};
        for(int num: arr) {
            while(n % num == 0)
                n = n / num;
        }

        return n == 1;
    }
}