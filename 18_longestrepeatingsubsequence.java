Given a string str, find the length of the longest repeating subsequence such that it can be found twice in the given string. The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B.

Example 1:

Input:
str = "axxxy"
Output: 2
Explanation:
The given array with indexes looks like
a x x x y 
0 1 2 3 4

The longest subsequence is "xx". 
It appears twice as explained below.
  
 we can see that the repeating subsequence characters occur more than once so taking all the characters  by ignoring only once occuring characters and by doing lcs you can ask
 me why do we need to do lcs when we can do map frequency occur like that but we need to get subsequence right so lcs gives an subsequence string in lcs there is small modificatin
 ignoreing only once occuring character
 for example :
GIVEN STRING -" A A B E B C D D"
                 0 1 2 3 4 5 6 7
               " A A B E B C D D"  |-> lcs->"A A B E B C D D" HOW WE IGONRE ONLY ONCE OCCURED CHARACTERS  SEE BY GIVING INDEXES A OCCURS 0 1,B OCCURS 2,4 D OCCURS 6,7 
               " A A B E B C D D"  |           E OCCURS 3,3-> SAME   C OCCURS 5,5 SO WE INGORE I==J IN LCS
          
          
          
 class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int[][] dp = new int[str.length()+1][str.length()+1];
        
        for(int i =1;i<dp.length;i++){
            for(int j =1;j<dp[i].length;j++){
                if(str.charAt(i-1)==str.charAt(j-1) &&i!=j){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[str.length()][str.length()];
    }
}
