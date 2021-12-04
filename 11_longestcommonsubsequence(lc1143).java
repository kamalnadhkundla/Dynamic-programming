/*

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.


recursion
---------
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
      return backtrack(text1,text2,len1,len2);
    }
    
    public int backtrack(String a , String b , int n, int m ){
        if(n==0 || m==0)
            return 0;
        else  if(a.charAt(n-1)==b.charAt(m-1)){
           // System.out.println()
             return 1+backtrack(a,b,n-1,m-1);
        }
           
        else
            return Math.max(backtrack(a,b,n-1,m),
                            backtrack(a,b,n,m-1)       );
        }
}
*/
memoization
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
      return LCS(text1,text2,len1,len2,new HashMap<>());
    }
    
  static int LCS(String str1,String str2,int n,int m,HashMap <String,Integer> memo)
    {
        
      if (n == 0 || m == 0)
        return 0;
    
      
      String key = n + "|" + m;
    
     
      if (!memo.containsKey(key))
      {
        // if last character of str1 and str2 matches
        if (str1.charAt(n-1) == str2.charAt(m-1))
          memo.put(key,1 + LCS(str1, str2, n - 1, m - 1, memo));
    
        else
        // else if last character of str1 and str2 don't match
        memo.put(key,Math.max(LCS(str1, str2, n, m - 1, memo),
                LCS(str1, str2, n - 1, m, memo)));
      }
    
      // return the subproblem solution from the map
      return memo.get(key);
    }
another way of memoization
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
      return backtrack(text1,text2,len1,len2,dp);
    }
    
    public int backtrack(String a , String b , int n, int m ,int[][]dp){
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        if(n==0 || m==0)
            return   0 ;
        else  if(a.charAt(n-1)==b.charAt(m-1)){
           // System.out.println()
           return 1+backtrack(a,b,n-1,m-1,dp);
        }
           
        else{
            int op= Math.max(backtrack(a,b,n-1,m,dp),
                            backtrack(a,b,n,m-1,dp)       );
            dp[n][m]=op;
        }
        return dp[n][m];
            
        }
}

///////////////////////////////////////////////////top down dp///////////////////////////////
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      int len1=text1.length();
        int len2=text2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i =1;i<dp.length;i++){
            for(int j  =1;j<dp[i].length;j++){
               
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                     dp[i][j]=1+dp[i-1][j-1];
                    System.out.println(dp[i][j]);
                }
                   
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[len1][len2];
        
    }
}
