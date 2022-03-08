public class Test {
    public static void main(String[] args){
        Order order1 = new Order();
        String a = order1.getOrderName();
        System.out.println(a);
        order1.setOrderStatus(true);
        System.out.println(order1.getStatusMessage()); 
        Items capuccino = new Items("capuccino",1.5);
        Items mocha = new Items("mocha",2);
        order1.addItem(capuccino);
        order1.addItem(mocha);
        order1.display();
        }
    }

