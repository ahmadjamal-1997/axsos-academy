class bankaccount:
    def __init__(self,interest_rate,balance):
        self.interest_rate=interest_rate
        self.balance=balance
        
    def deposit(self,amount):
        self.balance +=amount
        return self
    def withdraw(self,amount):
        self.balance -=amount   
        return self
    def display_account_info(self):
        print(self.balance)
    def yield_interest(self):
        self.balance=self.balance * (self.interest_rate + 1)
        return self

account1=bankaccount(0.02,500)
account2=bankaccount(0.03,700)


account1.deposit(200).deposit(100).deposit(100).withdraw(200).yield_interest().display_account_info()
account2.deposit(200).deposit(500).withdraw(100).withdraw(100).withdraw(200).withdraw(100).yield_interest().display_account_info()



