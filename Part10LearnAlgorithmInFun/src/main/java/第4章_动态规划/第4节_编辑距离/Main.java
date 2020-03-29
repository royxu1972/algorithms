/***********************************************************
 * @Description : 编辑距离，代码模式和上一节的最长公共子序列很像
 * LeetCode72 https://leetcode-cn.com/problems/edit-distance/
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2020/3/29 20:03
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package 第4章_动态规划.第4节_编辑距离;

import java.util.Scanner;

public class Main {
    /**
     * 求3个数的最小值
     */
    private int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        // dp[i][j]代表str1[0...i]和str2[0...j]的最长公共子序列.注意此时的下标从1开始
        int[][] dp = new int[m + 1][n + 1];
        // 初始化第1列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        // 给非第1行和第1列的中间元素赋值
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // 字符相等地话直接等于前一个字符串的dp值
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 比较3中情况的最小值(二维栅格中的左边、上边、左上边)，最小值+1就是最终的dp值
                    dp[i][j] = min3(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        System.out.println(new Main().editDistance(word1, word2));
    }
}
/**
 * 4
 */
