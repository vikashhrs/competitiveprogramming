class EditDistance{
    public static void main(String args[]){
        System.out.println(returnCount("bat", "but", 0, 0));
        System.out.println(returnCount("abdca", "cbda", 0, 0));
        System.out.println(returnCount("passpot", "ppsspqrt", 0, 0));

        System.out.println(bottomUp("bat", "but"));
        System.out.println(bottomUp("abdca", "cbda"));
        System.out.println(bottomUp("passpot", "ppsspqrt"));
    }

    public static int returnCount(String s1, String s2, int l1, int l2){
        if(l1 == s1.length())
            return s2.length() - l2;

        if(l2 == s2.length())
            return s1.length() - l1;

        if(s1.charAt(l1) == s2.charAt(l2))
            return returnCount(s1, s2, l1+1, l2+1);

        int insert = 1 + returnCount(s1, s2, l1, l2+1);
        int deletion = 1 + returnCount(s1, s2, l1+1, l2);
        int replacement = 1 + returnCount(s1, s2, l1+1, l2+1);
        return Math.min(insert, Math.min(deletion, replacement));
    }

    public static int bottomUp(String s1, String s2){
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 0;i<=s1.length();i++){
            for(int j = 0;j<=s2.length();j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;

                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = 1 + dp[i][j-1];
                    int deletion = 1 + dp[i-1][j];
                    int replacement = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, Math.min(deletion, replacement));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}