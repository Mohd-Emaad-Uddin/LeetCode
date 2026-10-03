class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        for(int num: arr) {
            set.add(num);
        }

        int maxLen = 0;
        for(int num: set) {
            if(!set.contains(num - 1)) {
                int curr = num;
                int count = 1;

                while(set.contains(curr + 1)) {
                    count++;
                    curr++;
                }

                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}