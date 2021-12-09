Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
 /*
 public class Main{
    public static void main(String[] args) {

        String x="ab";
        System.out.println(solveRecur(x,0,x.length()-1));
        //System.out.println(isPalindrome("aba",0,2));
       // System.out.println("abc".equalsIgnoreCase("abc"));

    }
    // recurence but tle
    public  static  int solveRecur(String x, int i, int j){
        if(i>=j) return 0;

        if(isPalindrome(x,i,j)){
            return 0;
        }
      int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp =solveRecur(x,i,k)+solveRecur(x,k+1,j)+1;

            if(temp<ans) ans=temp;
        }

        return ans;
    }

    public static boolean isPalindrome(String x, int i , int j){

        StringBuilder y=new StringBuilder();
        for(int n=i;n<=j;n++){
            y.append(x.charAt(n));
        }
       System.out.println(y);
        return y.toString().equalsIgnoreCase(y.reverse().toString());
    }
}
// memorized but tle
public    int solveRecur(String x, int i, int j){
    if(i>=j) return 0;

    if(isPalindrome(x,i,j)){
        return 0;
    }
    if(map.containsKey(i+","+j)) return map.get(i+","+j);
    int ans=Integer.MAX_VALUE;
    for(int k=i;k<j;k++){
        int temp =solveRecur(x,i,k)+solveRecur(x,k+1,j)+1;

        if(temp<ans) ans=temp;
    }

    map.put(i+","+j,ans);
    return map.get(i+","+j);
}
// memorized with optimization
*/
  class Solution {
Integer[][] dp;

//Function to check if the string is Palindrome
boolean isPalindrome(String str, int start, int end){
    while(start<end){
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        start++;
        end--;
    }
    return true;
}


int solve(String str, int i, int j){
    //Base Cases
    if(i>=j){
        return 0;
    }
    if(dp[i][j]!=null){
        return dp[i][j];
    }
    
    
    /*If the current string is palindrome then we dont need to break it into 
	further sub problems as we want to minimize the cuts.*/
    if(isPalindrome(str, i, j)){
        dp[i][j]=0;
        return 0;
    }
    
    
    int min = Integer.MAX_VALUE;
    //Trying Different possible cuts between i and j
    for(int k = i; k<=j;k++){
        
        /*An Optimization: We will make the partition only if the string till the partition 
		(till Kth position) is a valid palindrome. Because the question states that all 
		partition must be a valid palindrome. If we dont check this, we will have to 
		perform recursion on the left subproblem too (solve(str, i, k)) and	we will waste 
		a lot of time on subproblems that is not required. Without this the code will give
		correct answer but TLE on big test cases. */
        if(isPalindrome(str, i, k)){
            int partitions = 1+solve(str, k+1, j);
            min = Math.min(min, partitions);                
        }
        
        
    }
    
    //Store answer in the memo table
    dp[i][j]=min;
    return dp[i][j];
}



public int minCut(String s) {
    dp = new Integer[s.length()][s.length()];
    return solve(s, 0, s.length()-1);
}
}
