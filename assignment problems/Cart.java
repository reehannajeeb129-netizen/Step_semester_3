public class Cart {
    private final String cartId;
    private final int[] prices;
    private int count = 0;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new int[maxItems];
    }

    public boolean addItem(int price) {
        if (count >= prices.length || price < 0) return false;
        prices[count++] = price;
        return true;
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) total += prices[i];
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }
}
