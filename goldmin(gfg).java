/*
Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. Find out maximum amount of gold he can collect. 
Examples: 
 

Input : mat[][] = {{1, 3, 3},
                   {2, 1, 4},
                  {0, 6, 4}};
Output : 12 
{(1,0)->(2,1)->(1,2)}

Input: mat[][] = { {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}};
Output : 16
(2,0) -> (1,1) -> (1,2) -> (0,3) OR
(2,0) -> (3,1) -> (2,2) -> (2,3)

Input : mat[][] = {{10, 33, 13, 15},
                  {22, 21, 04, 1},
                  {5, 0, 2, 3},
                  {0, 6, 14, 2}};
Output : 83


1.create a new matrix
2.store all the first column values of all rows from the given matrix into resulatant matrix.
3. then check with the following conditons for each cell
                                          1. is the left cell is valid take it else take 0
                                          2.is the left upper daigonal is valid take it else take 0
                                          3.is the left lower daiogonal is valid take it else take 0
 4. take out the max value of all three then assign that mine[row][col] maxvalue+exisiting value from the given matrix
 5.check the maximum value for last column for all rows return that maximum
 */
public class Main
{
	public static void main(String[] args) {
	int[][] gold ={ {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}};
    
    int m=gold.length;
    int n=gold[0].length;
    int[][] mine= new int[m][n];
   for(int i =0;i<m;i++){
       mine[i][0]=gold[i][0];
       
   }
   for(int col=1;col<n;col++){
       for(int row=0;row<m;row++){
           int left=mine[row][col-1];
           int leftup=(col==0 || row==0)?0:mine[row-1][col-1];
           int leftdown=(row==m-1 ||col==0)?0:mine[row+1][col-1];
           int res=Math.max(left,Math.max(leftdown,leftup));
           mine[row][col]=res+gold[row][col];
       }
   }
   
   for(int i=0;i<mine.length;i++){
       for(int j=0;j<mine[i].length;j++){
           System.out.print(mine[i][j]+" ");
       }
       System.out.println();
   }
   int max=0;
   for(int i=0;i<m;i++){
       max=Math.max(max,mine[i][n-1]);
   }
   System.out.print("max"+max);
    
	}
}
