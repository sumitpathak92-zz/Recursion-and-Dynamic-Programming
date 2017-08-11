import java.util.*;
import java.io.*;

public class CoinChangeProblemDP{
    private static int[] denominations = {2, 3, 5};
    public static void main(String[] args){
        System.out.println("Minimum no of coins required :"+calculateMinCoinsRec(denominations, denominations.length, 5));
    }
    private static int calculateMinCoinsRec(int[] denom, int m, int sum){
        if(sum==0) return 0; //base case 
        int res = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            if(denom[i]<=sum){
                int s_res = calculateMinCoinsRec(denom, m, sum-denom[i]);
                if(s_res!=Integer.MAX_VALUE && s_res+1<res)
                    res = s_res+1;
            }
        }
        return res;
    }

}
