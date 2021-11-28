/*problem is an extension  of Count subsets with given sum.

given an array [3,1,2,3] and x=6 partition the array into two subsets such that the difference between their sum is equal to x .
this problem is an extension to count no of subsets with the given sum .
from 3 1 2 3 and the combinations found to be like this
s1        s2    diff
3,1,2      3      3 ->1
3,3       1,2     3->2
1,2,3       3     3->3
so total no of ways are 3
we know that sum of the subset1 and sum of the subset2 is equal to sum of the array
we know that s1+s2=s
and given    s1-s2=x   where s and x are constants
solving above equations we get s1=(s+x)/2. since the above given problem which is s1-s2=x -> s1=s+x/2 . we just need to find no of ways s1 can be formed.
*/

public class Main
{
	public static void main(String[] args) {
	    int [] arr = new int[]{1,2,3,3};
	    int x=3;
	    int sum=0;
	  for(int i :arr)
	      sum+=i;
	  int sum1 =(sum+x)/2;
	  
	 System.out.println(countnoofsubsetsum(arr,sum1));
	    
	 }
	 public static int countnoofsubsetsum(int[] arr,int sum){
	     int n =arr.length;
	     int[][] dp=new int[n+1][sum+1];
	     for(int i =0;i<dp.length;i++)
	          dp[i][0]=1;
	     for(int i =1;i<=sum;i++)
	           dp[0][i]=0;
	           
	      for(int i =1;i<dp.length;i++){
	          for(int j=1;j<=sum;j++){
	              if(arr[i-1]<=j){
	                  dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
	              }
	              else
	                 dp[i][j]=dp[i-1][j];
	          }
	      }
	      return dp[n][sum];
	 }

}
