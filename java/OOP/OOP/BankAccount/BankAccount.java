public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int counter;
    private static double totalMoney ;

    public static int getCounter(){
        return counter;
    }
    public BankAccount(double check ,double save){
        counter++;
        this.checkingBalance = check;
        this.savingsBalance = save ;
    }
    public double getCheck(){
        return this.checkingBalance;
    }
    public double getSave(){
        return this.savingsBalance;
    }

    public void addToCheck(double money){
        this.checkingBalance += money;
    }
    public void addTosaving(double money){
        this.savingsBalance += money;
    }

    public void withdrawFromChecking(double money){
        if(this.checkingBalance - money < 0 ){
            System.out.println("sorry, not enough money");
        }
        else {
            this.checkingBalance -= money;
        }
    }
    public void withdrawFromSaving(double money){
        if(this.savingsBalance - money < 0 ){
            System.out.println("sorry, not enough money");
        }
        else {
            this.savingsBalance -= money;
        }
    }
    public void display(){
        System.out.println(this.checkingBalance);
        System.out.println(this.savingsBalance);
    }
}

