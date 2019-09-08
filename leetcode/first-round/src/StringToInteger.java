
public class StringToInteger {
    public static int myAtoi(String str) {
        str = str.trim();
        int cur = 0;
        int result = 0;
        int flag = 1;
        int curNum;
        while (cur < str.length()) {
            curNum = (int)str.charAt(cur) - 48; // ASCII
            if (curNum <= 9 && curNum >= 0) {
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && curNum > 7))
                    return Integer.MAX_VALUE;
                else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && curNum > 8))
                    return Integer.MIN_VALUE;
                else
                    result = result * 10 + flag * curNum;
            }
            else if (cur == 0) {
                if (str.charAt(cur) == '-') 
                    flag = -1;
                else if (str.charAt(cur) == '+')
                    continue;
                else
                	break;
            }
            else
                break;
            cur++;
        }
        return result;
    }
    public static void main(String args[]) {
    	int ret = myAtoi(".1");
    	System.out.println(ret); //
//    	System.out.println(Integer.MIN_VALUE);
    }
}
//-2147483648