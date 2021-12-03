/*

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

Recursion and memorization solution.
import java.util.HashMap;

public class Main {
    static HashMap<String, Integer> hashmap;

    public static void main(String[] args) {
        hashmap = new HashMap<>();
        int[] arr = new int[]{1, 2, 5};
        int sum = 11;
        int min=getcoins(arr,sum,arr.length);
        if(min==(int)1e4)
            System.out.println(-1);
        else
            System.out.println(min);

        System.out.println(memo(arr,sum,arr.length,new HashMap<>()));
        System.out.println(dpp(arr,sum));
    }
    public static int getcoins(int[] arr , int sum, int n ){
        if(n==0 || sum==0)
        {
            if(sum==0)
                return 0;
            else
                return(int) 1e4;
        }

        if(arr[n-1]>sum)
            return 0+getcoins(arr,sum,n-1);
        else
            return Math.min(0+getcoins(arr,sum,n-1),1+getcoins(arr,sum-arr[n-1],n));
    }

    public static int memo(int[] arr , int sum, int n , HashMap<String ,Integer> map){
        if(map.containsKey(n+""+sum))
            return map.get(n+""+sum);
        if(n==0 || sum==0)
        {
            if(sum==0)
                return 0;
            else
                return(int) 1e4;
        }
        if(arr[n-1]>sum)
           map.put(n+""+sum,0+memo(arr,sum,n-1,map));
        else
            map.put(n+""+sum,Math.min(0+memo(arr,sum,n-1,map),1+memo(arr,sum-arr[n-1],n,map)));

        return map.get(n+""+sum);

    }
     public static int dpp(int[] arr ,  int sum ){
        int[][] dp = new int[arr.length+1][sum+1];

        for(int i=1;i<dp[0].length;i++)
            dp[0][i]=(int)1e4;

        for(int i =1;i<dp.length;i++){
            for(int j =1;j<dp[0].length;j++){
                if(arr[i-1]<=j)
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-arr[i-1]]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[arr.length][sum];
    }
}
*/ optimization than top-down dp 
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
       int n =coins.length; 
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<=amount;i++)
            dp[0][i]=Integer.MAX_VALUE-1;
        for (int i=1;i<=n;i++)
            dp[i][0]=0;
        
        for(int j=1;j<=amount;j++){
            if(j % coins[0] == 0)
                dp[1][j] = j/coins[0];
            else
                dp[1][j] = Integer.MAX_VALUE-1;
        }
        
        for(int i =2;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j)
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                else
                    dp[i][j]=dp[i-1][j];
                
            }
        }
        return dp[coins.length][amount]>amount?-1:dp[coins.length][amount];
        
        
       
    }
}
