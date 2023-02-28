package Leetcode;

public class Bag01 {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
      Solution0.bagMaxValue(weight,value,bagSize);
    }
}
class Solution0{
    public static void bagMaxValue(int[] w,int[] v,int bagSize){
        int n=w.length;
        int[][] dp=new int[n][bagSize+1];

        for(int j=w[0];j<=bagSize;j++){
            dp[0][j]=v[0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=bagSize;j++){
                //由于物品重量大于j而不放入物品
                if(j<w[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=bagSize;j++){
                System.out.println(dp[i][j]);
            }
            System.out.println("");
        }
    }
}