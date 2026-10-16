class Solution {
    public int numIdenticalPairs(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for(int num: arr) {
            count += map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}