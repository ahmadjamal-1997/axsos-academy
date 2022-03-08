public class Items {
    private String name;
    private double price;
    private int index;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getIndex(){
        return this.index;
    }
    public void setIndex(int index){
        this.index = index;
    }

    public Items(String name , double price){
        this.name = name ; 
        this.price = price ;
    }
}
