class user:
    def __init__(self,name,age,email):
        self.name=name
        self.age=age
        self.email=email
        self.account_withdrawal=0
        self.account_deposit=0
        self.account_balance=0
    def make_deposits(self,amount):
        self.account_deposit=self.account_deposit + amount
    def make_withdrawal(self,amount):
        self.account_withdrawal=self.account_withdrawal+amount
    def display_user_balance(self):
        self.account_balance=self.account_deposit-self.account_withdrawal
        if self.account_balance>0 :
            print("the balance is",self.account_balance)
        else :
            print("not enough balance")
    def transfere_money(self,name,amount):
        self.account_balance=self.account_balance-amount
        name.account_balance=name.account_balance+amount
        print(self.name,self.account_balance)
        print(name.name,name.account_balance)



ahmad = user("ahmad",24,"ahmad@yahoo")
ahmad.make_deposits(300)
ahmad.make_deposits(200)
ahmad.make_deposits(100)
ahmad.make_withdrawal(100)
ahmad.make_withdrawal(600)



ahmad.display_user_balance()

# abed=user("abed",23,"abed@gmail")

# abed.make_deposits(300)
# abed.make_deposits(200)
# abed.make_withdrawal(200)
# abed.make_withdrawal(100)
# abed.display_user_balance()

# mubark=user("mubark",26,"mubark@hotmail.com")
# mubark.make_deposits(500)
# mubark.make_withdrawal(200)
# mubark.make_withdrawal(50)
# mubark.make_withdrawal(100)


# ahmad.transfere_money(abed,400)