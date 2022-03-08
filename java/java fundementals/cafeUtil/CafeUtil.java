import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(){
        int sum = 0;
        for (int i = 0 ; i<=10 ;i++){
            sum +=i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total = 0;
        for (int i =0 ; i<prices.length;i++){
            total +=prices[i];
        }
        return total;
    }

    public void displayMenu(){
        System.out.println("----- Try Show Menu-----");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        for (int i = 0; i < 4; i++) {
            System.out.println(menu.get(i) );
    }

    }

    public void addCustomer(){
        ArrayList<String> customer = new ArrayList<String>();
        customer.add("Kamal");
        customer.add("osaid");
        customer.add("saad");
        customer.add("ahmad");
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            System.out.println(customer.get(i) );
    }
}
}