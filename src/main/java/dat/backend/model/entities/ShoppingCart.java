package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public ArrayList<Cupcake> cupcakeList = new ArrayList<>();

    public ShoppingCart()
    {
    }
    public void add(Cupcake cupcake)
    {
        cupcakeList.add(cupcake);
    }
    public int GetNumberOfCupcakes()
    {
        return cupcakeList.size();
    }
    public int totalPrice() {
        int sum = 0;
        for (int i = 0; i < cupcakeList.size(); i++)
        {
            sum += cupcakeList.get(i).getTotalPrice();
        }
        return sum;
    }
    public ArrayList<Cupcake> getCupcakeList() {
        return cupcakeList;
    }
    public ArrayList<Cupcake> cupcakes() {
        return cupcakeList;
    }
    public void ClearCart()
    {
        cupcakeList.clear();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cupcakeList=" + cupcakeList +
                '}';
    }


}
