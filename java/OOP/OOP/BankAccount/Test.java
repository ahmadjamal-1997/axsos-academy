public class Test {
    public static void main(String[] args){
        BankAccount customer1 = new BankAccount(300,500);
        BankAccount customer2 = new BankAccount(400,600);
        BankAccount customer3 = new BankAccount(200,600);
        customer1.display();
        System.out.println(BankAccount.getCounter());
        customer2.addToCheck(250);
        customer2.display();
        customer3.withdrawFromChecking(100);
        customer3.display();
    }
}
