class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int num: bills) {
            if(num == 5)
                five++;
            else if(num == 10) {
                if(five > 0) {
                    five -= 1;
                    ten++;
                }
                else
                    return false;
            }

            else {
                if(ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                else if(five > 2)
                    five -= 3;
                else
                    return false;
            }
        }

        return true;
    }
}