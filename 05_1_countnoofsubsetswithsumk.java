/*
You are given an array (0-based indexing) of positive integers and you have to tell how many different ways of selecting the elements from the array are there such that the sum of chosen elements is equal to the target number “tar”.
Note:
Two ways are considered different if sets of indexes of elements chosen by these ways are different.

Input is given such that the answer will fit in a 32-bit integer.
For Example:
If N = 4 and tar = 3 and the array elements are [1, 2, 2, 3], then the number of possible ways are:
{1, 2}
{3}
{1, 2}
Hence the output will be 3.
*/
public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here..
        int[][] dp = new int[num.length+1][tar+1];
        for(int i =0;i<dp.length;i++) 
            dp[i][0]=1;
        for(int i =1;i<=tar;i++)
            dp[0][i]=0;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<=tar;j++){
                if(num[i-1]<=j)
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-num[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[num.length][tar];
    }
}
