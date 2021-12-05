Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
  
  if we say a palindrom is from left to right and right to left is same that means the ocurrence of sequence in the given string is common that means if we reverse the given
  string and store it in a varaible x now if we closely observe the strings we found the sequence is same so that means from both the strings we just need to find the
  lcs of the strings
  class Solution {
    public int longestPalindromeSubseq(String s) {
        String str = "";
        int n=s.length();
        for(int i=n-1;i>=0;i--){
            str += s.charAt(i);
        }
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}
