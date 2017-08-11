import java.util.*;
import java.io.*;

public class LongestCommonSubsequenceRec {

    private static String A = "ABCDABEEG";
    private static String B = "ACEBABEE";

    public static void main(String[] args){
        int l1 = A.length()-1;
        int l2 = B.length()-1;

        System.out.println("The length of LCS is: "+LCS(l1, l2));
    }

    private static int LCS(int l1, int l2){
        // Base case 
        if(l2==0 || l1==0){
            return 0;
        }
        if(A.charAt(l1)==B.charAt(l2)){
            return 1+LCS(l1-1, l2-1);
        }
        return Math.max(LCS(l1-1, l2), LCS(l1, l2-1));
    }
}