class user:
    def __init__(self,name,age,email):
        self.name=name
        self.age=age
        self.email=email
        self.account=bankaccount(interest_rate=0,balance=0)
        
    def make_deposits(self,amount):
        self.account.balance += amount
    def make_withdrawal(self,amount):
        self.account.balance -=amount
    def display_user_balance(self):
        self.account.balance=self.account.deposit-self.account.withdrawal
        print(self.account.balance)
    def transfere_money(self,name,amount):
        self.account.balance=self.account.balance-amount
        name.account.balance=name.account.balance+amount
        print(self.name,self.account.balance)
        print(name.name,name.account.balance)
