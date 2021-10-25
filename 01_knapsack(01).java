/*
recursion
*/
/* A Naive recursive implementation
of 0-1 Knapsack problem */
class Knapsack {
 
    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b)
    {
      return (a > b) ? a : b;
    }
 
    // Returns the maximum value that
    // can be put in a knapsack of
    // capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;
 
        // If weight of the nth item is
        // more than Knapsack capacity W,
        // then this item cannot be included
        // in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
 
        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        else
            return max(val[n - 1]
                       + knapSack(W - wt[n - 1], wt,
                                  val, n - 1),
                       knapSack(W, wt, val, n - 1));
    }
 
    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}




/*
memorization
public class Main
{
	public static void main(String[] args) {
		int[] weigths=new int[]{1,3,4,5};
		int[] profit=new int[]{1,4,5,7};
		int weight=7;
		int[][] dp=new int[weigths.length+1][weight+1];
		
		
		System.out.println(knapsack(weigths,profit,weight,weigths.length,dp));
	}
	public static int knapsack(int[] weights, int[] profits, int weight , int len,int[][]dp){
	    if(dp[len][weight]!=0)
	         return dp[len][weight];
	    if(weight==0 || len==0){
	        return 0;
	    }
	    
	    int x=0;
	    if(weights[len-1]<=weight){
	      x= profits[len-1]+ knapsack(weights,profits,weight-weights[len-1],len-1,dp);
	    }
	   int y= knapsack(weights,profits,weight,len-1,dp);
	   dp[len][weight]= Math.max(x,y);
	   return dp[len][weight];
	    
	}
}

*/

top-down dp

public class Main
{
	public static void main(String[] args) {
		int[] weigths=new int[]{1,3,4,5};
		int[] profit=new int[]{1,4,5,7};
		int weight=7;
		int[][] dp=new int[weigths.length+1][weight+1];
		for(int i =0;i<=weight;i++)
		    dp[0][i]=0;
		    
		for(int i =0;i<=weigths.length;i++)
		  dp[i][0]=0;
		for(int i=1;i<=weigths.length;i++)
		{
		    for(int j=1;j<=weight;j++){
		        // check if the weight the valid if valid 2 options pick or not pick
		        if(weigths[i-1]<=j)
		        {
		            dp[i][j]=Math.max(profit[i-1]+dp[i-1][j-weigths[i-1]],dp[i-1][j]);
		        }
		        else //not valid case
		          dp[i][j]=dp[i-1][j];
		    }
		}
		
		System.out.println(dp[weigths.length][weight]);
		
		
	
	}
}
