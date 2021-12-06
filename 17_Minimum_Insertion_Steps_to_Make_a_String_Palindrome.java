leetcode->1312
  Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we don't need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
  
  
  class Solution {
    public int minInsertions(String s) {
        
       String x="";
        char[] arr= s.toCharArray();
        for(int i=arr.length-1;i>=0;i--){
            x+=Character.toString(arr[i]);
        }
        String[][] dp = new String[s.length()+1][x.length()+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],"");
        }
        
        for(int i =1;i<dp.length;i++){
            for(int j =1;j<dp[i].length;j++){
                if(s.charAt(i-1)==x.charAt(j-1))
                    dp[i][j]=s.charAt(i-1)+dp[i-1][j-1];
                else
                    dp[i][j]=dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }
        }
        
        return s.length()-dp[s.length()][x.length()].length();
        
    }
}
