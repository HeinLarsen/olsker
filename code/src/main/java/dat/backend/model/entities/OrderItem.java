package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private int id;
    private int orderId;
    private int quantity;
    private Top top;
    private Bottom bottom;

    public OrderItem(int id, int orderId, int quantity, Top top, Bottom bottom) {
        this.id = id;
        this.orderId = orderId;
        this.quantity = quantity;
        this.top = top;
        this.bottom = bottom;
    }

    public OrderItem(Top top, Bottom bottom, int quantity) {
        this.quantity = quantity;
        this.top = top;
        this.bottom = bottom;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Top getTop() {
        return top;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public double getTotalPrice() {
        return quantity * (top.getPrice() + bottom.getPrice());
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", top=" + top +
                ", bottom=" + bottom +
                '}';
    }
}
