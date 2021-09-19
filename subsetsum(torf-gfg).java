/*

Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

Example: 

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.


method 1: backtracking going through all the possible states and checking the sum -> time complexity would be exponential
public class Main
{
	public static void main(String[] args) {
	int sum=9;
	int[] arr={3, 34, 4, 12, 5, 2};
	
	  int n =arr.length;
	  
	  System.out.println(recur(arr,n,0,sum));
	}
	
	public static boolean recur (int[] arr, int n , int ind,int sum){
	    if(sum==0)
	       return true;
	   if(ind==n) return false;
	   
	   // include
	   boolean x = recur(arr,n,ind+1,sum-arr[ind]);
	   
	   //exclude
	   boolean y= recur(arr,n,ind+1,sum);
	   
	   return x||y;
	   
	    
	}
}
method 2: dp approach
1.intitlize the dp array dp[n+1][sum+1]
2.intitlize the first row and first column as there are zeroes
   i.e for 0 sum the result of all elements in that first column in True as for every  sum 0 we would return true
    and for 0 coin the result of all elements in the first row is false as there we can not form a sum with 0 elements  these are the 2 base cases.
3. go through the every cell in the matrix check the given correspondent row(set[i-1] value )is less than or equal to correspondent column values beacuse the num <= sum to pick it up
4. every cell has two choices same like backtracking whether to pick up that corresponding row-1 value in the set else not picking it up
5. if i pick up that element in that set (sum-set[i-1) ->correspondent column-set[correspondent row-1] . we will get a result that result is the one of  the combination to get that sum
   for example my row value is 1 and coulmn values is 2 (sum) if i do sum-set[1-1] as set[0]=2
       then 2-2 =0 0 says no elements to pick and return true in normal words
       in matrix the result is 0 so it goes back to 0 column and checks the previous state which mean did i pick that coin in my previous state or not as 0 is first row all are true
        returns true
  6. if i dont pick it up i copy previous state sum value to the current state sum value
  ex: Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.


 	    0	1	2	3	4	5	6	7	8	9
0	    t	f	f	f	f	f	f	f	f	f
1(3) 	t	f	f	t	f	f	f	f	f	f
2(34)	t	f	f	t	f	f	f	f	f	f
3(4)	t	f	f	t	t	f	f	t	f	f
4(12)	t	f	f	t	t	f	f	f	f	f
5(5)	t	f	f	t	t	t	f	f	t	t
6(2)	t	f	t	t	t	t	t	t	t	t

row 1: col1: as the value isless than 3 it cannot form sum 1 false
       col2: as the value is less than 3 it cannot form sum 2 false
       col3: as the values is equal to 3 it cannot form sum 3 true
       col4: as the value is greather than 3 but 4-3=1 check in the 1st column in the previous state whether it is a combination of that number to form 4. so no false
       col 5: diff is 2 but same false
       col 6: same false
       col 7: col8: col 8: same false
  row 2: col1::col9 as the value is greater than of all sums so all are false i dont pick but dont pick up is copy the previous state
  row 3: col1: false from previous false from including so false
         col2:false from previous false from including so false
         col3: true from previous false from including so true
         col4: false from previous but includinng that element can form 4-4=0 in 0 sum no more element is required to  form so in previous state it is true so return true
         col5::col6: false from previous state as well as including so false
         col7: false from previous but 7-4 3 in 3 clumn check the previous state it is true so return true
         col 8:col9 false
   row 4: as the value is 12 including the element is not suitable so copy the previous state
   row 5: copy the previous state for all columns
          now from col 5: it can includes 5-5 =0 sum is 0 so true
          col 6: 6-5=1 but in 1 st column in previous state is false as there is no 1 in the set so false
          col 7 :7-5=2 false same conditon above
          col 8 : 8-5 =3 check the 3rd column in the previous state as it is true so return true as it can form combination of 5+3->8
          col 9: 9-5 =4 check the 4rd column in the previous state as it is true so return true as it can form combination of 5+4->9
  row 6:
         copy the previous state for all columns
         col 1 not possble
         col 2:2-2=0 true
         col 3:3-2=1 in 1st colum of previous state is false as it cannot form a combiantion of 1+2=3 so return false
         col 4: true
         col 5: true 5-2=3 in 3rd clumn of previous state is true 2+3=5
         col 6: true ->4+2
         col 7: true 5+2=7
         col 8: true as seen from above state
         col 9: true as seen from above state
         finally return last value in the matrix which is dp[n][sum] true(9)-> can be formed of by one of the combiantion in the set.
         code
         -----
         */


         
          
public class Main
{
	public static void main(String[] args) {
	 int[] set = {3, 34, 4, 12, 5, 2};
	 int sum=30;
	 boolean[][] dp= new boolean[set.length+1][sum+1];
	 
	 for(int i =0;i<=set.length;i++)
	     dp[i][0]=true;
	 for(int i=1;i<=sum;i++)
	     dp[0][i]=false;
	     
	  	   for(int i =1;i<=set.length;i++){
	       for(int j=1;j<=sum;j++ ){
	        dp[i][j]=dp[i-1][j]; // copy the previous state
	          if(set[i-1]<=j){
	               // check the previous combination(true or false) to form that element + this element to form sum 
	               if(dp[i-1][j-set[i-1]]==true )
	                   dp[i][j]=true;
	               
	          }
	       }
	   }
	    System.out.print(dp[set.length][sum]);
	}
}


    
   
