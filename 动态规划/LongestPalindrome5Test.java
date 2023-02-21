package Leetcode;

public class LongestPalindrome5Test {
    public static void main(String[] args) {
        String s="baba";
        String res=LongestPalindrome.longestPalindrome(s);
        System.out.println("最长回文数="+res);
    }
}
class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        //初始化所以长度为1的子串为回文数
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {//L=j-i+1
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
            return s.substring(begin, begin + maxLen);
    }

}