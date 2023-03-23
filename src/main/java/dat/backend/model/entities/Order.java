package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Order_Item_View> orderItemsList = new ArrayList<>();
    private int id;
    private int user_id;
    private Timestamp created;

    public Order(int id, int user_id, Timestamp created) {
        this.id = id;
        this.user_id = user_id;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public Timestamp getCreated() {
        return created;
    }
    public void addToOrderList(Order_Item_View order_item_view){
        orderItemsList.add(order_item_view);

    }

    public List<Order_Item_View> getOrderItemsList() {
        return orderItemsList;
    }
}
