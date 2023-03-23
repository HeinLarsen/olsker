package dat.backend.model.entities;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderItemsList = new ArrayList<>();
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
    public void addToOrderList(OrderItem orderItem){
        orderItemsList.add(orderItem);

    }

    public List<OrderItem> getOrderItemsList() {
        return orderItemsList;
    }
}
