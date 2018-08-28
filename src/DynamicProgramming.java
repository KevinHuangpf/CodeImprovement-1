import java.util.Scanner;

public class DynamicProgramming {

    public static void main(String[] args) {
        int[] a = {3,5,1};
        int target=5;
        System.out.println(dPMoneyNumber(a,target));

        int[][] array={
                {7,0,0,0,0},
                {3,8,0,0,0},
                {8,1,0,0,0},
                {2,7,4,4,0},
                {4,5,2,6,5}

        };
        // System.out.println(MaxLength(array));


    }


    public static int MaxLength(int[][] array){
        int n =array.length;
        for(int i =n-1;i>=0;i--){
            for(int j =0;j<i;j++){
                array[i-1][j]+= Math.max(array[i][j],array[i][j+1]);

            }
        }
        return array[0][0];

    }

    public static int dPMoneyNumber(int a[],int target){

        int n = a.length;
        //使用前n中的货币凑成target的种数
        int[][] dp = new int[n][target+1];

        //用任意n种钱合成0块钱 当然一定是一种
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }

        for(int i=1;a[0]*i<=target;i++){
            dp[0][a[0]*i] = 1;
        }


        for(int i=1;i<n;i++){
            for(int j =0;j<=target;j++){
                if(a[i]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i][j-a[i]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n-1][target];


    }



    public static int dPMoney(int a[],int targrt){
        int dpLen = targrt+1;
        int[] dp = new int[dpLen];

        for(int i=0; i<dpLen;i++){
            dp[i]=i;
        }

        for(int i =0;i<dpLen;i++){
            for (int j=0;j<3;j++){
                if(a[j]<=i && (dp[i-a[j]]+1 < dp[i]))
                    dp[i]=dp[i-a[j]]+1;

            }
        }

        return dp[targrt];

    }
}
