the problem statement is minimum no of insertions to make string a into string b
idea is take out the common sequence and subtract its length from first string length we get deletions,same from the second string we get insertions
public class Main{
    public static void main(String[] args) {
        String x="heap";
        String y ="pea";
        String[][] dp=new String[x.length()+1][y.length()+1];
        for(int i =0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]="";
            }
        }

        for(int i=1;i<dp.length;i++){
            for(int j =1;j<dp[i].length;j++){
                if(x.charAt(i-1)==y.charAt(j-1))
                    dp[i][j]=x.charAt(i-1)+dp[i-1][j-1];
                else
                    dp[i][j]=dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
            }
        }
        System.out.println(dp[x.length()][y.length()]);

        System.out.println("deletions"+(x.length()-dp[x.length()][y.length()].length()));
        System.out.println("insertions"+ (y.length()-dp[x.length()][y.length()].length()));
    }
}
