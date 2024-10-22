this is an lcs varaition problem
Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
  for example string x =geek and y = eke
  we formed a string geeke which has both x and y as subsequences
  and it is shortest string that can be formed
  another example say x="aggtab" y ="gxtxayb" now form longest common subsequence out of it which is "gtab" and length of strings x+y=13 we know that lcs="gtab" occurs twice (once in x and 
  once in y) so subtract 2*lcs(lenght) from total length gives 5 as difference . now lcs will be common in new string however so 4(length of lcs) + 5(remaining character) gives the
  shortest supersquence length.
   in the first example geek and ek have a lcs of ek which is size =2; now 2*2->4 subtract from total length which 7-4=3(remaining non common letters) then 3+2=5 length of shortest common supersequence
   so we just need to return the length the size of shortest supersequence.
     
   ---------------------------------- IN GFG WE NEED TO RETURN THE LENGTH OF SHORTEST SUPERSEQUENCE IN LEETCODE WE NEED TO RETURN THE STRING----------------------------
     GFG:
class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        
        int len =m+n;
        int[][] dp = new int[m+1][n+1];
        for(int i =1;i<dp.length;i++){
        for(int j =1;j<dp[i].length;j++){
            if(X.charAt(i-1)==Y.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
            else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
        }
        
        int l =dp[m][n];
        int diff = len-2*l;
        return l+diff;
    }
}
LEETCODE(HARD ->1092):
// we need to know how to print lcs string dont think blindly in lcs when we add plus one in dp table means a common character we may even get the same common character again by again adding 
plus one so there is another approach to solve comming from bottom to top apporach 
public class Solution{
    

public String shortestCommonSupersequence(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];
        for(int i = 0; i <= l1; i++){
            for(int j = 0; j <= l2; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        StringBuilder result = new StringBuilder();
        int i = l1, j = l2;
        while(i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                result.append(s1.charAt(i - 1));
                i--;
                j--;
            }else{
                if(dp[i - 1][j] > dp[i][j - 1]) {
                    result.append(s1.charAt(i - 1));
                    i--;
                }
                else {
                    result.append(s2.charAt(j - 1));
                    j--;
                }
            }
        }
        while(i > 0){
            result.append(s1.charAt(i - 1));
            i--;
        }
        while(j > 0){
            result.append(s2.charAt(j - 1));
            j--;
        }
        return result.reverse().toString();
    }
}
