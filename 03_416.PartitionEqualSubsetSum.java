/*
this is leetcode  question 416

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

the first thing say if the array is partitoned into two sets which contains equal sum say set as s
two sets =2*s
we know anything multiplied by 2 will be even
so initally we have to check if the sum of total elements in the array is even or not
if it is not even return false
but if it is even we eventially return true but for this particular test case [1,2,5] the sum of total elements is 8 but we can not divided into two sets of equal sum
so we need to check totalsum when halved we get one set sum right !
so we check if the  halfesum can be formed by the elements in the array if it is then there exists an another set
this is simply a subsetsum problem question
*/
recursion (tle)
 --------------------
  class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i :nums)
            sum+=i;
 
        
        if(sum%2!=0)
            return false;
        else
  return  canpartitons(nums,0,0,sum);
        
    }
public boolean canpartitons(int[]nums , int ind, int sum, int total){
    if(sum*2==total)
        return true;
    if(sum>total/2 || ind>=nums.length)
        return false;
    
    return canpartitons(nums,ind+1,sum,total) || canpartitons(nums,ind+1,sum+nums[ind],total);
}
}

memorization 
-------------
note: we cannot take a boolean array as it is false by default we can not have a  base case
  class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i :nums)
            sum+=i;
 
        
        if(sum%2!=0)
            return false;
        else
  return  canpartitons(nums,0,0,sum,new HashMap<String,Boolean>());
      
        
    }
public boolean canpartitons(int[]nums , int ind, int sum, int total ,HashMap<String,Boolean> state) { 
    String current =ind+""+sum; // checking true or false at current array index and sum in a subproblem
    if(state.containsKey(current))
        return state.get(current);
    if(sum*2==total)
        return true;
    if(sum>total/2 || ind>=nums.length)
        return false;
    boolean equalsum=canpartitons(nums,ind+1,sum,total,state)||canpartitons(nums,ind+1,sum+nums[ind],total,state);
    
    state.put(current,equalsum);
    return equalsum;
    
}
   }
// top down dp
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i :nums)
            sum+=i;
  
        if(sum%2!=0)
            return false;
        sum/=2;
        boolean[][]dp=new boolean[nums.length+1][sum+1];
        
        for(int i =0;i<=nums.length;i++){
            for(int j =0;j<=sum;j++)
            {
                if(i==0)
                    dp[i][j]=false;
                if(j==0)
                    dp[i][j]=true;
               
               
            }
        }
        
  
        for(int i=1;i<=nums.length;i++){
            for(int j =1;j<=sum;j++){
                if(nums[i-1]<=j)
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }   
       
        
          return dp[nums.length][sum];  
        }
    
   
}


