public class Solution{
    
    public static void main(String args[]){
        String text = "abcknt";
        String pattern = "a?c*t";
        System.out.println(isPatternMatchingRecursive(text, pattern));
        System.out.println(isPatternMatchingDP(text, pattern));
    }

    public static boolean isPatternMatchingRecursive(String text, String pattern){
        // System.out.println("text = "+text+" pattern = "+pattern);
        if(text.length() == 0 && pattern.length() == 0)
            return true;
        
        if(text.length() == 0 || pattern.length() == 0)
            return false;

        if(text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '?')
            return isPatternMatchingRecursive(text.substring(1, text.length()), pattern.substring(1, pattern.length()));

        if(pattern.charAt(0) == '*')
            return isPatternMatchingRecursive(text.substring(1, text.length()), pattern.substring(1, pattern.length())) || isPatternMatchingRecursive(text.substring(1, text.length()), pattern);

        return false;
    }

    public static boolean isPatternMatchingDP(String text, String pattern){
        boolean dp[][] = new boolean[text.length() + 1][pattern.length() + 1];
        for(int i = 1;i<text.length() + 1;i++)
            dp[i][0] = false;
        for(int i = 1;i<pattern.length() + 1;i++)
            dp[0][i] = false;
        dp[0][0] = true;

        for(int i = 1;i<text.length() + 1;i++){
            for(int j = 1;j<pattern.length() + 1;j++){
                if(text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?')
                    dp[i][j] = true;
                else if(pattern.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-1];
                else
                    dp[i][j] = false;
            }
        }
        for(int i = 0;i<=text.length();i++){
            for(int j = 0;j<=pattern.length();j++){
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return dp[text.length()][pattern.length()];
    }
}