package dat.backend.model.entities;

import java.util.ArrayList;

public class Cupcake {

    private ArrayList<Top> top;
    private ArrayList<Bottom> bottom;
    private int quantity;

    public Cupcake(ArrayList<Top> top, ArrayList<Bottom> bottom, int quantity) {
        this.top = top;
        this.bottom = bottom;
        this.quantity = quantity;
    }

    public ArrayList<Top> getTop() {
        return top;
    }

    public ArrayList<Bottom> getBottom() {
        return bottom;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return top.getPrice() + bottom.getPrice();
    }

    public String getName() {
        return top.getName() + " " + bottom.getName();
    }


}