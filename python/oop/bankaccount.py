class bankaccount:
    def __init__(self,interest_rate,balance):
        self.interest_rate=interest_rate
        self.balance=balance
        
    def deposit(self,amount):
        self.balance +=amount
        return self.balance
    def withdraw(self,amount):
        self.balance -=amount   
        return self.balance
    def display_account_info(self):
        print(self.balance)
    def yield_interest(self):
        self.balance=self.balance * (self.interest_rate + 1)
        return self.balance

account1=bankaccount(0.02,500)
account2=bankaccount(0.03,700)


account1.deposit(200)
account1.deposit(100)
account1.deposit(100)
account1.withdraw(200)
account1.yield_interest()
account1.display_account_info()

account2.deposit(200)
account2.deposit(500)
account2.withdraw(100)
account2.withdraw(100)
account2.withdraw(200)
account2.withdraw(100)
account2.yield_interest()
account2.display_account_info()


