package dat.backend.model.entities;

import java.util.ArrayList;

public class Cupcake {

    private Top top;
    private Bottom bottom;
    private int quantity;

    public Cupcake(Top top, Bottom bottom, int quantity) {
        this.top = top;
        this.bottom = bottom;
        this.quantity = quantity;
    }

    public Top getTop() {
        return top;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public double getTotalPrice() {
        return (top.getPrice() + bottom.getPrice()) * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Cupcake{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", quantity=" + quantity +
                '}';
    }
}