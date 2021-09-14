/*

   Given a set of n elements, find number of ways of partitioning it. 
Examples: 
 

Input:  n = 2
Output: Number of ways = 2
Explanation: Let the set be {1, 2}
            { {1}, {2} } 
            { {1, 2} }

Input:  n = 3
Output: Number of ways = 5
Explanation: Let the set be {1, 2, 3}
             { {1}, {2}, {3} }
             { {1}, {2, 3} }
             { {2}, {1, 3} }
             { {3}, {1, 2} }
             { {1, 2, 3} }. 
             
             
            -> this can be solved with the help of backtracking ->pick or non pick condition
            ->and take out of duplicates generated using hashset but this result in the more time complexity
  
  using dyanmic programming
  --------------------------
  this can be solved with the dyanmic programming (bell number)
  using bell triangle
1
1 2
2 3 5
5 7 10 15
15 20 27 37 52
steps:
    1.create a  matrix of n+1,n+1 size
    2.fill the first value of a row is the last value of the previous row bell[i][j]=bell[i-1][i-1]
    3.then fill all the remaining values with the previous value of the same row and last value of the previous row
    4.bell[i][j]=bell[i-1][j-1]+bell[i][j-1];
    4.return bell[n][0]
    */
    public class Main
{
	public static void main(String[] args) {
		int n =5;
		int[][] bell = new int[n+1][n+1];
		bell[0][0]=1;
		for(int i =1;i<=n;i++){
		    bell[i][0]=bell[i-1][i-1];
		    for(int j=1;j<=i;j++){
		        bell[i][j]=bell[i-1][j-1]+bell[i][j-1];
		    }
		    
		}
		
		System.out.println(bell[n][0]);
	}
}

