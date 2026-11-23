class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for(String word: words) {
            int pos = word.charAt(word.length() - 1) - '0';
            String org = word.substring(0, word.length()-1);
            result[pos-1] = org;
        }

        return String.join(" ", result);
    }
}