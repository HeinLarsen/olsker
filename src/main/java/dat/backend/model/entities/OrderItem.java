package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    List<OrderItem> orderItemsList = new ArrayList<>();
    private int id;
    private int order_id;
    private int cupcake_top_id;
    private int cupcake_bottom_id;
    private float cupcake_top_price;
    private float cupcake_bottom_price;
    private int quantity;

    public OrderItem( int id, int order_id, int cupcake_top_id, int cupcake_bottom_id, float cupcake_top_price, float cupcake_bottom_price, int quantity) {
        this.id = id;
        this.order_id = order_id;
        this.cupcake_top_id = cupcake_top_id;
        this.cupcake_bottom_id = cupcake_bottom_id;
        this.cupcake_top_price = cupcake_top_price;
        this.cupcake_bottom_price = cupcake_bottom_price;
        this.quantity = quantity;
    }



    public int getId() {
        return id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getCupcake_top_id() {
        return cupcake_top_id;
    }

    public int getCupcake_bottom_id() {
        return cupcake_bottom_id;
    }

    public float getCupcake_top_price() {
        return cupcake_top_price;
    }

    public float getCupcake_bottom_price() {
        return cupcake_bottom_price;
    }

    public int getQuantity() {
        return quantity;
    }
}
