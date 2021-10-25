//recursion
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] arr= new int[]{2,3,7,8,10};
		int sum=11;
	
		System.out.println(backtrack(arr,sum,arr.length-1));
	}
	public static boolean backtrack(int[] arr ,int sum, int ind){
	    if(sum==0)
	     {
	        
	        
	        return true;
	     }
	     if(ind==-1)
	        return false ;
	     
	     if(arr[ind]>sum)
	        return backtrack(arr,sum,ind-1);
	   else
	   return backtrack(arr,sum-arr[ind],ind-1)||backtrack(arr,sum,ind-1);
	     
	}
}

// dp top down

import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int[] arr= new int[]{2,3,7,8,10};
		int sum=11;
	   boolean[][] dp=new boolean[arr.length+1][sum+1];
for(int i =0;i<dp.length;i++)
  dp[i][0]=true;
  for(int j=1;j<=sum;j++)
  dp[0][j]=false;
  
 for(int i =1;i<dp.length;i++){
     for(int j=1;j<dp[i].length;j++){
         if(arr[i-1]<=j)
            dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
        else
          dp[i][j]= dp[i-1][j];
     }
 }


	System.out.println(dp[arr.length][sum]); 
	}

}

