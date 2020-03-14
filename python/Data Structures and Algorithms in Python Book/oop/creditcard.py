class CreditCard:
    
    def __init__(self, customer, bank, accnt, limit):
        self.__customer = customer
        self.__bank = bank
        self.__account= accnt
        self.__limit = limit
        self.__balance = 0

    def get_customer(self):
        return self.__customer
    
    def get_bank(self):
        return self.__bank
    
    def get_account(self):
        return self.__account
    
    def get_limit(self):
        return self.__limit
    
    def get_balance(self):
        return self.__balance
    
    def charge(self, price):
        if price + self.__balance > self.__limit:
            return False
        else:
            self.__balance += price
            return True
    
    def make_payment(self, amount):
        self.__balance -=  amount
    
    def __str__(self):
        return 'Customer: {}, Bank: {}, Account: {}, Limit: {}'.format(
            self.__customer, 
            self.__bank, 
            self.__account, 
            self.__limit)
    
if __name__ == '__main__':
    cc = CreditCard('Gs Su', 'CITI BANK', '1234 5678 9012', 10000)
    print(cc)
    