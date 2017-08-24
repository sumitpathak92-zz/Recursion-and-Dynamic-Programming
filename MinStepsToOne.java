import java.util.*;
import java.io.*;

public class MinStepsToOne{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println("Minimum steps to one for "+N+" is "+minStepsToOne(N));
    }

    static int minStepsToOne(int N){
        int memo[] = new int[N+1];
        for(int i=0;i<N;i++){
            memo[i] = -1; //initially set array to -1
        }
        if(N==1) return 0; //base case
        if(memo[N]!=-1) return memo[N];

        int r = 1+minStepsToOne(N-1);
        if(N%2==0) r = Integer.min(r, 1+minStepsToOne(N/2));
        if(N%3==0) r = Integer.min(r, 1+minStepsToOne(N/3));
        memo[N] = r;
        return r;
    }
}