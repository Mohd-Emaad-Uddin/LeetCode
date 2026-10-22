class Solution {
    public String interpret(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i < s.length()) {
            if(s.charAt(i) == 'G')
                sb.append('G');
            else if(s.charAt(i) == '(' && s.charAt(i+1) == ')'){
                sb.append('o');
                i++;
            }
            else {
                sb.append("al");
                i+=3;
            }
            i++;
        }

        return sb.toString();
    }
}