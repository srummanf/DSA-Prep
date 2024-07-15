/**
 * Recurrence relation
 * f(ind, buy){
 *  if(ind==n) return 0; // reached last day so no point in buying or selling
 * if(buy==1){
 *  profit = Max(-prices[ind] + f(ind+1, 0), f(ind+1, 1))
 * } else{
 *  profit = (Max(prices[ind] + f(ind+1, 1), f(ind+1, 0)
 * }
 * }
 */

public class dp_36_BestTimeToBuyandSellStocks_II {

  public static int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    for (int i = 0; i < n; i++) {
      dp[i][0] = -1;
      dp[i][1] = -1;
    }
    return f_memoization(0, 0, prices, dp);
  }

  public static int f_memoization(int ind, int buy, int[] prices, int[][] dp) {
    if (ind == prices.length) return 0;
    if (dp[ind][buy] != -1) return dp[ind][buy];
    int profit = 0;
    if (buy == 1) {
      profit =
        Math.max(
          -prices[ind] + f_memoization(ind + 1, 0, prices, dp),
          f_memoization(ind + 1, 1, prices, dp)
        );
    } else {
      profit =
        Math.max(
          prices[ind] + f_memoization(ind + 1, 1, prices, dp),
          f_memoization(ind + 1, 0, prices, dp)
        );
    }
    return dp[ind][buy] = profit;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
  }
}