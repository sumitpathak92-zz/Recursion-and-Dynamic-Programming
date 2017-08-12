import java.util.*;
import java.io.*;
import java.util.Scanner;
public class spoj_AIBOHP {
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                String str = sc.next();
                char[] c = str.toCharArray();
                System.out.println(findMinRec(c, 0, c.length-1));
                System.out.println(findMinDP(c, c.length));
            }
    }
    private static int findMinRec(char[] str, int l, int h){
        //base cases
        if(l>h) return Integer.MAX_VALUE;
        if(l==h) return 0;
        if(l==h-1) return str[l]==str[h]?0:1;
        return str[l]==str[h]?findMinRec(str, l+1, h-1):(Integer.min(findMinRec(str, l, h-1), findMinRec(str, l+1, h))+1);
    }

    private static int findMinDP(char[] str, int n){
        int dp[][] = new int[n][n];
        int l, h, gap;
        for(gap=1;gap<n;++gap){
            for(l=0, h=gap; h<n; ++l, ++h){
                dp[l][h] = (str[l]==str[h])?dp[l+1][h-1]:(Integer.min(dp[l+1][h], dp[l][h-1])+1);
            }
        }
        return dp[0][n-1];
    }
}