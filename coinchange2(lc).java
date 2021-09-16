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

Dp solution:
public class Main
{
	public static void main(String[] args) {
	
int[] coins ={2,5,3,6 };
int sum=10;


int[][] dp= new int[sum+1][coins.length+1];
// if sum is 0 then i return 1 according to the base case 
// if coins are 0 then no other coins can be taken   
// 1. Intialiaztion
for(int i=0;i<coins.length+1;i++){
    dp[0][i]=1;
}
for(int i=1;i<sum+1;i++){
   dp[i][0]=0; 
}

// actual computition
for(int i=1;i<sum+1;i++){
    for(int j=1;j<coins.length+1;j++){
        
        // exclude or include operations
        // exclude
        dp[i][j]=dp[i][j-1];
        // include if coins value is less than sum
        if(coins[j-1]<=i)
                    dp[i][j]+=dp[i-coins[j-1]][j];
    }
}
System.out.println("no of ways to attain sum :"+dp[sum][coins.length]);  

}
}
*/
class Solution {
    public int change(int amount, int[] coins) {
        int n=amount;
        int m=coins.length;
        int[][] dp = new int[n+1][m+1];
       for(int i =0;i<=m;i++) dp[0][i]=1;
        for(int j =1;j<=n;j++)dp[j][0]=0;
		for(int i =1;i<=n;i++){
		    for(int  j =1;j<=m;j++){
		        dp[i][j]=dp[i][j-1];
		        
		        if(coins[j-1]<=i){
		            dp[i][j]+=dp[i-coins[j-1]][j];
		        }
		    }
		}
        
        
        return dp[n][m];
        
    }
}
