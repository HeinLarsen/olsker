package dat.backend.model.entities;

import java.util.ArrayList;

public class ShoppingCart {
    private Order order;

    public Order getOrder() {
        return order;
    }
    public void addOrder(Order order) {
        this.order = order;
    }
    public void removeOrder() {
       this.order = null;
    }
    public double getTotalPrice() {
        return order.getTotalPrice();
    }

}
