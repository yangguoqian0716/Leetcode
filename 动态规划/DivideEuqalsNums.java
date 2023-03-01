package Leetcode;
//416. 分割等和子集
public class DivideEuqalsNums {
    public static void main(String[] args) {
     int[] arr={1,5,5,11};
     boolean res=solution06.canPartition(arr);
     System.out.println(res);
    }
}
class solution06{
    public static boolean canPartition(int[] nums){
        if(nums==null||nums.length==0)return false;
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum % 2!=0) return false;
        int targrt=sum/2;
        int[] dp=new int[targrt+1];
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=targrt;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[targrt]==targrt;
    }
}