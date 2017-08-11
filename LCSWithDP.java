import java.util.*;
import java.io.*;

public class LCSWithDP {

    private static String A = "AKLAKLAKLA";
    private static String B = "AKHGLLA";

    public static void main(String[] args) {
        int m = A.length();
        int n = B.length();
        // using the bottom up approach of DP
        int[][] dp = new int[m+1][n+1];

        //setting the base cases
        for(int i=0;i<=m; i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n; j++){
            dp[0][j]=0;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println("Length of LCS DP :"+dp[m][n]);
    }
}