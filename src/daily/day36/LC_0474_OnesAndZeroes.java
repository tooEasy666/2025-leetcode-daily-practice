package daily.day36;

public class LC_0474_OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        /// 数组有三个维度
        // 第一个维度：取前面的几个字符串
        // 第二个维度：0的数量限制（背包维度 1 容量）
        // 第三个维度：1的数量限制（背包维度 2 容量）
        int[][][] dpArr = new int[strs.length][m + 1][n + 1];

        /// 初始化dpArr数组
        // 计算第一个字符串的零数量和1数量
        int zeroNum = 0;
        int oneNum = 0;
        for (char c : strs[0].toCharArray()) {
            if (c == '0') {
                zeroNum++;
            } else {
                oneNum++;
            }
        }
        // 当0数量、1数量都容得下第一个字符串时，将DP数组的相应位置初始化为1，因为当前的子集数量为1
        for (int j = zeroNum; j <= m; j++) {
            for (int k = oneNum; k <= n; k++) {
                dpArr[0][j][k] = 1;
            }
        }
        /// 依次填充加入第i个字符串之后的DP数组
        for (int i = 1; i < strs.length; i++) {
            zeroNum = 0;
            oneNum = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j >= zeroNum && k >= oneNum) {
                        // --if-- 当0数量维度和1数量维度的容量都大于等于当前字符串的0数量和1数量时，才考虑是否将当前字符串放入背包
                        // 不放入第i个字符串，子集数量仍为 dpArr[i - 1][j][k]
                        // 放入第i个字符串，需要在0维度腾出 zeroNum 个容量，1维度腾出 oneNum 个容量，然后放入当前字符串，即 dpArr[i - 1][j - zeroNum][k - oneNum] + 1)
                        dpArr[i][j][k] = Math.max(dpArr[i - 1][j][k], dpArr[i - 1][j - zeroNum][k - oneNum] + 1);
                    } else {
                        // --if--  无法放入第i个字符串，子集数量仍为 dpArr[i - 1][j][k]
                        dpArr[i][j][k] = dpArr[i - 1][j][k];
                    }
                }
            }
        }
        return dpArr[dpArr.length - 1][m][n];
    }

    public int findMaxForm2D(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
