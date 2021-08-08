import java.util.ArrayList;
import java.util.Scanner;

public class ��������_8771{

public static void main(String[]args){
        Scanner scan=new Scanner(System.in);

        int T;

        T=scan.nextInt();

        for(int i=0;i<T; i++){
        long N,A,B;

        N=scan.nextInt();
        A=scan.nextInt();
        B=scan.nextInt();

        long result=Solution(N,A,B);
        System.out.println("#"+(i+1)+" "+result);
        }
        }

public static long Solution(long n,long a,long b){
        long cnt=n-2;
        long minSum=0;
        long maxSum=0;
        long result=0;
        if(a>b||(n< 2&&a!=b)){
        return 0;

        }else{
        minSum=a*cnt;
        maxSum=b*cnt;
        result=maxSum-minSum+1;
        return result;
        }
        }
        }
