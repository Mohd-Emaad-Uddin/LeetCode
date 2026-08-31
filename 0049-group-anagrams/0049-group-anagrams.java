class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            int[] freq = new int[26];

            for(int i=0; i<s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }

            String key = Arrays.toString(freq);
            
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        List<List<String>> ans = new ArrayList<>();

        for(List<String> list: map.values()) {
            ans.add(list);
        }

        return ans;
    }
}