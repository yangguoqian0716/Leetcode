package Leetcode;
import java.util.Scanner;

public class CoinsChange322 {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入amount：");
//        int amount=sc.nextInt();
//        System.out.println("请输入硬币的个数：");
//       int n=sc.nextInt();
//        System.out.println("请输入营部的面值：");
//        int[] coins= new int[3];
//        int n=coins.length;
//        for(int i=0;i<n;n++){
//            coins[i]=sc.nextInt();
//        }
//       sc.close();
        int[] coins={1,2,5};
        int amount=11;
        int res=CoinChange.coinsChange(coins,amount);
        System.out.println("硬币个数="+res);
    }
}
 class CoinChange{
    public static int coinsChange(int[] coins,int amount){
        int n=coins.length;
        int[] f=new int[amount+1];
        f[0]=0;
        for(int i=1;i<=amount;i++){
            f[i]=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(i>=coins[j]&&f[i-coins[j]]!=Integer.MAX_VALUE){
                    f[i]=Math.min(f[i-coins[j]]+1,f[i]);
                }
            }
        }
        if(f[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return f[amount];
    }
 }