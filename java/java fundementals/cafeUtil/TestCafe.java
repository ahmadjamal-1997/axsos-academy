public  class  TestCafe {
    public  static  void main( String [] args) {
        CafeUtil appTest = new CafeUtil();
        System .out.println( "\n----- Test Meta coffee -----" );
        System.out.println("----- Test Total Order -----");
        double[ ] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order Total: %s \n\n",appTest.getOrderTotal(lineItems));
        appTest.displayMenu();
        System .out.println("\n-----Try add customer-----");
        appTest .addCustomer();
        }
    }
    