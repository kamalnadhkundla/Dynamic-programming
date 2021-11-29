/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 

Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
*/

// this code is an extension to count of subsetsum difference
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length,i,j,sum=0,count=0;
        for(i=0;i<n;i++)
           sum+=nums[i];
        if((target+sum)%2 != 0 || sum<Math.abs(target)) 
            return 0;
        
        sum=(target+sum)/2;  
        int[][] dp=new int[n+1][sum+1];
        for(i=0;i<n+1;i++)
           for(j=0;j<sum+1;j++)
           {   if(j==0) dp[i][j]=1;
               else dp[i][j]=0;
           }
        
        for(i=1;i<n+1;i++)
        for(j=0;j<sum+1;j++)
            {   if(nums[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j] + dp[i-1][j-nums[i-1]];
            }
        return dp[n][sum];
}
}
