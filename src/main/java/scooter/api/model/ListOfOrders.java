package scooter.api.model;

import java.util.ArrayList;

public class ListOfOrders {

    private ArrayList<Orders> orders;

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }
}
