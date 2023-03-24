package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public List<Cupcake> cupcakeList = new ArrayList<>();

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
    public List<Cupcake> getCupcakeList()
    {
        return cupcakeList;
    }
    public void ClearCart()
    {
        cupcakeList.clear();
    }



}
