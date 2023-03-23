package dat.backend.model.entities;

import java.util.List;

public class Order_Item_View {
    List<Order_Item_View> orderItemViewList;
    private int order_id;
    private String email;
    private String cupcake_type;
    private float total_price;
    private int quantity;

    public Order_Item_View(int order_id, String email, String cupcake_type, float total_price, int quantity) {
        this.order_id = order_id;
        this.email = email;
        this.cupcake_type = cupcake_type;
        this.total_price = total_price;
        this.quantity = quantity;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getEmail() {
        return email;
    }

    public String getCupcake_type() {
        return cupcake_type;
    }

    public float getTotal_price() {
        return total_price;
    }

    public int getQuantity() {
        return quantity;
    }
}

