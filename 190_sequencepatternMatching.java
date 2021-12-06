/*

 given two strings check if a present in b or b present in a in a sequential order we know that lcs of any 2 strings is common letters in both of the strings such that
 minimum length from the two strigns
 
*/
public class solution{
  
 public static int LCS(string X, string Y, int n, int m) {
	int dp[n + 1][m + 1]; // DP - matrix

	// base case of recursion --> for initialization of dp - matrix
	for (int i = 0; i <= n; i++)
		for (int j = 0; j <= m; j++)
			if (i == 0 || j == 0)
				dp[i][j] = 0;

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			if (X[i - 1] == Y[j - 1])
				dp[i][j] = 1 + dp[i - 1][j - 1];
			else
				dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);

	return dp[n][m];
}

public static boolean SeqPatternMatching(string X, string Y, int n, int m) {
	return LCS(X, Y, n, m) == min(n, m); // condition to get sequence // if string x is there in y print boolean value according to LCS 
}
  public static void main(String[] args){
    
    System.out.println(SeqPatternMatching("AXY","ADXCPY"3,6);
                       }
                       }
