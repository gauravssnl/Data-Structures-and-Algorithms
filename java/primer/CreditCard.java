package primer;

/**
 * A simple model for a consumer credit card.
 * 
 * @author Gaurav
 */
public class CreditCard {
    // Instance variables
    private String customerName;
    private String bankName;
    private String accountId;
    private int limit;
    protected double balance;

    /**
     * Construct a new credit card instance.
     * 
     * @param customerName  the name of the customer
     * @param bankName      the name of the bank
     * @param accountId     the accoundt ID
     * @param limit         the credit limit ( measured in dollars )
     * @param initalBalance the initial balance ( measured in dollars )
     */
    public CreditCard(String customerName, String bankName, String accountId, int limit, double initialBalance) {
        this.customerName = customerName;
        this.bankName = bankName;
        this.accountId = accountId;
        this.limit = limit;
        this.balance = initialBalance;
    }

    /**
     * Construct a new credit card instance with intial balance as zero.
     * 
     * @param customerName the name of the customer
     * @param bankName     the name of the bank
     * @param accountId    the accoundt ID
     * @param limit        the credit limit ( measured in dollars )
     */
    public CreditCard(String customerName, String bankName, String accountId, int limit) {
        this.customerName = customerName;
        this.bankName = bankName;
        this.accountId = accountId;
        this.limit = limit;
        this.balance = 0;
    }

    /**
     * Charges the given price to the card assuming sufficient credit limit.
     * 
     * @param price the amount to be charged
     * @return true if charge was accepted; false otherwise
     */
    public boolean charge(double price) {
        if (price + balance > limit)
            return false;
        balance += price;
        return true;
    }

    /**
     * Process customer payment that reduces balance.
     * 
     * @param amount the amount of payment made
     */
    public void makePayment(double amount) {
        balance -= amount;
    }

    // Accessor methods
    public String getCustomerName() {
        return customerName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAccountId() {
        return accountId;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "CreditCard [accountId=" + accountId + ", balance=" + balance + ", bankName=" + bankName
                + ", customerName=" + customerName + ", limit=" + limit + "]";
    }

    
}
