import java.util.ArrayList;
public class Order {
    private String name;
    private boolean ready;
    ArrayList<Items> items = new ArrayList<Items>();

    public Order(){
        this.name = "Guest";
        
    }
    public Order(String name , Boolean ready){
        this.name = name ;
        this.ready = ready;
    }
    public String getOrderName(){
        return this.name;
    }
    public void setOrderName(String name){
        this.name = name;
    }
    public Boolean getOrderStatus(){
        return this.ready;
    }
    public void setOrderStatus(Boolean ready){
        this.ready = ready;
    }

    public void addItem(Items item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if (this.ready == true){
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon";
        }
    }


    public void display(){
        System.out.println("customer name :" + this.name);
        for(int i = 0 ; i<this.items.size();i++){
            System.out.println(this.items.get(i).getName() + "-" + this.items.get(i).getPrice());
        }
        double total = this.getTotal();
        System.out.println(total);
    }
    public double getTotal(){
        double total = 0;
        for(int i = 0 ; i<this.items.size();i++){
            total += this.items.get(i).getPrice();
        }
        return total;
    }
}
    
