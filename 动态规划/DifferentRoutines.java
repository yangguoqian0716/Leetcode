package Leetcode;
    //路径一：
    class Solution1 {
        public int uniquePaths(int m, int n) {
            int[][]dp=new int[m][n];
            for(int i=0;i<m;i++){dp[i][0]=1;}
            for(int j=0;j<n;j++){dp[0][j]=1;}
            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }
    }

    //路径二：设置障碍
    class Solution2 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length;
            int n=obstacleGrid[0].length;
            int[][] dp=new int[m][n];
            if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1){
                return 0;
            }
            for(int i=0;i< m && obstacleGrid[i][0]==0;i++){
                dp[i][0]=1;
            }
            for(int j=0;j< n && obstacleGrid[0][j]==0;j++){
                dp[0][j]=1;
            }
            for(int i=1;i< m;i++){
                for(int j=1;j <n;j++){
                    dp[i][j]=(obstacleGrid[i][j]==0)?dp[i-1][j]+dp[i][j-1]:0;
                }
            }
            return dp[m-1][n-1];
        }
    }

