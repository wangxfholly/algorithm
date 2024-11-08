package org.learn.dp;

public class ChargeExchange {
    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 5;
//        System.out.println(chargeExchange(coins, amount));
        int[] coins = {2};
        int amount = 3;
        System.out.println(chargeExchange(coins, amount));

    }

    public static int chargeExchange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
