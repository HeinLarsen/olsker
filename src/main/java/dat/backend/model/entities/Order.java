package dat.backend.model.entities;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private User user;
    private boolean isPaid;
    private Timestamp created;
    private List<OrderItem> orderItems = new ArrayList<>();


    public Order(int id, User user, Timestamp created, boolean isPaid) {
        this.id = id;
        this.user = user;
        this.created = created;
        this.isPaid = isPaid;
    }

    public Order(User user) {
        this.user = user;
        this.isPaid = false;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public Timestamp getCreated() {
        return created;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItemList(List<OrderItem> orderItemList){
        orderItems.addAll(orderItemList);
    }

    public void addItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public void removeItem(int id){
        for (OrderItem i : orderItems) {
            if (i.getId() == id) {
                orderItems.remove(i);
            }
        }
    }

    public double getTotalPrice() {
        double sum = 0;
        for (OrderItem i : orderItems) {
            sum += i.getTotalPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", isPaid=" + isPaid +
                ", created=" + created +
                ", orderItems=" + orderItems +
                '}';
    }
}
