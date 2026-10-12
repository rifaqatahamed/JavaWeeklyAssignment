class Cart {
    private final int[] prices;
    private int itemCount;
    private final String cartId;
    public Cart(String cartId, int maxItems) {
        if (maxItems < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        this.cartId = cartId;
        this.prices = new int[maxItems];
        this.itemCount = 0;
    }
    public void addItem(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (itemCount >= prices.length) {
            throw new IllegalStateException("Cart is full");
        }
        prices[itemCount] = price;
        itemCount++;
    }
    public int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }
    public int getItemCount() {
        return itemCount;
    }
    public String getCartId() {
        return cartId;
    }
}
public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println(cart.getTotal());     // 500
        System.out.println(cart.getItemCount()); // 3
        System.out.println(cart.getCartId());    // CART-5
    }
}