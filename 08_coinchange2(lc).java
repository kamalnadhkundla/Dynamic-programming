/* no of ways to get the sum
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

 

Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 
A recursion approach for this solution is include or exclude -> givmes time limit error so,it is an dp apporach problem
public class Main
{
	public static void main(String[] args) {
		int[] arr= {2,5,3,6};
		int len=arr.length;
		int ch=10;
		System.out.print(solve(arr,3,10));
		
	}
	public static int solve(int[] arr, int n, int ch){
	     if (ch== 0) {
        return 1;
    }
	    if(n<0 || ch<0) return 0;
	    
	    int inc = solve(arr,n,ch-arr[n]);
	    int ex=solve(arr,n-1,ch);
	    return inc+ex;

}
another way
    public static int backtrack(int[] arr, int i , int sum){

        if(sum<0 || i>=arr.length)
            return 0;
        if(sum==0)
            return  1;
        else
        {
            if(arr[i]>sum)
                return    backtraack(arr,i+1,sum);
            else
                return  backtraack(arr,i,sum-arr[i])+backtraack(arr,i+1,sum);
        }
    }




*/
top-down Dp solution:
class Solution {
   
    public int change(int n, int[] arr) {
        
         int[][] dp=new int[arr.length+1][n+1];

       for(int i =0;i<dp.length;i++)
           dp[i][0]=1;
       for(int j=1;j<dp[0].length;j++)
           dp[0][j]=0;

       for(int i =1;i<dp.length;i++){
           for(int j=1;j<dp[i].length;j++){
               if(arr[i-1]<=j)
                   dp[i][j]=dp[i-1][j]+dp[i][j-arr[i-1]];
               else
                   dp[i][j]=dp[i-1][j];
           }
       }
        return dp[arr.length][n];
    }
}
dp memorization
class Solution {
    public int change(int amount, int[] coins) {
        
        
        return totalWays(coins,amount,0,new HashMap<String,Integer>());
     
    }
    
    int totalWays(int[] coins, int amount, int currCoin, HashMap<String,Integer>map){
        
        if(amount == 0){
            return 1;
        }
        
        if(currCoin >= coins.length){
            return 0;
        }
        
        String currentKey = currCoin + "_" + amount;
        
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int consider = 0;
        
        if(coins[currCoin] <= amount){
            consider = totalWays(coins,amount-coins[currCoin],currCoin,map);
        }
        
        int notConsider = totalWays(coins,amount,currCoin+1,map);
        
        map.put(currentKey,consider+notConsider);
        return map.get(currentKey);
        

    }
}
