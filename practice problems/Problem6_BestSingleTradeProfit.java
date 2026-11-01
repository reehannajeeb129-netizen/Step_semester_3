public class Problem6_BestSingleTradeProfit {
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int best = 0;
        for (int p : prices) {
            if (p < minPrice) {
                minPrice = p;
            } else if (p - minPrice > best) {
                best = p - minPrice;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
    }
}
