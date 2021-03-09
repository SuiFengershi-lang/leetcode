/*
* 一个机器人位于一个 m x n 网格的左上角, 机器人
* 每次只能向下或者向右移动一步, 机器人试图达到网格的右
* 下角, 现在考虑网格中有障碍物, 求出从左上角到右下角的总路径数
* */
package mianshizhinan.dp;

public class dp2 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0 ,1, 0},
                {0, 0, 0}
        };
        int res = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;        // 行数
        int n = obstacleGrid[0].length;     // 列数
        obstacleGrid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {       // 初始化第一列的值
            if (obstacleGrid[i][0] != 1) {  // 不是障碍
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            } else {
                obstacleGrid[i][0] = 0;     // 碰到障碍
            }
        }
        for (int j = 1; j < n; j++) {       // 初始化第一行
            if (obstacleGrid[0][j] != 1) {
                obstacleGrid[0][j] = obstacleGrid[0][j - 1];
            } else {
                obstacleGrid[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
