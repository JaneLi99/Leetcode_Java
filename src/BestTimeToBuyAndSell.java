// 121. Best Time to Buy and Sell Stock
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

import java.util.Arrays;
import java.util.OptionalInt;

public class BestTimeToBuyAndSell {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int[] restPrices = Arrays.copyOfRange(prices, i + 1, prices.length);
            Arrays.sort(restPrices);
            int maxPrice = restPrices[restPrices.length - 1];
            if (prices[i] < maxPrice && profit < maxPrice - prices[i]) {
                profit = maxPrice - prices[i];
            }
        }
        return profit;
    }

    public static int maxProfitBetterWay(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfitBetterWay(prices);
        System.out.println("Max profit: " + result);
    }
}
