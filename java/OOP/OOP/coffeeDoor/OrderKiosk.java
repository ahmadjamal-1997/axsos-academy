import java.util.ArrayList;

public class OrderKiosk {

    private ArrayList<Items> menu;
    private ArrayList<Order> orders;

    public OrderKiosk(){
        menu = new ArrayList();
        orders = new ArrayList();
    }

    public void addItem(String name , double price , int index){
        Items item1 = new Items(name,price,index);
        menu.add(item1);
    }

}
