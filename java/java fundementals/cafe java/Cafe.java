public class Cafe {
    public static void main (String[] args){
        double filtercoffee = 5;
        double latte = 4.5;
        double cappuccino = 5.5;

        String client1 = "sam";
        String client2 = "jimmy";
        String client3 = "Noah";

        boolean isOrderReady1 =  true ;
        boolean isOrderReady2 =  true ;
        boolean isOrderReady3 =  false ;

        if (isOrderReady3 == false){
            System.out.println("order is not ready");
        }
        else {
            System.out.println("order is ready");
        }

        double bill = 2 * latte;
        System.out.println("the total price is " + bill);

        if (isOrderReady1 == false){
            System.out.println("order is not ready");
        }
        else {
            System.out.println("order is ready");
        }

        System.out.println("jimmy charged for coffee which price is " + filtercoffee);
        System.out.println("jimmy is supposed to be charged for latte which price is " + latte);
        double difference = filtercoffee - latte;
        System.out.println("the resturant owes jimmy  " + difference);
    }
}