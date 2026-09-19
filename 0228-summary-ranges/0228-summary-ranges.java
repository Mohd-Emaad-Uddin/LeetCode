class Solution {
    public List<String> summaryRanges(int[] arr) {
        List<String> ans = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            int start = i;
            while(i + 1 < arr.length && arr[i+1] - arr[i] == 1) {
                i++;
            }

            if(start == i)
                ans.add(String.valueOf(arr[start]));
            else
                ans.add(arr[start] + "->" + arr[i]);
        }
        return ans;
    }
}