public class Solution {
    public String addStrings(String num1, String num2) {
        String res = "";
        int i = num1.length()-1; 
        int j = num2.length()-1;
        int sum, a, b;
        int flag = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                a = num1.charAt(i--) - '0';
            } else {
                a = 0;
            }
            if (j >= 0) {
                b = num2.charAt(j--) - '0';
            } else {
                b = 0;
            }
            sum = a + b + flag;
            res = (char)(sum%10 + '0') + res;
            flag = sum / 10;
        }
        return flag == 1? "1" + res : res;
    }
}
