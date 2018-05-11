/*
package String;

import java.util.HashMap;

*/
/**
 * 如果pattern第二个字符不是'*'
 * 1. 逐个比较，如果一样，则双方后移，比较剩余的
 * 2. 如果不一样，则返回false
 * 如果pattern第二个字符是'*'
 * 1. 如果当前字符和pattern第一个不相同，str++，pattern+2
 * 2. 如果当前字符和pattern第一个相同
 * 2.1 str不动，pattern+2
 * 2.2 str+1,pattern+2
 * 2.3 str+1，pattern不动，'*'不变
 * Created by liqiushi on 2018/3/8.
 *//*

public class Match {
    public  boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        for (strIndex= str.length; strIndex>= 0 ;--strIndex) {
            for (patternIndex= pattern.length;patternIndex>= 0;--patternIndex) {
                if (strIndex == str.length && pattern.length == patternIndex) {
                    dp[strIndex][patternIndex]= true;
                }
                else if (strIndex != str.length && patternIndex == pattern.length ) {
                    dp[strIndex][patternIndex]= false;
                }
                else
                {
                    if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*')
                    {
                        if (strIndex != str.length && str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.' && strIndex != str.length) {
                            dp[strIndex][patternIndex]= dp[strIndex][patternIndex + 2] ||
                                    dp[strIndex+1][patternIndex + 2]||
                                    dp[strIndex+1][patternIndex];
                        }
                        else {
                            dp[strIndex][patternIndex]=dp[strIndex][patternIndex+2];
                        }
                    }
                    else if(strIndex != str.length && pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.' && strIndex != str.length) {
                        dp[strIndex][patternIndex]=dp[strIndex+1][patternIndex+1];
                    }
                    else {
                        dp[strIndex][patternIndex] = false;
                    }
                   
                }
            }
        }
        
    }

    public static void main(String[] args) {
        char[] str = new char[]{' '};
        char[] pattern = new char[]{'.','*'}; 
        boolean res = new Match().match(str, pattern);
    }
}
*/
