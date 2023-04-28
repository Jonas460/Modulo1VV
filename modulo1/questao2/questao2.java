import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    public void setup() {
        cart = new ShoppingCart();
        product1 = new Product("Teclado", 100.00);
        product2 = new Product("Monitor", 200.00);
    }

    @Test
    public void testCartItemCountWhenCreated() {
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testCartItemCountWhenEmpty() {
        cart.empty();
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testCartItemCountAfterAddingProduct() {
        cart.addItem(product1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testCartBalanceAfterAddingProduct() {
        cart.addItem(product1);
        assertEquals(100.00, cart.getBalance(), 0.001);
        cart.addItem(product2);
        assertEquals(300.00, cart.getBalance(), 0.001);
    }

    @Test
    public void testCartItemCountAfterRemovingProduct() throws ProductNotFoundException {
        cart.addItem(product1);
        cart.addItem(product2);
        cart.removeItem(product1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testProductNotFoundExceptionWhenRemovingNonExistingProduct() {
        assertThrows(ProductNotFoundException.class, () -> {
            cart.removeItem(product1);
        });
    }
}