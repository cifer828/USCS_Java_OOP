
public class longestPalindrome3 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        else if (s.length() == 1 || (s.length() == 2 && s.charAt(0) == s.charAt(1)))
            // base case: "a" or "aa"
            return s;       
        if (s.charAt(0) == s.charAt(s.length() - 1)){
            String inner = longestPalindrome(s.substring(1, s.length() - 1));
            if (inner.length() == s.length() - 2) {
            	System.out.println("Inner is " + s);
                return s;
            }
            else 
                return inner;
        }
        else{
            String left = longestPalindrome(s.substring(0, s.length() - 1));
            String right = longestPalindrome(s.substring(1, s.length()));
            if (left.length() > right.length())
                return left;
            else
                return right;
        }
    }
    public static void main(String[] args) {
    	System.out.println(longestPalindrome("afadfasdffa"));
    }
}
